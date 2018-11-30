package enviaveis;
import controle.*;
public class PedidoParaSairDaSala implements Enviavel
{
	//talvez
	//protected SalaUsuario<Usuario>;
	//protected Usuario;

	public PedidoParaSairDaSala()
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

		if(this.getClass()!=obj.getClass())
			return false;
		return true;
	}

	/*public String toString()
	{
	}*/
}