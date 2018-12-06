package controle.enviaveis;

public class PedidoParaSairDaSala implements Enviavel
{
	protected SalaUsuario<Usuario> sus;
	protected Usuario usador;
	protected ObjectInputStreamReader transmissor;
	public PedidoParaSairDaSala(Usuario usuante, )throws Exception
	{
		if(Usuario=null)
		this.usador=usuante;
	}

	public String envia()
	{
		try
		{
			this.transmissor.writeObject(this.usador+"quer sair da sala");
			this.transmissor.flush();

	    }
	    catch(IOException error)
	    {
	    System.out.println(error.getMessage());
	    }



      return "";
	}

	public int hashCode()
	{
		int ret=5;
		ret=ret*2+transmissor.hashCode();
	}

	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(this == obj)
			return true;

		if(this.getClass()!=obj.getClass())
			return false;
			PedidoParaSairDaSala ped=(PedidoParaSairDaSala)obj;
		if(!this.Usuario.equals(ped.Usuario))
			return false;
		if(!this.transmissor.equals(ped.transmissor))
		return false;
		return true;
	}

	public String toString()
	{
		"Usuario"+usador.toString()+"quer sair da" sus.get(i).toString();
	}
}











