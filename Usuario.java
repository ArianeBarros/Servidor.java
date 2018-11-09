import java.io.*;
import java.io.BufferedReader;
import java.net.Socket;
//enfia o usu na sla e a sla no usu

public class Usuario implements Comparable<Usuario>
{
	private Sala sala; // a mesma sala da mean, com um ponteio l� e outro ca
	private String nickname;
	private Socket socket;
	private BufferedReader receptor;
	private PrintWriter transmissor;

	public Usuario(Socket conexao, PrintWriter transmissor, BufferedReader receptor, String nome, Sala sala) throws Exception
	{
		//validar parametros TODOS, por causa das antinhas
		//GUARDAR PARAMETROS NOS ATRIBUTOS
		//guardar conex�o
		//instanciar PrintWriter e BufferedReader
		//mandar todos os nomes de salas

		if(conexao == null) // n�o sei
			throw new Exception("Socket inv�lido!");
		if(transmissor == null)
			throw new Exception("PrintWriter inv�lido!");
		if(receptor == null)
			throw new Exception("BufferedReader inv�lido!");
		if(nome == null)
			throw new Exception("Nome inv�lido!");
		if(sala == null)
			throw new Exception("Sala inv�lida!");

		try
		{
			this.socket = conexao;
			this.transmissor = new PrintWriter(conexao.getOutputStream());
			this.receptor = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
			this.nickname = nome;
			this.sala = new Sala(sala);
		}
		catch(Exception e)
		{
			throw new Exception("Socket de conex�o inv�lido");
		}
	}

	public String toString()
	{
		return "Usu�rio" + this.nickname + "Receptor:" + this.receptor + "Transmissor:" + this.transmissot;
	}

	public int hashCode()
	{
		int ret = 2;
		ret = ret * 2 + this.nickname.hashCode();
		ret = ret * 2 + this.socket.hashCode();
		ret = ret * 2 + this.transmissor.hashCode();
		ret = ret * 2 + this.receptor.hashCode();
	}

	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;

		if(obj == null)
			return false;

		if(this.getClass()!= obj.getClass())
			return false;

		Usuario u = (Usuario)obj;

		if(!this.nickname.equals(u.nickname))
			return false;

		if(!this.socket.equals(u.socket))
			return false;

		if(!this.transmissor.equals(u.transmissor))
			return false;

		if(!this.receptor.equals(u.receptor))
			return false;

		if(!this.sala.equals(u.sala))
			return false;

		return true;
	}

	public int compareTo(Usuario u)
	{
		return this.nickname.compareTo(u.nickname);
	}

	public String getNickname()
	{
		return this.nickname;
	}

	public Socket getSocket()
	{
		return this.socket;
	}

	public BufferedReader getReceptor()
	{
		return this.receptor;
	}

	public PrintWriter getTransmissor()
	{
		return this.transmissor;
	}

	public void envia()
	{

	}

	public void recebe() //pode ser String, ou , A SALA � UMA GUARDADORA DE USUARIOS, SALAS � GUARDADORA DE SALAS
	{
		//usar o receptor
	}
}