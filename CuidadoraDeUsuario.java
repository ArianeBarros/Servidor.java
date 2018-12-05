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
	//protected SalaUsuario sala;
	protected SalasUsuario salas;
	protected AvisoDeSaidaDaSala avisoSaida;
	protected String nome;
	protected Socket socket;
	protected Enviavel recebido;
	protected SalaUsuario sala;
	protected  AvisoDeEntradaNaSala aviso;
//em cada sala o usuario poderia ter um nome diferente
//E para trocar de sala, tem rodar a janelinha denovo

  public CuidadoraDeUsuario(Socket conexao, SalasUsuario salas) throws Exception //SalasUsuario sala -- salas ou sala??
  {
	  this.socket = conexao;
	  //declarar e instanciar OOS e OIS, usando o Socket recebido
	  this.oos = new ObjectOutputStream(conexao.getOutputStream());
	  this.ois = new ObjectInputStream(conexao.getInputStream());

      //interagir com o usuário via OOS e OIS até descobrir o nome da sala em que ele deseja entrar, eventualmente, informando sala cheia

     this.nome = (String)ois.readObject();
     this.salaDesejada = (String)ois.readObject();

      this.salas = new SalasUsuario();

       this.sala = new SalaUsuario(this.salas.descobrirSala(salaDesejada));

      if(this.sala.jaExiste(nome))
         throw new Exception("Já existe um usuário com esse nome aqui");

      this.usuario = new Usuario(conexao, this.oos, this.ois, this.nome, this.sala);

      this.aviso = new AvisoDeEntradaNaSala(this.nome);
  }
//quando a pessoa sair da sala esse run para
  public void run()throws Exception//Toda a interação necessária com o socket recebido por parametro
  {
	  while(!morta)
	  {
		  try
		  {
                for(int i = 0; i < this.sala.getQtd(); i++)
                {
				  this.sala.getUsuario(i).enviar(aviso);
			    }
		    //procurar em salas(param)  a sala com o nome desejado
		  	  //interagir com o usuário via OOS e OIS para descobrir o nome que ele deseja usar, eventualmente, retornando nome invalido ou ja usado(usar metodo da Sala)
		  	  //instanciar 1 Usuario, fornecendo conexao, OOS, OIS, sala e nome
		  	  //fazer varias vezes this.usuario.envia(new AvisoDeEntradaDaSala(i)), onde i é o nome de algum usuario que já estava na sala --ArrayList de usuarios
		  	  //fazer varias vezes i.envia(new AvisoDeEntradaDaSala(this.usuario.getNome())), onde i é o nome de algum usuario que já estava na sala --ArrayList de usuarios
	  //incluir o usuario na sala




		  //avisar todo mundo q eu entri

			  //nada antes deste for infinito, pq o que era p estar aqui deve estar no construtor
					//for(;;)
					//{
						//parar este for quando houver o pedido para sair da sala
				//}

			do                 //break   -- mandar uma mensagem ou sair da sala -> a run acaba
			{
				//recebe primeiramente mensagens
				//pedido de saida da sala -- break
				//receber avisos de entrada e saida

				//recebido = oos.read();

				if(recebido instanceof Mensagem)
				{
					//recebido = new Mensagem();

					recebido.envia();

					System.out.print("O usuario quer enviar alguma mensagem");

				}
				else
				{
					if(recebido instanceof AvisoDeSaidaDaSala)
					{
						for(int i =0; i < this.sala.getQtd(); i++) //pq nao funciona this.sala.size();??
						{
							  avisoSaida = new AvisoDeSaidaDaSala(socket, nome);


					    }
					}

				}
			}
			while(!(recebido instanceof PedidoParaSairDaSala));

            //remover this.usuario da sala
			this.sala.excluirUsuario(this.usuario);

            //mandar para todos da sala um aviso avisando que ele saiu da sala
			//new AvisoDeSaidaDaSala(this.usuario.getNome());
			for(int i =0; i < this.sala.getQtdAtual(); i++)
			{
				//Usuario notificar = this.sala.getUsuario(i);
				avisoSaida = new AvisoDeSaidaDaSala(socket, nome);
			}

			this.usuario.fechaTudo();
			morra();
		}
		catch(Exception erro)
		{
			throw new Exception(erro);
		}
    }
  }

  public void morra()
  {
	  this.morta = true;
  }

}
//A cuidadora do remetente
//chama os metodos de receber do usuario e cuida
//recebe mensagem e destinatario
//procura na sala o destinatario e manda

//A cuidadora do destinatario
//recebe a mensagem
//envia a resposta(mensagem e destinatario)


//--A cuidadora dos outros chama o enviar do usuario




//pode tter uma classe só com avisos de entrada e saida




/*Usuario
  -getNome
  -public void envia()

  -public String recebe()

  -
ObjectOutPutStream(VETORR/ArrayList) -- pw(TUDO STRINGGGGG)
ObjectInputStream(VETORRR/ArrayList) -- bf(TUDO STRINGGGGG)
*/