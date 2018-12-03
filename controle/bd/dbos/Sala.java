//package bd.dbos;
package bd;
import java.util.ArrayList;
import controle.*;

public class Sala implements Cloneable
{
  protected int qtd;
  protected String nome;
  protected int codigo;

  public Sala(int cod, String nome, int qtd)	throws Exception
  {
	try
	{
       this.setCodigo(cod);
	   this.setNome(nome);
       this.setQtd(qtd);
   	}
   	catch(Exception error)
   	{
		throw new Exception(error.getMessage());
	}
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

  public float getQtd()
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
	   ret = 7*ret + new Float(this.qtd).hashCode();

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

}//combobox

/*bd
Salas -- hardData -- p/ coisas que raramente mudam
dao e dbo p/ pegar salas
construtor da classe salas
*/

/*
package dbos;

public class Livro implements Cloneable
{
    private int    codigo;
    private String nome;
    private float  preco;

    public void setCodigo (int codigo) throws Exception
    {
        if (codigo <= 0)
            throw new Exception ("Codigo invalido");

        this.codigo = codigo;
    }

    public void setNome (String nome) throws Exception
    {
        if (nome==null || nome.equals(""))
            throw new Exception ("Nome nao fornecido");

        this.nome = nome;
    }

    public void setPreco (float preco) throws Exception
    {
        if (preco <= 0)
            throw new Exception ("Preco invalido");

        this.preco = preco;
    }

    public int getCodigo ()
    {
        return this.codigo;
    }

    public String getNome ()
    {
        return this.nome;
    }

    public float getPreco ()
    {
        return this.preco;
    }

    public Livro (int codigo, String nome, float preco) throws Exception
    {
        this.setCodigo (codigo);
        this.setNome   (nome);
        this.setPreco  (preco);
    }

    public String toString ()
    {
        String ret="";

        ret+="Codigo: "+this.codigo+"\n";
        ret+="Nome..: "+this.nome  +"\n";
        ret+="Preco.: "+this.preco;

        return ret;
    }

    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        if (!(obj instanceof Livro))
            return false;

        Livro liv = (Livro)obj;

        if (this.codigo!=liv.codigo)
            return false;

        if (this.nome.equals(liv.nome))
            return false;

        if (this.preco!=liv.preco)
            return false;

        return true;
    }

    public int hashCode ()
    {
        int ret=666;

        ret = 7*ret + new Integer(this.codigo).hashCode();
        ret = 7*ret + this.nome.hashCode();
        ret = 7*ret + new Float(this.preco).hashCode();

        return ret;
    }


    public Livro (Livro modelo) throws Exception
    {
        this.codigo = modelo.codigo; // nao clono, pq nao eh objeto
        this.nome   = modelo.nome;   // nao clono, pq nao eh clonavel
        this.preco  = modelo.preco;  // nao clono, pq nao eh objeto
    }

    public Object clone ()
    {
        Livro ret=null;

        try
        {
            ret = new Livro (this);
        }
        catch (Exception erro)
        {} // nao trato, pq this nunca ï¿½ null e construtor de
           // copia da excecao qdo seu parametro for null

        return ret;
    }
}

*/