package controle.enviaveis;
import java.net.*;
import java.util.*;

public class AvisoDeSaidaDaSala implements Enviavel
{

 // SalaUsuario sala;
 // SalasUsuario salas;
  ObjectOutputStream transmissor;
  String nick;


  public AvisoDeSaidaDaSala(Socket conexao, String nome)
  {
   // this.sala = new SalaUsuario();
   // this.salas = new SalasUsuario();
    this.transmissor = new ObjectOutputStream(conexao.getInputStream());
    this.nick = nome;
  }

  public void envia()
  {
	  this.sala.excluirUsuario();
	  transmissor.println(this.nick + " saiu da sala");
  }

}