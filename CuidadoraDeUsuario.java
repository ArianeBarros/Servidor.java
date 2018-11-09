
public class CuidadoraDeUsuario extends Thread
{
	private Usuario usuario;


  public CuidadoraDeUsuario(Socket conexao, Salas sala) throws Exception
  {
	  //declarar e instanciar PrintWriter e BufferedReader, usando o Socket recebido
	  //interagir com o usuário via PrintWriter e BufferedReader para descobrir o nome da sala em que ele deseja entrar, eventualmente, informando sala cheia
	  //procurar em salas(param)  a sala com o nome desejado
	  //interagir com o usuário via PrintWriter e BufferedReader para descobrir o nome que ele deseja usar, eventualmente, retornando nome invalido ou ja usado(usar metodo da Sala)
	  //instanciar 1 Usuario, fornecendo conexao, pw, bf, sala e nome
	  //incluir o usuario na sala
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









/*Usuario
  -getNome
  -public void envia()

  -public String recebe()

  -
ObjectOutPutStream(VETORR/ArrayList) -- pw(TUDO STRINGGGGG)
ObjectInputStream(VETORRR/ArrayList) -- bf(TUDO STRINGGGGG)
*/