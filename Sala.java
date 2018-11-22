import java.util.ArrayList;

//metodo prara ver se ja existe um usaurio com o mesmo nome na sala --- throws Exceptions
//getUsuarios() -- arraylist com todos os nomes nas salas


public class Sala<Usuario>
{
 //quant de lugares nome identificação
  private int qtdMaxima = 6;//?
  private ArrayList<Usuario> lista;
  private String nome; //getter
  private int qtdAtual = 0;

  public Sala(int lugares, String qualNome)
  {
	  this.qtdAtual = lugares;
	  lista = new ArrayList<Usuario>;
      this.nome = qualNome;
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

  public void getNomeClasse()
  {
     return this.nome.clone();
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

    return "Nome: " + this.nome + "\n\n Situação: " + sit;
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