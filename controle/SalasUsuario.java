package controle;
import java.io.*;
import java.io.BufferedReader;
import java.net.*;
import java.util.*;
import java.util.ArrayList;

//guarde
//jge fora

public class SalasUsuario
{
  protected ArrayList<Sala> list;
  protected int qtdAtualSalas = 0;
  protected int qtdMaxima = 3;

  public Salas()
  {
    list = new ArrayList<SalaUsuario<Usuario>>();
  }

  public void guarde(SalaUsuario<Usuario> sala)throws Exception
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

  public void excluir(SalaUsuario<SalaUsuario<Usuario>> sala, String nomeSala)throws Exception//pegar todos os tipos de exclusão
  {
    if(!isVazia())
    {
       int indice = lista.indexOf(sala.getSalaNome(nomeSala));
	   this.list.remove(indice);
       this.qtdAtualSalas--;
 	}
   /*  else
       throw new Exception("Sala não existe");
	}*/
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
		 nomes += "\n\n " + this.list.get(i);
	 }

      return "Salas: " + nomes + "\n\n Situação: " + sit;
    }
    public boolean equals(SalasUsuario<SalaUsuario<Usuario>> salas)
    {
      if(this==salas)
  	   return true;

  	if(salas == null)
  	   return false;

  	SalasUsuario<SalaUsuario<Usuario>> s = (SalasUsuario<SalaUsuario<Usuario>>)salas;

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
        SalasUsuario<SalaUsuario<Usuario>> ret = null;
   	try
   	{
   		ret = new SalasUsuario<SalaUsuario<Usuario>>(this);
   	}
   	catch(Exception erro)
   	{}

       return ret;
   }

}