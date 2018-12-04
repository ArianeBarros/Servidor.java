package controle.enviaveis;
import java.net.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.*;

public class AvisoDeSaidaDaSala implements Enviavel
{

 // SalasUsuario salas;
  ObjectOutputStream transmissor;
  String nick;


  public AvisoDeSaidaDaSala(Socket conexao, String nome)throws Exception
  {
   // this.sala = new SalaUsuario();
   // this.salas = new SalasUsuario();
   if(transmissor == null)
	  throw new Exception("PrintWriter inválido!");

    this.transmissor = new ObjectOutputStream(conexao.getOutputStream());
    this.nick = nome;
  }

  public void envia()
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
  }

}