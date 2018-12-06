package controle.enviaveis;

public class Mensagem implements Enviavel
{
	protected String texto;
	protected String destinatario;

	public Mensagem(String msg, String dest)
	{
		this.texto = msg;
		this.destinatario = dest;
	}

   public String envia()
	{
		return this.texto;
	}

/*	public void setTexto(String t)
	{
		this.texto = t;
	}

	public void setDestinatario(String d)
	{
		this.destinatario = d;
	}

	public String getTexto()
	{
		return this.texto;
	}

	public String getDestinatario()
	{
		return this.destinatario;
	}

	public String toString()
	{
		return this.texto + this.destinatario;
	}

	public int hashCode()
	{
		int ret = 3;
		ret = ret * 7 + new String(this.destinatario).hashCode();
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

		if(!this.destinatario.equals(msg.destinatario))
			return false;

		return true;
	}*/
}