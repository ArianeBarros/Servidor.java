package controle.enviaveis;

public class AvisoDeEntradaNaSala implements Enviavel
{
    protected String nick;

	public AvisoDeEntradaNaSala(String nome)throws Exception
	{
		if(nome == null)
		 throw new Exception("Nome inv�lido");

        this.nick = nome;
	}

	public String getNick()
	{
		return this.nick;
	}
	public String envia()
	{
       return "O usu�rio " + this.nick + " entrou na sala";
	}

    public String toString()
    {
       return "O nome do usu�rio �"+ this.nick;
    }

    public int hashCode()
    {
       int ret=2;
       ret=ret*3+nick.hashCode();
       return ret;
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