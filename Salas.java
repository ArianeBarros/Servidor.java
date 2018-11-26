import java.util.ArrayList;
package daos;
import java.sql.*;
import bd.BDSQLServer;
import core.MeuResultSet;
import dbos.Sala;
import java.net.*;
import java.io.*;
import java.util.*;

//guarde
//jge fora

public class Salas
{
  protected ArrayList<Sala> list;
  protected int codSala;
  protected int qtdAtualSalas = 0;
  protected int qtdMaxima = 3;

  public Salas(Sala sala)//pegar do bd :0
  {

  }

  public static boolean cadastrado(int codigo)throws Exception
  {
	  boolean retorno = false;

	          String sql;

			             sql = "SELECT * " +
			                   "FROM SalasSQL " +
			                   "WHERE CODIGO = ?";

			             BDSQLServer.COMANDO.prepareStatement (sql);

			             BDSQLServer.COMANDO.setInt (1, codigo);

			             MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

			             retorno = resultado.first();
			         }
			         catch (SQLException erro)
			         {
			             throw new Exception ("Erro ao procurar livro");
			         }


        return retorno;
  }

  public void guarde(Sala sala)throws Exception
  {
	  if(!isCheia())
	  {
		  boolean existe = false;


		  if(cadastrado(sala.setCodigo()))
			existe = true;

		 this.list.add(sala);
		 this.qtdSalas++;
      }
      else
        throw new Exception("Sem espaço para mais salas");
  }

  public boolean isVazia()
  {
	  return this.list.size() == 0;
  }

   public boolean isCheia()
    {
       return this.list.size() == this.qtdMaxima;
    }

    public String toString()
    {
  	String sit;
  	String nomes = "";

      if(this.list.isVazia())
        sit = "Vazia";
      else
        if(this.list.isCheia())
          sit = "Cheia";
          else
           sit = "Disponível";

     for(int i = 0; i < this.list.length; i++)
     {
		 nomes += this.list.get(i);
	 }

      return "Nomes: " + nomes + "\n\n Situação: " + sit;
    }
    public boolean equals(Salas salas)//Precisa??
    {
      if(this==salas)
  	   return true;

  	if(salas == null)
  	   return false;

  	//if(this.getClass()!=sala.getClass())
  	//   return false;

  	Salas<Sala> s = (Salas<Sala>)salas; // java enxerga que existe uma Fila chamada fila (que é o mesmo obj)

  	if(this.qtdMaxima!=s.qtdMaxima)
  	   return false;

  	for(int i = 0; i < this.qtdMaxima; i++)
  		if(!this.lista.get(i).equals(s.get(i)))
  		  return false;

       return true;
    }

     public int hashCode()
     {
      int ret = 1;

      ret = ret * 2 + new Integer(this.qtdMaxima).hashCode();
      ret = ret * 2 + new Integer(this.qtdAtual).hashCode();

      for(int i = 0; i < qtdMaxima; i++)
      {
        ret = ret * 2 + this.list.get(i).hashCode();
  	}

      return ret;
   }

    public Object clone()
      {
        Salas<Sala> ret = null;
   	try
   	{
   		ret = new Salas<Sala>(this);
   	}
   	catch(Exception erro)
   	{}

       return ret;
   }

}