package controle;
import java.io.*;
import java.io.BufferedReader;
import java.net.*;
import java.util.*;
import java.util.ArrayList;


//metodo prara ver se ja existe um usaurio com o mesmo nome na sala --- throws Exceptions
//getUsuarios() -- arraylist com todos os nomes nas salas


public class SalaUsuario
{
 //quant de lugares nome identifica��o
  protected int qtdMaxima;
  protected ArrayList<Usuario> lista;
  protected String nome;
  protected int qtdAtual = 0;

  public SalaUsuario(String nomeSala, int qtdM)throws Exception
  {
     this.nome = nomeSala;
     this.qtdMaxima = qtdM;
     this.lista = new ArrayList<Usuario>(this.qtdMaxima);
  }

 /*  public String getNome()throws Exception
   {
	   return this.nome;
   }

  public int getQtd()throws Exception
  {
	 return this.qtdMaxima;
  }*/

  /*synchronized(X) X -- obj q esta sendo compartilhado
   {
	   x.dsdsds
	   x.dsldms
   }
  */
  public void adicionarUsuario(Usuario usuario)
  {
	  this.lista.add(usuario);
	  this.qtdAtual++;
  }

  public void excluirUsuario(Usuario usuario)
  {
	 int indice = lista.indexOf(usuario);
     this.lista.remove(indice);
     this.qtdAtual--;
  }

  public boolean isVazia()
  {
    return this.qtdAtual == 0;
  }

  public boolean jaExiste(String username) throws Exception
  {
    for(int i = 0; i < this.qtdAtual; i++)
    {
		if(this.lista.get(i).equals(username))
		  return true;
	}

	return false;
  }

  public ArrayList<Usuario> getUsuarios()
  {
	  return (ArrayList<Usuario>)this.lista.clone();
  }

  public Usuario getUsuario(int i)
  {
    return this.lista.get(i);
  }

  public String getNome()
  {
     return this.nome;
  }

   public int getQtd()
   {
       return this.qtdMaxima;
   }

   public int getQtdAtual()
   {
	   return this.qtdAtual;
   }

  public boolean isCheia()
  {
     return this.lista.size() == this.qtdMaxima;
  }

  public String toString()
  {
	String sit;

    if(this.isVazia())
      sit = "Vazia";
    else
      if(this.isCheia())
        sit = "Cheia";
        else
         sit = "Dispon�vel";

    return "Nome: " + this.getNome() + "\n\n Situa��o: " + sit + "\n\n Usu�rios: " + this.getUsuarios();
  }
  public boolean equals(Object sala)
  {
    if(this==sala)
	   return true;

	if(sala == null)
	   return false;

	SalaUsuario s = (SalaUsuario)sala;

	if(this.qtdMaxima!=s.qtdMaxima)
	   return false;


		if(!this.lista.equals(s))
		  return false;

     return true;
  }

   public int hashCode()
   {
    int ret = 1;

    ret = ret * 2 + new Integer(this.qtdMaxima).hashCode();
    ret = ret * 2 + new Integer(this.qtdAtual).hashCode();
    ret = ret * 2 + this.nome.hashCode();

    for(int i = 0; i < qtdMaxima; i++)
    {
      ret = ret * 2 + this.lista.get(i).hashCode();
	}

    return ret;
   }

// fazer construtor de copia

   public SalaUsuario(SalaUsuario modelo) throws Exception
   {
	  if(modelo == null)
	  	throw new Exception("Modelo ausente");

	this.qtdMaxima = modelo.qtdMaxima;

	this.qtdAtual = modelo.qtdAtual;

	this.lista = new ArrayList<Usuario>(modelo.lista.size());

	 this.lista = modelo.lista;//!!
  }

   public Object clone()
   {
     SalaUsuario ret = null;
	try
	{
		ret = new SalaUsuario(this);
	}
	catch(Exception erro)
	{}

    return ret;
   }

}