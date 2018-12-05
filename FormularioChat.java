import javax.swing.*;
import java.awt.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import controle.*;

public class FormularioChat
{
	protected JFrame janela             = new JFrame("CHAT");
	protected JLabel lbUsuario          = new JLabel("Usuários");
	protected JLabel lbChat             = new JLabel("CHAT", SwingConstants.CENTER);
	protected JTextField txtMsg         = new JTextField();
	protected JTextArea taMsg           = new JTextArea();
	protected JButton btnEnviar         = new JButton("Enviar");
	protected JComboBox cbUsu        = new JComboBox();
	protected ObjectInputStream receptor;
	protected ObjectOutputStream transmissor;
	//protected SalaUsuario sala;
	//protected SalasUsuario salas = new SalasUsuario();
	//protected Usuario usuario;
	//protected Socket s;

    public FormularioChat(String nomeUser, ObjectInputStream i, ObjectOutputStream o, String nomeSala)throws Exception
	    {
		try
		{
			System.out.println("aqui");
			System.out.println("aqui2");
			this.transmissor = o;
			System.out.println("aqui quase");
	        this.receptor = i;
			System.out.println("yayy");
			//this.s = new Socket("localhost",12346);
		}
		catch(Exception error)
		{
			throw new Exception("IP erradoo: " + error);
		}


	        transmissor.writeObject(nomeSala);
	        transmissor.writeObject(nomeUser);
            transmissor.flush();
			transmissor.flush();

          //  this.sala = new SalaUsuario(nomeSala, salas.descobrirSala(nomeSala).getQtd());
           // this.usuario = new Usuario(this.s,o,i,nomeUser, this.sala);//Socket conexao, ObjectOutputStream transmissor, ObjectInputStream receptor, String nome, SalaUsuario aSala

		lbChat.setFont(new Font("Segoe Script", 3, 50));
		lbChat.setForeground(new Color(0, 204, 0));

		lbUsuario.setFont(new Font("SansSerif", 1, 18));

		//lUsu.setFont(new Font("Calibri", 0, 18));
		//taMsg.setFont(new Font("Calibri", 0, 18));

		this.janela.setSize(660, 600);
		this.janela.getContentPane().setLayout(new BorderLayout());

		JPanel panelN = new JPanel();
		JPanel panelC = new JPanel();
		JPanel panelW = new JPanel();
		JPanel panelS = new JPanel();
		JPanel panelE = new JPanel();

		panelN.setLayout(new BorderLayout());
		panelC.setLayout(new BorderLayout());
		panelW.setLayout(new BorderLayout());
		panelS.setLayout(new BorderLayout());
		panelE.setLayout(new BorderLayout());

		this.janela.add(panelN, BorderLayout.NORTH);
		this.janela.add(panelC, BorderLayout.CENTER);
		this.janela.add(panelW, BorderLayout.WEST);
		this.janela.add(panelS, BorderLayout.SOUTH);
		this.janela.add(panelE, BorderLayout.EAST);

		panelN.add(lbChat, BorderLayout.NORTH);
		panelN.add(lbUsuario, BorderLayout.SOUTH);
		panelC.add(cbUsu, BorderLayout.WEST);
		panelS.add(txtMsg, BorderLayout.CENTER);
		panelS.add(btnEnviar, BorderLayout.EAST);
		//panelC.add(taMsg, BorderLayout.CENTER);

		//this.janela.add(btnEntrar, BorderLayout.SOUTH);
		//this.janela.add(lbUsuario, BorderLayout.NORTH);
		//this.janela.add(lbSalas, BorderLayout.NORTH);

		this.janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.janela.setVisible(true);

		//lUsu.setVisibleRowCount(this.sala.getQtd());

		/*lUsu.setModel(new AbstractListModel<String>()
		{
			String[] strings;

			for(int z = 0; z <= this.sala.getQtd(); z++)
		    {
			    strings[i] = {this.sala.getUsuario(z).getNickname()};
			}
		}

		public int getSize()
		{
			return strings.length;
		}

         public String getElementAt(int i)
         {
		   return strings[i];
		 }});*/

		 for(int z = 0; z <= this.sala.getQtd(); z++)
		{
			cbUsu.addItem(this.usuario.getNickname());
		}

	}

}
