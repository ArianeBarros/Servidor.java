import java.util.ArrayList;
package dbos;
//metodo prara ver se ja existe um usaurio com o mesmo nome na sala --- throws Exceptions
//getUsuarios() -- arraylist com todos os nomes nas salas


public class Sala<Usuario>
{
 //quant de lugares nome identificação
  protected int qtdMaxima;//?
  protected ArrayList<Usuario> lista;
  protected String nome; //getter
  protected int qtdAtual = 0;

  protected int codigo;

  public Sala(int cod String nome, int qtd)
  {
	  this.qtdMaxima = qtd;
	  lista = new ArrayList<Usuario>;
      this.nome = nome;

       this.setCodigo(cod);
	   this.setNome(nome);
       this.setQtd(qtd);
  }

  public void setCodigo(int cod)
  {
    if(cod == null)
	  	throw new Exception("Código não fornecido corretamente");

  	 this.codigo = cod;
  }

   public void setNome(String nome)throws Exception
   {
  	 if(nome == null || nome.equals(" "))
  	   throw new Exception("Nome não fornecido corretamente");

  	 this.nome = nome;
   }

  public void setQtd(int qtd)
  {
     if(qtd == null)
	  	throw new Exception("Quantidade máxima não fornecido corretamente");

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
	 int indice = lista.indexOf(usuario)
     this.lista.remove(indice);
     this.qtdAtual--;
  }

  public boolean isVazia()
  {
    return this.qtdAtual == 0;
  }

  public boolean jaExiste(String username) //throws Exceptoin??
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

  public void setNomeClasse()
  {
     return this.nome = ;
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
  public boolean equals(Sala sala)
  {
    if(this==sala)
	   return true;

	if(sala == null)
	   return false;

	//if(this.getClass()!=sala.getClass())
	//   return false;

	Sala<Usuario> s = (Sala<Usuario>)sala; // java enxerga que existe uma Fila chamada fila (que é o mesmo obj)

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

 /*  private X meuCloneDeX(Usuario user)
   		{
   			X ret = null;
   			try
   			{
   				Class<?> classe = user.getClass();
   				Class<?>[] tiposDeParametrosFormais = null;
   				Method metodo = classe.getMethod("clone", tiposDeParametrosFormais);
   				Object[] tiposDeParametrosReais = null;
   				ret = (Usuario)metodo.invoke(tiposDeParametrosReais);
   			}
   			catch(NoSuchMethodException erro)
   			{}
   			catch(IllegalAccessException erro)
   			{}
   			catch(InvocationTargetException erro)
   			{}

   			return ret;
   		}*/


   public Object clone()
   {
     Sala<Usuario> ret = null;
	try
	{
		ret = new Sala<Usuario>(this);
	}
	catch(Exception erro)
	{}

    return ret;
   }

}//combobox

/*bd
Salas -- hardData -- p/ coisas que raramente mudam
dao e dbo p/ pegar salas
construtor da classe salas
*/