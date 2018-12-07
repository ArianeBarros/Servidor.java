import java.net.*;

public class Cliente
{
	public static void main(String[] args)
	{
		try
		{
			Socket cliente = new Socket("localhost", 12346);
			new FormularioP(cliente);
		}
		catch(Exception erro)
		{
			System.out.println("Erro: " + erro);
		}
	}

}