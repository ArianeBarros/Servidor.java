package controle.enviaveis;
import java.net.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.*;

public class AvisoDeSaidaDaSala implements Enviavel
{

 // SalasUsuario salas;
  ObjectInputStream transmissor;
  String nick;


  public AvisoDeSaidaDaSala(Socket conexao, String nome)
  {
   // this.sala = new SalaUsuario();
   // this.salas = new SalasUsuario();
   if(transmissor == null)
	  throw new Exception("PrintWriter inválido!");
    this.transmissor = new ObjectInputStream(conexao.getInputStream());
    this.nick = nome;
  }

  public void envia()
  {
      this.transmissor.writeObject(this.nick + "saiu da sala");
      this.transmissor.flush();
  }

}