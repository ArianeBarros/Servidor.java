import controle.*;
import javax.swing.*;
import java.awt.*;
import controle.bd.*;
import java.net.*;
import java.io.*;
import java.awt.event.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import controle.enviaveis.*;

public class FormularioChat
{
	protected JFrame janela             = new JFrame("CHAT");
	protected JLabel lbUsuario          = new JLabel("Usuários");
	protected JLabel lbChat;
	protected JTextField txtMsg         = new JTextField();
	protected JTextArea ta          = new JTextArea("");
	protected JButton btnEnviar         = new JButton("Enviar");
	protected JButton btnSair         = new JButton("Sair");
	protected JComboBox cbUsu        = new JComboBox();
	protected ObjectInputStream receptor;
	protected ObjectOutputStream transmissor;
	private String nome;

    public FormularioChat(String nomeUser, ObjectInputStream i, ObjectOutputStream o, String nomeSala)throws Exception
	    {
		try
		{
			this.transmissor = o;
	        this.receptor = i;
		}
		catch(Exception error)
		{
			throw new Exception("IP erradoo: " + error);
		}


	        transmissor.writeObject(nomeSala);	//2
	        transmissor.writeObject(nomeUser);	   //3
            transmissor.flush();
			transmissor.flush();

									  this.nome = nomeUser;

		lbChat = new JLabel(nomeSala, SwingConstants.CENTER);
		lbChat.setFont(new Font("Segoe Script", 3, 50));
		lbChat.setForeground(new Color(0, 204, 0));

		lbUsuario.setFont(new Font("SansSerif", 1, 18));

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
		panelN.add(lbUsuario, BorderLayout.WEST);
		panelN.add(cbUsu, BorderLayout.SOUTH);
		panelS.add(txtMsg, BorderLayout.CENTER);
		panelS.add(btnEnviar, BorderLayout.EAST);
		panelC.add(ta, BorderLayout.CENTER);
		panelS.add(btnSair, BorderLayout.EAST);

		ta.setEnabled(false);

		this.janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.janela.setVisible(true);


		btnSair.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent ev) {
						try
						{
		                	transmissor.writeObject(new AvisoDeSaidaDaSala(nome));
		                	transmissor.flush();
						}
						catch(Exception erro)
						{
							System.err.println("Janela fechando: " + erro.getMessage());
						}
		            }
        });

		  btnEnviar.addActionListener(new ActionListener()
		 {
			 public void actionPerformed(ActionEvent event)
			 {
				 try
				 {
					 if(txtMsg.getText() != "")
					{
						System.out.println("entrei");
						transmissor.writeObject(new Mensagem(txtMsg.getText()));
						transmissor.flush();
					 }
				}
				catch(Exception erro)
				{
					System.out.println(erro);
				}
			 }
		    });
		    Receptora rec = new Receptora(this.receptor);
		    rec.start();
	}

	private class Receptora	extends Thread
	{
		protected ObjectInputStream receptor;
		protected boolean viva = true;

		public Receptora(ObjectInputStream r) throws Exception
		{
			if(r == null)
				throw new Exception("Receptor inválido!");

			this.receptor = r;
		}

		public void run()
		{
			try
			{
				while(this.viva)
				{
					Enviavel e = (Enviavel)receptor.readObject();
					System.out.println(e.getClass().getName());
					switch(e.getClass().getName())
					{
						case "Mensagem": e = (Mensagem) e;	break;
						case "controle.enviaveis.AvisoDeEntradaNaSala": e = (AvisoDeEntradaNaSala)e; cbUsu.addItem(((AvisoDeEntradaNaSala)e).getNick()); break;
						case "controle.enviaveis.AvisoDeSaidaDaSala": e = (AvisoDeSaidaDaSala)e; for(int i = 0; i < cbUsu.getItemCount(); i++)
																				if(cbUsu.getItemAt(i).equals(((AvisoDeSaidaDaSala)e).getNick()))
																					cbUsu.remove(i);break;
					}
					ta.append(nome + ": " + e.envia() + "\n");
				}

			}
			catch(Exception erro)
			{
				System.err.println("Erro na Receptora:" + erro);
				this.viva = false;
			}
		}
	}

}
