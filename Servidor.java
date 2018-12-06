//package Servidor.java;

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
  		System.out.print("ok");

  		try
   		{
   			FormularioP form = new FormularioP();

   			ServerSocket ss = new ServerSocket(12346);
   			SalasUsuario salas = new SalasUsuario();

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
/*
synchronized(X)//rapidoooo
{//minimo de coisas possivel
	x.sds
	x.dsds
}*/
