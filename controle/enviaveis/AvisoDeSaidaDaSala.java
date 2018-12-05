package controle.enviaveis;
import java.net.*;
import java.util.*;
 import java.io.ObjectInputStream;
 import java.io.ObjectOutputStream;
import java.io.*;

public class AvisoDeSaidaDaSala implements Enviavel
{

 // SalasUsuario salas;
  protected ObjectOutputStream transmissor;
  protected  String nick;


  public AvisoDeSaidaDaSala(Socket conexao, String nome)throws Exception
  {
   // this.sala = new SalaUsuario();
   // this.salas = new SalasUsuario();
   if(transmissor == null)
	  throw new Exception("PrintWriter inválido!");

    this.transmissor = new ObjectOutputStream(conexao.getOutputStream());
    this.nick = nome;
  }

  public String envia()
  {
	  try
	  {
		  this.transmissor.writeObject(this.nick.toString() + "saiu da sala");
		  this.transmissor.flush();

	  }
	  catch(IOException error)
	  {
	    System.out.println(error);
	  }

	  return "";
  }

  public String toString()
  {
	  return "o nome do usuário é"+this.nick;
  }

  public boolean equals(Object obj)
  {
	  if(this==obj)
	      return true;
	  if(obj==null)
	     return false;

	 if(this.getClass()!=obj.getClass())
	 	return false;
	  	AvisoDeSaidaDaSala aviso = (AvisoDeSaidaDaSala)aviso;

	  if(!this.transmissor.equals(aviso.transmissor))
	  	return false;

	  if(!this.nick.equals(aviso.nick))
	  	return false;

	  	return true;
  }

  public int hashCode()
  {
	  int ret=7;
	  ret=ret*11+transmissor.hashCode();
	  ret=ret*13+nick.hashCode();

	  return ret;
  }
}

















