 import java.io.Serializable;
 import java.io.ObjectInputStream;
 import java.io.ObjectOutputStream;
 import controle.*;
 import controle.enviaveis.*;
 import java.net.ServerSocket;
 import java.net.Socket;
 import java.util.Date;

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

	  this.oos = new ObjectOutputStream(conexao.getOutputStream());
	  this.ois = new ObjectInputStream(conexao.getInputStream());

     this.salaDesejada = (String)ois.readObject();
     this.nome = (String)ois.readObject();
     this.salas = salas;

      if(this.sala.jaExiste(nome))
         throw new Exception("Já existe um usuário com esse nome aqui");

      this.usuario = new Usuario(conexao, this.oos, this.ois, this.nome, this.sala);

      this.aviso = new AvisoDeEntradaNaSala(this.nome);

  }

  public void run()
  {
	try
	{
	  while(!morta)
	  {
			for(int i = 0; i < this.sala.getQtd(); i++)
			{
			  this.sala.getUsuario(i).enviar(aviso);
			}
			do
			{
				if(recebido instanceof Mensagem)
				{
					recebido.envia();

					System.out.print("O usuario quer enviar alguma mensagem");
				}
				else
				{
					if(recebido instanceof AvisoDeSaidaDaSala)
					{
						for(int i =0; i < this.sala.getQtd(); i++)
						{
							  avisoSaida = new AvisoDeSaidaDaSala(socket, nome);
						}
					}
				}
			}
			while(!(recebido instanceof PedidoParaSairDaSala));

			this.sala.excluirUsuario(this.usuario);

			for(int i =0; i < this.sala.getQtdAtual(); i++)
			{
				avisoSaida = new AvisoDeSaidaDaSala(socket, nome);
			}

			this.usuario.fechaTudo();
			morra();
	}}
		catch(Exception err)
		{
		}
  }

  public void morra()
  {
	  this.morta = true;
  }

}