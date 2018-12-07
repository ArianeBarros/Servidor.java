import java.io.*;
import controle.bd.*;
import java.awt.*;
import java.awt.event.*;
import controle.*;
import javax.swing.*;
import java.net.*;

public class Servidor
{
   public static void main (String[]args)throws Exception
   	{
  		try
   		{
   		ServerSocket ss = new ServerSocket(12346);
   		SalasUsuario salas = new SalasUsuario();
   		MeuResultSet result = Salas.getSalas();
   		while(result.next())
   			salas.guarde(new SalaUsuario(result.getString("NOME"), result.getInt("QTD")));

		for(;;)
		{
           Socket s = ss.accept();

		   CuidadoraDeUsuario tratadora = new CuidadoraDeUsuario(s, salas);
		   tratadora.start();
	    }

		}
		catch(Exception erro)
		{
           System.out.println("Servidor: " + erro);
		}

	}
}
