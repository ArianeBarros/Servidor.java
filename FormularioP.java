//package Servidor.java;

import javax.swing.*;
import java.awt.*;
import bd.*;

class FormularioP
{
	protected Salas salas = new Salas();

	protected JFrame janela             = new JFrame("CHAT");
	protected JLabel lbUsuario          = new JLabel("Nome usuário:");
	protected JLabel lbSalas            = new JLabel("Salas disponiveís");
	protected JLabel lbChat             = new JLabel("CHAT");
	protected JTextField txtNome        = new JTextField();
	protected JButton btnEntrar         = new JButton("Entrar");
	protected JComboBox<String> cbSalas = new JComboBox<String>();
    protected JPanel jp                 = new JPanel();

    public FormularioP() throws Exception
    {
		try
		{
			lbChat.setFont(new Font("Segoe Script", 3, 50));
			lbChat.setForeground(new Color(0, 204, 0));
			lbChat.setBounds(0, 0, 800, 600);

			lbSalas.setFont(new Font("SansSerif", 1, 18));

			lbUsuario.setFont(new Font("SansSerif", 1, 18));

			//cbSalas.setFont(new Font("Calibri", 0, 18));
			//cbSalas.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" })); //colocar os itens da sala

			//txtNome.setFont(new Font("SansSerif", 0, 18));
			//btnEntrar.setFont(new Font("Source Sans Pro Black", 1, 14));
			//btnEntrar.setSize(5, 10);

			this.janela.setSize(760, 700);
			//this.janela.getContentPane().setLayout(new GroupLayout());
			this.janela.getContentPane().setLayout(new BorderLayout());
			//
			this.janela.add(lbChat, BorderLayout.NORTH);
			//btnEntrar.setPreferredSize(new Dimension(40,40));

			//this.janela.add(btnEntrar);
			this.janela.add(cbSalas, BorderLayout.NORTH);
			exibeCb();
			this.janela.add(lbUsuario);
			this.janela.add(txtNome);
		    //this.janela.add(lbSalas, BorderLayout.NORTH);

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
		try
		{
		   for(int i = 0; i < 3; i++)
		   {
			 cbSalas.addItem((this.salas.getSala(i + 1)).toString());
		   }
	   }
	   catch(Exception error)
	   {
		   throw new Exception(error);
	   }

	}
}
