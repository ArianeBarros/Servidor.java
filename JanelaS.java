import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
class JanelaS
{
	private Socket s;
	private PrintWriter transmissor;

    private JFrame janela = new JFrame  ("Conversa");
	private JTextField tf = new JTextField();
	private JButton botao = new JButton();
	private JTextArea ta  = new JTextArea();


	public void Mostra(String msg, String nome)
	{
		ta.setText(ta.getText()+"\n"+nome+": "+msg);
	}

	//private class TratadorDeRedimensionamento implements ComponentListener
	//{
	 	public void componentResized(ComponentEvent e)
		{
	        Font fonte = new Font("Arial", Font.PLAIN, Math.min(janela.getHeight(),janela.getWidth())*22/220);
	    	botao.setFont (fonte);
		}

	        public void componentMoved(java.awt.event.ComponentEvent e)
	        {}

	        public void componentShown(java.awt.event.ComponentEvent e)
	        {}

			public void componentHidden(java.awt.event.ComponentEvent e)
			{}
	//}

	//private class TratadorDeEvento implements ActionListener
    //{
		private void TratadorDeEnviar()
		{
			String texto = tf.getText();
			transmissor.println(texto);
			transmissor.flush();
			Mostra(texto, "LORENNA");
		}
	//}

	public JanelaS (Socket s)
	{
		this.s = s;
		this.transmissor = new PrintWriter(this.s.getOutputStream());

		Font             fonte    = new Font("Arial", Font.PLAIN, 20);
		//TratadorDeEnviar enviar  = new TratadorDeEnviar ();

		this.botao.setFont(fonte);

		this.botao.add(TratadorDeEnviar());

	    this.janela.setSize (220,300);
		this.janela.getContentPane().setLayout(new BorderLayout());

	    this.janela.addComponentListener (new TratadorDeRedimensionamento());
		this.janela.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		this.janela.setVisible(true);
	}
}