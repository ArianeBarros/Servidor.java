package controle.enviaveis;
import java.net.*;
import java.util.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.*;

public class AvisoDeSaidaDaSala implements Enviavel, Serializable
{
  protected  String nick;


  public AvisoDeSaidaDaSala(String nome)throws Exception
  {
    this.nick = nome;
  }

  public String getNick()
  {
	  return this.nick;
  }

  public String envia()
  {
	  return this.nick + " saiu da sala";
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

	  AvisoDeSaidaDaSala aviso = (AvisoDeSaidaDaSala)obj;



	  if(!this.nick.equals(aviso.nick))
	  	return false;

	  	return true;
  }

  public int hashCode()
  {
	  int ret=7;
	  ret=ret*13+nick.hashCode();

	  return ret;
  }
}

















