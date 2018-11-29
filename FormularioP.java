import javax.swing.*;
import java.awt.*;

public class FormularioP
{
	protected JFrame janela             = new JFrame("CHAT");
	protected JLabel lbUsuario          = new JLabel("Nome usuário:");
	protected JLabel lbSalas            = new JLabel("Salas disponiveís");
	protected JLabel lbChat             = new JLabel("CHAT", SwingConstants.CENTER);
	protected JTextField txtNome        = new JTextField();
	protected JButton btnEntrar         = new JButton("Entrar");//, SwingConstants.RIGHT
	protected JComboBox<String> cbSalas = new JComboBox<String>();
    protected JPanel jp                 = new JPanel();



    public FormularioP()
    {
		lbChat.setFont(new Font("Segoe Script", 3, 50));
		lbChat.setForeground(new Color(0, 204, 0));

		lbSalas.setFont(new Font("SansSerif", 1, 18));

		lbUsuario.setFont(new Font("SansSerif", 1, 18));

		this.janela.setSize(760, 700);
		this.janela.getContentPane().setLayout(new BorderLayout());

		this.janela.add(lbChat, BorderLayout.NORTH);
		btnEntrar.setPreferredSize(new Dimension(40,40));

		this.janela.add(btnEntrar, BorderLayout.SOUTH);
		//this.janela.add(lbUsuario, BorderLayout.NORTH);
		//this.janela.add(lbSalas, BorderLayout.NORTH);

		this.janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.janela.setVisible(true);
	}
}
