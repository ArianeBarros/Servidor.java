//pakage Servidor

import controle.*;
import javax.swing.*;
import java.awt.*;
import controle.bd.*;
import java.net.*;
import java.io.*;
import java.awt.event.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

class FormularioP
{
	protected Salas salas = new Salas();
	ServerSocket s = new ServerSocket(12345);
 	//protected SalaUsuario salaUsuario;

	protected JFrame janela             = new JFrame("CHAT");
	protected JLabel lbUsuario          = new JLabel("Nome usuário:");
	//protected JLabel lbIp               = new JLabel("IP da máquina: ");
	protected JLabel lbSalas            = new JLabel("Salas disponiveís: ");
	protected JLabel lbChat             = new JLabel("CHAT");
	protected JTextField txtNome        = new JTextField();
	protected JTextField txtErro        = new JTextField();
	protected JButton btnEntrar         = new JButton("Entrar");
	protected JComboBox<String> cbSalas = new JComboBox<String>();

    public FormularioP() throws Exception
    {
		try
		{
			lbChat.setFont(new Font("Segoe Script", 3, 50));
			lbChat.setForeground(new Color(0, 204, 0));

			lbSalas.setFont(new Font("SansSerif", 1, 18));

			lbUsuario.setFont(new Font("SansSerif", 1, 18));

			//lbIp.setFont(new Font("SansSerif", 1, 18));

			txtNome.setFont(new Font("SansSerif", 0, 18));
			txtErro.setFont(new Font("SansSerif", 0, 18));

			cbSalas.setFont(new Font("Calibri", 0, 18));
			//cbSalas.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

			btnEntrar.setFont(new Font("Source Sans Pro Black", 1, 14));
			btnEntrar.setSize(5, 10);

			this.janela.setSize(360, 230);
			this.janela.getContentPane().setLayout(new BorderLayout());

			JPanel panelN = new JPanel();
			JPanel panelC = new JPanel();
			JPanel panelW = new JPanel();
			JPanel panelS = new JPanel();
			JPanel panelE = new JPanel();
			//JPanel h = new JPanel();

			//gridlayout -- 1 coluna, 5 linhas

			panelN.setLayout(new BorderLayout());
			panelC.setLayout(new BorderLayout());
			panelW.setLayout(new BorderLayout());
			panelS.setLayout(new BorderLayout());
			panelE.setLayout(new BorderLayout());
			//h.setLayout(new BorderLayout());

			this.janela.add(panelN, BorderLayout.NORTH);
			this.janela.add(panelC, BorderLayout.CENTER);
			this.janela.add(panelW, BorderLayout.WEST);
			this.janela.add(panelS, BorderLayout.SOUTH);
			this.janela.add(panelE, BorderLayout.EAST);


			panelN.add(lbChat, BorderLayout.NORTH);
			panelW.add(lbUsuario, BorderLayout.NORTH);
			//panelW.add(lbIp, BorderLayout.CENTER);
			panelC.add(txtNome, BorderLayout.NORTH);
			//panelC.add(txtIp, BorderLayout.CENTER);
			panelW.add(lbSalas, BorderLayout.SOUTH);
			panelC.add(cbSalas, BorderLayout.SOUTH);
			panelS.add(txtErro, BorderLayout.SOUTH);


			//this.janela.add(cbSalas, BorderLayout.CENTER);
			//panelC.add(cbSalas, BorderLayout.CENTER);
			//cbSalas.setPreferredSize( new Dimension(10,10) );

			exibeCb();

			panelS.add(btnEntrar, BorderLayout.EAST);

            btnEntrar.addActionListener(new ActionListener()
            {
				 public void actionPerformed(ActionEvent event)
				 {
					 try
					 {
						 if(txtNome.getText() == "" || txtNome.getText() == null || cbSalas.getSelectedItem().toString() == "Selecione uma sala")
						 	txtErro.setText("Forneça um nome e uma sala adequada");
						 else
						 {

						 	Socket meuSocket  = new Socket("localhost",12346);
							ObjectInputStream i = new ObjectInputStream(meuSocket.getInputStream());
						 	ObjectOutputStream o = new ObjectOutputStream(meuSocket.getOutputStream());
						 	System.out.println(cbSalas.getSelectedItem().toString() + " pegando valor");
                            new FormularioChat(txtNome.getText() , i,o, cbSalas.getSelectedItem().toString());
						 }


					}
					catch(Exception erro)
					{
						System.out.println(erro);
					}
				 }
		    });

			this.janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.janela.setVisible(true);
		}
		catch(Exception error)
		{
			throw new Exception(error);
		}
	}

		public void exibeCb()throws Exception
		{
			txtErro.setEditable(false);

			 Sala sala;
			 cbSalas.addItem("Selecione uma sala");
			try
			{
			   for(int i = 0; i < 3; i++)
			   {
				  sala = new Sala(this.salas.getSala(i + 1));

				  SalaUsuario salaUser = new SalaUsuario(sala.getNome(), sala.getQtd());

                  if(!salaUser.isCheia())
				    cbSalas.addItem(sala.getNome());
			   }

			     cbSalas.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent event)
				 {
	               	JComboBox comboBox = (JComboBox) event.getSource();

				   	// Print the selected items and the action command.
				   	Object selected = comboBox.getSelectedItem();
				   	System.out.println("Selected Item  = " + selected);
				   	String command = event.getActionCommand();
				   	System.out.println("Action Command = " + command);

                    if ("comboBoxChanged".equals(command))
				   	{
				   		System.out.println("User has selected an item " +
				   				"from the combo box.");

		            }
				 }
				});
		   }
		   catch(Exception error)
		   {
			   throw new Exception(error);
		   }

	}

}
