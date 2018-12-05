package controle.enviaveis;

public class AvisoDeEntradaNaSala implements Enviavel
{
	//Ou fazer uma classe só AvisoDeMovimentacao()
    protected String nick;

	public AvisoDeEntradaNaSala(String nome)throws Exception
	{
		if(nome == null)
		 throw new Exception("Nome inválido");

        this.nick = nome;
	}

	public String envia()
	{
       return "O usuário " + this.nick + "entrou na sala";
	}

    public String toString()
    {
       return "O nome do usuário é"+ this.nick;
    }

    public int hashCode()
    {
       int ret=2;
       ret=ret*3+nick.hashCode();
    }

    public boolean equals(Object obj)
    {
       if(this==obj)
        return true;
        if(obj==null)
           return false;
        if(this.getClass()!=obj.getClass())
           return false;
           AvisoDeEntradaNaSala adens=(AvisoDeEntradaNaSala)obj;
        if(!this.nick.equals(adens.nick))
        return false;
        return true;


    }


}