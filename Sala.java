import java.util.ArrayList;

//metodo prara ver se ja existe um usaurio com o mesmo nome na sala --- throws Exceptions

public class Sala<Usuario>
{
 //quant de lugares nome identificação
  private int qtdMaxima;
  private ArrayList<Usuario> lista;
  private String nome; //getter
  private int qtdAtual = 0;

  public Sala(int lugares)
  {
	  this.qtd = lugares;
	  lista = new ArrayList<Usuario>;

  }
  public void adicionarUsuario()
  {
	  lista.add(Usuario usuario);
	  qtd++;
  }

  public void excluirUsuario()
  {
	 int indice = lista.indexOf(Usuario usuario)
     lista.remove(indice);
     qtd--;
  }

  public boolean isVazia()
  {
    return this.lista.isEmpty();
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