import javax.swing.*;
import java.awt.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class FormularioChat
{
	protected JFrame janela             = new JFrame("CHAT");
	protected JLabel lbUsuario          = new JLabel("Usuários");
	protected JLabel lbChat             = new JLabel("CHAT", SwingConstants.CENTER);
	protected JTextField txtMsg         = new JTextField();
	protected JTextArea taMsg           = new JTextArea();
	protected JButton btnEnviar         = new JButton("Enviar");//, SwingConstants.RIGHT
	protected JList<String> lUsu        = new JList<String>();

	protected ObjectInputStream receptor;
	protected ObjectOutputStream transmissor;

    public FormularioChat(String nomeUser, String ip, String nomeSala)throws Exception
    {
	try
	{
		System.out.println("aqui");
		Socket meuSocket = new Socket(ip, 12345);
		System.out.println("aqui2");
		this.receptor = new ObjectInputStream(meuSocket.getInputStream());
		System.out.println("aqui quase");
        this.transmissor = new ObjectOutputStream(meuSocket.getOutputStream());
		System.out.println("yayy");
	}
	catch(Exception error)
	{
		throw new Exception("IP erradoo: " + error);
	}


        transmissor.writeObject(nomeSala);
        transmissor.writeObject(nomeUser);
        transmissor.flush();


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
		panelC.add(lUsu, BorderLayout.WEST);
		panelS.add(txtMsg, BorderLayout.CENTER);
		panelS.add(btnEnviar, BorderLayout.EAST);
		//panelC.add(taMsg, BorderLayout.CENTER);

		//this.janela.add(lbChat, BorderLayout.NORTH);

		//btnEntrar.setPreferredSize(new Dimension(40,40));
		//this.janela.add(btnEntrar, BorderLayout.SOUTH);
		//this.janela.add(lbUsuario, BorderLayout.NORTH);
		//this.janela.add(lbSalas, BorderLayout.NORTH);

		this.janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.janela.setVisible(true);

		/*

		 btnEntrar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnEntrarActionPerformed(evt);
			}
        });
	}

	  private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt)
	    {
			/*String escolhida = cbSalas.getSelectedIndex();
			int qtd = sala.getQtd();

			 sala = new SalaUsuario<Usuario>(escolhida, qtd);
			 //usuario = new Usuario(Socket conexao, ObjectOutputStream transmissor, ObjectInputStream receptor, txtNome.text, cbSalas.getSelectedItem());
	         sala.add(usuario);

	        new FormularioChat();
	        */
	}
}
