
public class CuidadoraDeUsuario extends Thread
{
	protected String salaDesejada;
	private Usuario usuario;
//em cada sala o usuario poderia ter um nome diferente
//E para trocar de sala, tem rodar a janelinha denovo

  public CuidadoraDeUsuario(Socket conexao, Salas sala) throws Exception
  {

	  //declarar e instanciar OOS e OIS, usando o Socket recebido
	  //interagir com o usuário via OOS e OIS até descobrir o nome da sala em que ele deseja entrar, eventualmente, informando sala cheia
	  //procurar em salas(param)  a sala com o nome desejado
	  //interagir com o usuário via OOS e OIS para descobrir o nome que ele deseja usar, eventualmente, retornando nome invalido ou ja usado(usar metodo da Sala)
	  //instanciar 1 Usuario, fornecendo conexao, OOS, OIS, sala e nome
	  //fazer varias vezes this.usuario.envia(new AvisoDeEntradaDaSala(i)), onde i é o nome de algum usuario que já estava na sala --ArrayList de usuarios
	  //fazer varias vezes i.envia(new AvisoDeEntradaDaSala(this.usuario.getNome())), onde i é o nome de algum usuario que já estava na sala --ArrayList de usuarios
	  //incluir o usuario na sala
  }
//quando a pessoa sair da sala esse run para
  public void run()//Toda a interação necessária com o socket recebido por parametro
  {
	  //nada antes deste for infinito, pq o que era p estar aqui deve estar no construtor
	  		//for(;;)
	  		//{
	  			//parar este for quando houver o pedido para sair da sala
		//}

	 Enviavel recebido = null;

    do                 //break   -- mandar uma mensagem ou sair da sala -> a run acaba
    {
		//recebe primeiramente mensagens
		//pedido de saida da sala -- break
		//receber avisos de entrada e saida
	}
	while(!(recebido instanceof PedidoParaSairDaSala));

	//remover this.usuario da sala

	//mandar para todos da sala um aviso avisando que ele saiu da sala
    //new AvisoDeSaidaDaSala(this.usuario.getNome());

    //Fechar tudoo
    this.usuario.fechaTudo();
  }//Quando sai do run a cuidadora deixa de existir

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