package controle;
import java.io.*;
import java.io.BufferedReader;
import java.net.*;
import java.util.*;
import controle.enviaveis.Enviavel;
import java.util.ArrayList;


public class Usuario implements Serializable
{
	private SalaUsuario sala; // a mesma sala da main, com um ponteiro l� e outro ca
	protected String nickname;
	protected Socket socket;
	protected ObjectInputStream receptor;
	protected ObjectOutputStream transmissor;

	public Usuario(Socket conexao, ObjectOutputStream t, ObjectInputStream r, String nome, SalaUsuario aSala) throws Exception //SalaUsuario sala,
	{
		if(conexao == null) // n�o sei
			throw new Exception("Socket inv�lido!");
		if(t == null)
			throw new Exception("PrintWriter inv�lido!");
		if(r == null)
			throw new Exception("BufferedReader inv�lido!");
		if(nome == null)
			throw new Exception("Nome inv�lido!");


		try
		{
			this.socket = conexao;
			this.transmissor = t;
			this.receptor = r;
			this.nickname = nome;

			this.sala = aSala;
		}
		catch(Exception e)
		{
			throw new Exception("Socket de conex�o inv�lido");
		}
	}

	public ArrayList<Usuario> listaUsers()
	{
		return this.sala.getUsuarios();
	}

	public String toString()
	{
		return "Usu�rio:" + this.nickname + "Receptor:" + this.receptor + "Transmissor:" + this.transmissor;
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



	public void enviar(Enviavel coisa)throws Exception
	{
		try
		{
		   this.transmissor.writeObject(coisa);
		   this.transmissor.flush();
	   }
	   catch(Exception erro)
	   {
		   throw new Exception(erro);
	   }

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