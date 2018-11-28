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
 //quant de lugares nome identificação
  protected int qtdMaxima;//?
  protected ArrayList<Usuario> lista = new ArrayList<Usuario>();
  protected String nome;
  protected int qtdAtual = 0;

  public SalaUsuario<Usuario> (/*String nome, int qtdM*/)throws Exception
  {

  }

  public void getCodigo(int cod)throws Exception
  {
    	 this.codigo = cod;
  }

   public void getNome(String nome)throws Exception
   {
	   this.nome = nome;
   }

  public void getQtd(int qtd)throws Exception
  {
	  this.qtdMaxima = qtd;
  }

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

  public void getUsuarios()
  {
	  return this.lista.clone();
  }

  public void getNome()
  {
     return this.nome;
  }

   public void getQtd()
    {
       return this.qtdMaxima;
  }

  public boolean isCheia()
  {
     return this.lista.size() == this.qtdMaxima;
  }

  public String toString()
  {
	String sit;

    if(this.lista.isVazia())
      sit = "Vazia";
    else
      if(this.lista.isCheia())
        sit = "Cheia";
        else
         sit = "Disponível";

    return "Nome: " + this.getNomeClasse() + "\n\n Situação: " + sit + "\n\n Usuários: " + this.getUsuarios();
  }
  public boolean equals(SalaUsuario<Usuario> sala)
  {
    if(this==sala)
	   return true;

	if(sala == null)
	   return false;

	SalaUsuario<Usuario> s = (SalaUsuario<Usuario>)sala;

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
    ret = ret * 2 + this.nome.hashCode();

    for(int i = 0; i < qtdMaxima; i++)
    {
      ret = ret * 2 + this.lista.get(i).hashCode();
	}

    return ret;
   }

   public Object clone()
   {
     SalaUsuario<Usuario> ret = null;
	try
	{
		ret = new SalaUsuario<Usuario>(this);
	}
	catch(Exception erro)
	{}

    return ret;
   }

}