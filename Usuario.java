import java.io.*;
import java.io.BufferedReader;
import java.net.Socket;
//enfia o usu na sala e a sala no usu

public class Usuario implements Comparable<Usuario>
{
	private Sala sala; // a mesma sala da mean, com um ponteio lá e outro ca
	private String nickname;
	private Socket socket;
	private ObjectInputStream receptor;
	private ObjectOutputStream transmissor;

	public Usuario(Socket conexao, ObjectOutputStream transmissor, ObjectInputStream receptor, String nome, Sala sala) throws Exception
	{
		//validar parametros TODOS, por causa das antinhas
		//GUARDAR PARAMETROS NOS ATRIBUTOS
		//guardar conexão
		//instanciar PrintWriter e BufferedReader
		//mandar todos os nomes de salas

		if(conexao == null) // não sei
			throw new Exception("Socket inválido!");
		if(transmissor == null)
			throw new Exception("PrintWriter inválido!");
		if(receptor == null)
			throw new Exception("BufferedReader inválido!");
		if(nome == null)
			throw new Exception("Nome inválido!");
		if(sala == null)
			throw new Exception("Sala inválida!");

		try
		{
			this.socket = conexao;
			this.transmissor = new ObjectOutputStream(conexao.getOutputStream());
			this.receptor = new ObjectInputStream(new InputStreamReader(conexao.getInputStream()));
			this.nickname = nome;
			this.sala = new Sala(sala);
		}
		catch(Exception e)
		{
			throw new Exception("Socket de conexão inválido");
		}
	}

	public String toString()
	{
		return "Usuário" + this.nickname + "Receptor:" + this.receptor + "Transmissor:" + this.transmissot;
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

	public ObjectInputStream getReceptor()
	{
		return this.receptor;
	}

	public ObjectOutputStream getTransmissor()
	{
		return this.transmissor;
	}

	//ver isso
	public void envia(Enviavel x)
	{
		// uma instancia de uma classe que herda de enviavel
		this.transmissor = writeObject();
		this.receptor = flush();
	}

	public Enviavel recebe() //pode ser String, ou , A SALA É UMA GUARDADORA DE USUARIOS, SALAS É GUARDADORA DE SALAS
	{
		//usar o receptor
	}

	public void fechaTudo()
	{
		this.transmissor.close();
		this.receptor.close();
		this.conexao.close();
	}
}