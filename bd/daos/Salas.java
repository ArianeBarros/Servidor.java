package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

import java.util.ArrayList;
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

  public static boolean cadastrado(int codigo)throws Exception
  {
	  boolean retorno = false;

	          String sql;
                   try
                   {
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

  public static Sala getSalaCod(int codigo) throws Exception
      {
          Sala sala = null;

          try
          {
              String sql;

              sql = "SELECT * " +
                    "FROM SalasSQL " +
                    "WHERE CODIGO = ?";

              BDSQLServer.COMANDO.prepareStatement (sql);

              BDSQLServer.COMANDO.setInt (1, codigo);

              MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

              if (!resultado.first())
                  throw new Exception ("Nao cadastrado");

              sala = new Sala (resultado.getInt   ("CODIGO"),
                                 resultado.getString("NOME"),
                                 resultado.getInt ("QTD"));
          }
          catch (SQLException erro)
          {
              throw new Exception ("Erro ao procurar sala");
          }

          return sala;
      }

      public static Sala getSalaNome(String nome) throws Exception
	        {
	            Sala sala = null;

	            try
	            {
	                String sql;

	                sql = "SELECT * " +
	                      "FROM SalasSQL " +
	                      "WHERE NOME = ?";

	                BDSQLServer.COMANDO.prepareStatement (sql);

	                BDSQLServer.COMANDO.setString(1, nome);

	                MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

	                if (!resultado.first())
	                    throw new Exception ("Nao cadastrado");

	                sala = new Sala (resultado.getInt   ("CODIGO"),
	                                   resultado.getString("NOME"),
	                                   resultado.getInt ("QTD"));
	            }
	            catch (SQLException erro)
	            {
	                throw new Exception ("Erro ao procurar sala");
	            }

	            return sala;
      }

    /*  public static MeuResultSet getSalas() throws Exception
      {
          MeuResultSet resultado = null;

          try
          {
              String sql;

              sql = "SELECT * " +
                    "FROM SalasSQL";

              BDSQLServer.COMANDO.prepareStatement (sql);

              resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
          }
          catch (SQLException erro)
          {
              throw new Exception ("Erro ao recuperar salas");
          }

          return resultado;
    }*/

  public void guarde(Sala sala)throws Exception
  {
	 if(!isCheia())
	 {
		for(int i = qtdAtualSalas; i < qtdMaxima; i++)
		{
		   this.list.add(sala.getSalaCod(i));
		   this.qtdAtualSalas++;
		}

	 }
     else
        throw new Exception("Sem espaço para mais salas");
  }

  public void excluir(Sala sala, String nomeSala)throws Exception//pegar todos os tipos de exclusão
  {
    if(!isVazia())
    {
       int indice = lista.indexOf(sala.getSalaNome(nomeSala));
	   this.list.remove(indice);
       this.qtdAtualSalas--;
 	 //}
   /*  else
       throw new Exception("Sala não existe");*/
	}
	else
	  throw new Exception("Sem salas disponíveis para exclusão");
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

      return "Salas: " + nomes + "\n\n Situação: " + sit;
    }
    public boolean equals(Salas salas)
    {
      if(this==salas)
  	   return true;

  	if(salas == null)
  	   return false;

  	Salas<Sala> s = (Salas<Sala>)salas;

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