package controle.enviaveis;

public class Mensagem implements Enviavel
{
	private String texto;
	private String destinatario;

	public Mensagem(Enviavel enviar)
	{
      this.texto = enviar.toString();
	}

	public void envia()
	{

	}

	/*public int hashCode()
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
	}*/
}