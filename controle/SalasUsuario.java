package controle;
//import bd.Salas;
import java.io.*;
import controle.bd.*;
import java.io.BufferedReader;
import java.net.*;
import java.util.*;
import java.util.ArrayList;

//guarde
//jge fora

public class SalasUsuario extends Salas
{
  protected ArrayList<SalaUsuario> list;
  protected int qtdAtualSalas = 0;
  protected int qtdMaxima;

  public SalasUsuario()
  {
	  super();
	/*list = new ArrayList<SalaUsuario>(this.qtdMaxima);
    list.add(sala);
    this.qtdMaxima = sala.getQtd();*/
  }

  public void guarde(SalaUsuario sala)throws Exception
  {
	 if(!isCheia())
	 {
		for(int i = qtdAtualSalas; i < qtdMaxima; i++)
		{
		   this.list.add(sala);
		   this.qtdAtualSalas++;
		}

	 }
     else
        throw new Exception("Sem espaço para mais salas");
  }

  public void excluir(SalaUsuario sala, String nomeSala)throws Exception//pegar todos os tipos de exclusão
  {
    if(!isVazia())
    {
       int indice = list.indexOf(nomeSala);
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

      if(this.isVazia())
        sit = "Vazia";
      else
        if(this.isCheia())
          sit = "Cheia";
          else
           sit = "Disponível";

     for(int i = 0; i < this.list.size(); i++)
     {
		 nomes += "\n\n " + this.list.get(i);
	 }

      return "Salas: " + nomes + "\n\n Situação: " + sit;
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

  /* private SalaUsuario<Usuario> meuCloneDeSala(SalaUsuario<Usuario> sala)
   		{
   			SalaUsuario<Usuario> ret = null;
   			try
   			{
   				SalaUsuario<Usuario> classe = SalaUsuario<Usuario>;
   				ArrayList<SalaUsuario<Usuario>> tiposDeParametrosFormais = null;
   				Method metodo = classe.getMethod("clone", tiposDeParametrosFormais);
   				ArrayList<SalaUsuario<Usuario>> tiposDeParametrosReais = null;
   				ret = (SalaUsuario<Usuario>)metodo.invoke(tiposDeParametrosReais);
   			}
   			catch(NoSuchMethodException erro)
   			{}
   			catch(IllegalAccessException erro)
   			{}
   			catch(InvocationTargetException erro)
   			{}

   			return ret;
		}*/

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