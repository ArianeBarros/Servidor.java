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
  public void adicionarUsuario()
  {
	  this.lista.add(Usuario usuario);
	  this.qtdAtual++;
  }

  public void excluirUsuario(Usuario usuario)
  {
	 int indice = lista.indexOf(Usuario usuario)
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
  public boolean equals()
  {
  }
   public int hashCode()
   {
   }

   public Object clone()
   {
   }

}//combobox