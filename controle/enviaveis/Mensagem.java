package controle.enviaveis;

public class Mensagem implements Enviavel
{
	protected String texto;


	public Mensagem(String msg)
	{
		this.texto = msg;
	}

   public String envia()
	{
		return this.texto;
	}

	public void setTexto(String t)
	{
		this.texto = t;
	}

	public String getTexto()
	{
		return this.texto;
	}

	public String toString()
	{
		return this.texto;
	}

	public int hashCode()
	{
		int ret = 3;
		ret = ret * 7 + new String(this.texto).hashCode();;

		return ret;
	}

	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;

		if(this == obj)
			return true;

		if(this.getClass()!= obj.getClass())
			return false;

		Mensagem msg = (Mensagem)obj;

		if(!this.texto.equals(msg.texto))
			return false;

		return true;
	}
}