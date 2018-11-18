public class Mensagem implements Enviavel
{
	private Texto;
	private destinatario;

	public Mensagem()
	{
	}

	public int hashCode()
	{
	}

	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(this == obj)
			return true;
		if(this.getClass()!= obj.getClass())
			return false;
		return true;
	}
}