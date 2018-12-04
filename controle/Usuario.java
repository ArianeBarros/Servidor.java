package controle;
import java.io.*;
import java.io.BufferedReader;
import java.net.*;
import java.util.*;
import controle.enviaveis.Enviavel;
//enfia o usu na sala e a sala no usu

public class Usuario implements Serializable
{
	//private SalaUsuario<Usuario> sala; // a mesma sala da main, com um ponteiro lá e outro ca
	protected String nickname;
	protected Socket socket;
	protected ObjectInputStream receptor;
	protected ObjectOutputStream transmissor;

	public Usuario(Socket conexao, ObjectOutputStream transmissor, ObjectInputStream receptor, String nome, SalaUsuario sala) throws Exception //SalaUsuario sala,
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


		try
		{
			this.socket = conexao;
			this.transmissor = new ObjectOutputStream(conexao.getOutputStream());
			receptor = new ObjectInputStream(conexao.getInputStream());
			//this.receptor = new ObjectInputStream(new InputStreamReader(conexao.getInputStream()));
			this.nickname = nome;

			//this.sala = new SalaUsuario<Usuario>(sala);
		}
		catch(Exception e)
		{
			throw new Exception("Socket de conexão inválido");
		}
	}

	public String toString()
	{
		return "Usuário:" + this.nickname + "Receptor:" + this.receptor + "Transmissor:" + this.transmissor;
	}

	public int hashCode()
	{
		int ret = 2;
		ret = ret * 2 + this.nickname.hashCode();
		ret = ret * 2 + this.socket.hashCode();
		ret = ret * 2 + this.transmissor.hashCode();
		ret = ret * 2 + this.receptor.hashCode();

		return ret;
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

/*		if(!this.sala.equals(u.sala))
			return false;
*/
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

	public void enviar(Enviavel coisa)throws Exception //pode ser String, ou , A SALA É UMA GUARDADORA DE USUARIOS, SALAS É GUARDADORA DE SALAS
	{
       this.transmissor.writeObject(coisa.toString());
       this.transmissor.flush();
        //this.receptor
		//usar o receptor
	}

	public void fechaTudo()throws Exception
	{
		try
		{
			this.transmissor.close();
			this.receptor.close();
			this.socket.close();
		}
		catch(Exception error)
		{
			throw new Exception(error);
		}
	}
}