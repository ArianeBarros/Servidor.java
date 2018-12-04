package controle.enviaveis;

public class AvisoDeEntradaNaSala implements Enviavel
{
	//Ou fazer uma classe só AvisoDeMovimentacao()
    protected String nick;

	public AvisoDeEntradaNaSala(String nome)//throws Exception
	{
		//if(nome == null)
		 // throw new Exception("Nome inválido");

        this.nick = nome;
	}

	public String envia()
	{
       return "O usuário " + this.nick + "entrou na sala";
	}
}