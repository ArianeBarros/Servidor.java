package controle;
import controle.bd.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.ArrayList;

public class SalaUsuario
{
  protected int qtdMaxima;
  protected ArrayList<Usuario> lista;
  protected String nome;
  protected int qtdAtual = 0;
  protected int codigo;

  public SalaUsuario(String nome, int qtd) throws Exception
  {
     this.nome = nome;
     this.qtdMaxima = qtd;
     this.lista = new ArrayList<Usuario>(this.qtdMaxima);
  }



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

  public ArrayList<String> getNomeUsuarios()
  {
	 	ArrayList<String> nomes = new ArrayList<String>();
	 	for(Usuario u: this.lista)
	 		nomes.add(u.getNickname());

	 	return nomes;
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

  public int getCodigo()
  {
	  return this.codigo;
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
	   if (!super.equals (sala))
            return false;

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
    int ret = super.hashCode();

    ret = ret * 2 + new Integer(this.qtdMaxima).hashCode();
    ret = ret * 2 + new Integer(this.qtdAtual).hashCode();
    ret = ret * 2 + this.nome.hashCode();

    for(int i = 0; i < qtdMaxima; i++)
    {
      ret = ret * 2 + this.lista.get(i).hashCode();
	}

    return ret;
   }

   public SalaUsuario(SalaUsuario modelo) throws Exception
   {
	  if(modelo == null)
	  	throw new Exception("Modelo ausente");

	this.qtdMaxima = modelo.qtdMaxima;

	this.qtdAtual = modelo.qtdAtual;

	this.lista = new ArrayList<Usuario>(modelo.lista.size());

	 this.lista = modelo.lista;
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