package controle;

import controle.bd.Salas;
import java.io.*;
import java.io.BufferedReader;
import java.net.*;
import java.util.*;
import java.util.ArrayList;


public class SalasUsuario
{
  protected ArrayList<SalaUsuario> list;
  protected int qtdAtualSalas = 0;
  protected int qtdMaxima;

  public SalasUsuario()
  {
		this.list = new ArrayList<SalaUsuario>(50);
		this.qtdMaxima = 50;
  }

  public ArrayList<String> getNomes()
  {
	  ArrayList<String> lista = new ArrayList<String>(this.list.size());
	  for(SalaUsuario s: this.list)
			lista.add(s.getNome());



	  return lista;
  }

  public void guarde(SalaUsuario sala)throws Exception
  {
	 if(!isCheia())
	 {
		   this.list.add(sala);
		   this.qtdAtualSalas++;
	 }
     else
        throw new Exception("Sem espa�o para mais salas");
  }

  public SalaUsuario descobrirSala(String nomeSala)throws Exception
  {
	  for(int i = 0; i < this.list.size(); i++)
	  {
		  if(this.list.get(i).getNome().equals(nomeSala))
		    return this.list.get(i);
	  }

	  throw new Exception("Sala n�o encontrada");
  }

  public void excluir(SalaUsuario sala)throws Exception
  {
    if(!isVazia())
    {
       int indice = list.indexOf(sala.getNome());
	   this.list.remove(indice);
       this.qtdAtualSalas--;
 	}
	else
	  throw new Exception("Sem salas dispon�veis para exclus�o");
  }

  public boolean isVazia()
  {
	  return this.list.size() == 0;
  }

   public boolean isCheia()
    {
       return this.qtdAtualSalas == this.qtdMaxima;
    }

    public String toString()
    {
  	String sit;
  	String nomes = "";

      if(this.isVazia())
        sit = "Vazia";
      else
        if(this.isCheia())
          sit = "Cheia";
          else
           sit = "Dispon�vel";

     for(int i = 0; i < this.list.size(); i++)
     {
		 nomes += "\n\n " + this.list.get(i);
	 }

      return "Salas: " + nomes + "\n\n Situa��o: " + sit;
    }
    public boolean equals(Object salas)
    {
      if(this==salas)
  	   return true;

  	if(salas == null)
  	   return false;

  	SalasUsuario s = (SalasUsuario)salas;

  	if(this.qtdMaxima!=s.qtdMaxima)
  	   return false;


  		if(!this.list.equals(s))
  		  return false;

       return true;
    }

     public int hashCode()
     {
      int ret = 1;

      ret = ret * 2 + new Integer(this.qtdMaxima).hashCode();
      ret = ret * 2 + new Integer(this.qtdAtualSalas).hashCode();

      for(int i = 0; i < qtdMaxima; i++)
      {
        ret = ret * 2 + this.list.get(i).hashCode();
  	}

      return ret;
   }

    public SalasUsuario(SalasUsuario modelo) throws Exception
      {
		  if(modelo == null)
			throw new Exception("Modelo ausente");

		this.qtdMaxima = modelo.qtdMaxima;

		this.qtdAtualSalas = modelo.qtdAtualSalas;

		this.list = new ArrayList<SalaUsuario>(modelo.list.size());

		this.list = modelo.list;
  	 }

    public Object clone()
      {
        SalasUsuario ret = null;
   	try
   	{
   		ret = new SalasUsuario(this);
   	}
   	catch(Exception erro)
   	{}

       return ret;
   }

}