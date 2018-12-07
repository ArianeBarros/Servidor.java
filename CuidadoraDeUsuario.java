 import java.io.Serializable;
 import java.io.ObjectInputStream;
 import java.io.ObjectOutputStream;
 import controle.*;
 import controle.enviaveis.*;
 import java.net.ServerSocket;
 import java.net.Socket;
 import java.util.Date;
 import java.util.*;


public class CuidadoraDeUsuario extends Thread
{
    protected boolean morta = false;
	protected String salaDesejada;
	protected Usuario usuario;
	protected ObjectOutputStream oos;
	protected ObjectInputStream ois;
	protected SalasUsuario salas;
	protected AvisoDeSaidaDaSala avisoSaida;
	protected String nome;
	protected Socket socket;
	protected Enviavel recebido;
	protected SalaUsuario sala;
	protected  AvisoDeEntradaNaSala aviso;

  public CuidadoraDeUsuario(Socket conexao, SalasUsuario salas) throws Exception
  {
	 this.socket = conexao;
	 this.oos = new ObjectOutputStream(this.socket.getOutputStream());
	 this.ois = new ObjectInputStream(this.socket.getInputStream());
	 this.salas = salas;
  }

  public void run()
  {
	try
	{

		   this.oos.writeObject(this.salas.getNomes());	  //1
		   this.oos.flush();
		   this.salaDesejada = (String)ois.readObject();	//2
		   this.nome = (String)ois.readObject();	//3


		   this.sala = this.salas.descobrirSala(this.salaDesejada);
			this.oos.writeObject(this.sala.getNomeUsuarios());
		    if(this.sala.jaExiste(nome))
		       throw new Exception("Já existe um usuário com esse nome aqui");

		   this.usuario = new Usuario(this.socket, this.oos, this.ois, this.nome, this.sala);

		   this.sala.adicionarUsuario(this.usuario);

		   for(Usuario user: this.sala.getUsuarios())
		   	user.enviar(new AvisoDeEntradaNaSala(this.nome));

		  	while(!morta)
		  	{
				Enviavel e = (Enviavel)this.ois.readObject();
			System.out.println(e.getClass().getName());
			switch(e.getClass().getName())
			{
				case "Mensagem": e = (Mensagem)e;break;
				case "AvisoDeEntradaNaSala": e = (AvisoDeEntradaNaSala) e;break;
				case "AvisoDeSaidaDaSala": e = (AvisoDeSaidaDaSala)e; break;
				case "PedidoParaSairDaSala":morra(); e = (PedidoParaSairDaSala) e;break;
			}

			if(!(e instanceof PedidoParaSairDaSala))
				for(Usuario user: this.sala.getUsuarios())
					user.enviar(e);
			}

			this.sala.excluirUsuario(this.usuario);
			for(Usuario user: this.sala.getUsuarios())
				user.enviar(new AvisoDeSaidaDaSala(this.nome));

			this.usuario.fechaTudo();

		}
		catch(Exception err)
		{
		}
  }

  public void morra()
  {
	  this.morta = true;
  }

}