package controle.enviaveis;

import java.io.*;
public interface Enviavel extends Serializable //pra poder escrever no ObjectInputStream
{
	// interface ou uma classe
	String envia();


}