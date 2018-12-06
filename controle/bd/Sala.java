package controle.bd;

import java.sql.*;

public class Sala implements Cloneable
{
  private int qtd;
  private String nome;
  private int codigo;

  public Sala(int cod, String nome, int qtd)	throws Exception
  {
       this.setCodigo(cod);
	   this.setNome(nome);
       this.setQtd(qtd);
  }

  public void setCodigo(int cod)throws Exception
  {
    if(cod < 0)
	  	throw new Exception("Código é inválido");

  	 this.codigo = cod;
  }

   public void setNome(String nome)throws Exception
   {
  	 if(nome == null || nome.equals(""))
  	   throw new Exception("Nome não fornecido corretamente");

  	 this.nome = nome;
   }

  public void setQtd(int qtdBD)throws Exception
  {
     if(qtd < 0)
	  	throw new Exception("A quantidade máxima é inválida");

  	 this.qtd = qtdBD;
  }

   public int getCodigo ()
  {
     return this.codigo;
  }

  public String getNome ()
  {
	  return this.nome;
  }

  public int getQtd()
  {
	  return this.qtd;
  }

  public String toString ()
  {
          String ret="";

          ret+="Codigo: "+this.codigo+"\n";
          ret+="Nome: "+this.nome  +"\n";
          ret+="Qtd: "+this.qtd;

          return ret;
    }


   public boolean equals (Object obj)
      {
          if (this==obj)
              return true;

          if (obj==null)
              return false;

          if (!(obj instanceof Sala))
              return false;

          Sala sal = (Sala)obj;

          if (this.codigo!=sal.codigo)
              return false;

          if (this.nome.equals(sal.nome))
              return false;

          if (this.qtd!=sal.qtd)
              return false;

          return true;
    }

    public int hashCode ()
   {
	   int ret=666;

	   ret = 7*ret + new Integer(this.codigo).hashCode();
	   ret = 7*ret + this.nome.hashCode();
	   ret = 7*ret + new Integer(this.qtd).hashCode();

	   return ret;
   }

   public Sala (Sala modelo) throws Exception
   {
	   this.codigo = modelo.codigo;
	   this.nome   = modelo.nome;
	   this.qtd  = modelo.qtd;
   }

     public Object clone ()
	{
		Sala ret=null;

		try
		{
			ret = new Sala (this);
		}
		catch (Exception erro)
		{}

		return ret;
	}

}

