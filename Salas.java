import java.util.ArrayList;

//guarde
//jge fora

public class Salas
{
  protected ArrayList<Sala> list;
  protected int qtdSalas;

  public Salas()//pegar do bd :0
  {

  }

  public void guarde(Sala sala)
  {
     this.list.add(sala);
	 this.qtdSalas++;
  }

  public void jogueFora(Sala sala)
  {
    int indice = lista.indexOf(sala)
	this.lista.remove(indice);
     this.qtdSalas--;
  }

}