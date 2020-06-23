package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private String login="admin";
	private String senha="12345";
	private JPanel contentPane;
	private JTextField Login;
	private JPasswordField Senha;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 69, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSenha.setBounds(10, 43, 69, 22);
		contentPane.add(lblSenha);
		
		Login = new JTextField();
		Login.setBounds(74, 11, 254, 22);
		contentPane.add(Login);
		Login.setColumns(10);
		
		JLabel Resposta = new JLabel("");
		Resposta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Resposta.setBounds(74, 88, 254, 19);
		contentPane.add(Resposta);
		
		Senha = new JPasswordField();
		Senha.setBounds(74, 44, 254, 20);
		contentPane.add(Senha);
		
		JButton Entrar = new JButton("Entrar");
		Entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Login.getText().equals("admin") && Senha.getText().equals("12345")) {
					Principal p = new Principal();
					setVisible(false);
				}	
				else
				{
					Resposta.setText("senha ou login invalidos");
				}
				
			}
		});
		Entrar.setBounds(335, 227, 89, 23);
		contentPane.add(Entrar);
		
	}
}
