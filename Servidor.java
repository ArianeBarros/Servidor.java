//package Servidor.java;

import java.io.*;
import bd.*;
//import bd.core;
//import enviaveis.*;

public class Servidor
{
   public static void main (String[]args)throws Exception
   	{
//   		protected Salas salas = new Salas();
   		System.out.print("ok");
   		FormularioP form = new FormularioP();

   	   try
		{
			System.out.print(Salas.getSalas());
          //System.out.print("blz");
		}
		catch (Exception e)
		{
			System.out.println (e.getMessage());
        }

	}
}

//sQL - na mesma pasta da main
//set classpath = .;sqljdbc42.jar

/*
Missão da main de class Salas

1- Declarar 1 instância 1 obj da class Salas
2- obj da classe salas
3- Em loop, fazer acepts e declarar instancias(passando o socket gerado no accept para o construtor)

Como enfiar o obj?
Preciso recuperar de um banco de dados de uma tabela, que deve estar guardada. No banco deve estar todas as salas que devem existir

A thred não faz quase nada
-Usuario
-Sala
-Salas
-Programa
-Pacote chat e bd


//sem interação
*/

/*
----------------------------------------------------------------------------------

1)class Salas
  ArrayList<Sala>
2)class Sala
  ArrayList<Usuario>
3)class Usuario
  1 socket
  1 PrintWriter
  1 BufferedReader

4)class Servidor(main)
Tudo no programa Servidor(1) -- muitos sockets, printw., buff., ...
MISSÃO: Declarar e instanciar o objeto da class Salas
        Por no objeto objetos da class Salas
        (recuperar do bd de uma tabela(criar) onde estao guardadas
as salas que devem existir, criando e colocando-as no objeto de Salas)
        Tabela --> Quant de lugares, nome, codSala(primary key)
        Em loop fazer accepts(gerar sockets) e declarar e instanciar(passando o socket gerado no accept para o construtor)
 e o objeto da class Salas para o construtor e dar start criando threads -- a pessoa escolhe entre as opcoes da thread em qual sala
quer entrar e envia para a thread

synchronized(X)//rapidoooo
{//minimo de coisas possivel
	x.sds
	x.dsds
}

synchronized(X)//rapidoooo
{//minimo de coisas possivel
	x.sds
	x.dsds
}

synchronized(X)//rapidoooo
{//minimo de coisas possivel
	x.sds
	x.dsds
}

synchronized(X)//rapidoooo
{//minimo de coisas possivel
	x.sds
	x.dsds
}

synchronized(X)//rapidoooo
{//minimo de coisas possivel
	x.sds
	x.dsds
}

2 pacotes

receber do usuario de q ela cuida
run -- receberrrrrr
Só manda p/ outro usuario, coisas que o usuario de q ela cuida
nao manda nada p/ seu usuario

receber -- instanceof jgkfjg

como descobrir se alguem mandou alguma mensagem

foco - gained
keyListaner
*/