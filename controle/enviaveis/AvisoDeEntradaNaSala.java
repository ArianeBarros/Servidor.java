package controle.enviaveis;

public class AvisoDeEntradaNaSala implements Enviavel
{
	//Ou fazer uma classe s� AvisoDeMovimentacao()
    protected String nick;

	public AvisoDeEntradaNaSala(String nome)//throws Exception
	{
		//if(nome == null)
		 // throw new Exception("Nome inv�lido");

        this.nick = nome;
	}

	public String envia()
	{
       return "O usu�rio " + this.nick + "entrou na sala";
	}
}