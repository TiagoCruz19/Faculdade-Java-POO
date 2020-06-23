package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.AlunoController;
import model.Aluno;

public class AlterarAluno extends JFrame {
	private JTextField textIdade;
	private JTextField textTurma;
	private JTextField textID;
	private JTextField textField;

	public AlterarAluno() {
		
		//criando o frame
			JFrame jf = new JFrame();
			Font fonte = new Font("Comfortaa",Font.ITALIC,15);
			
			JMenuBar barra = new JMenuBar();
			
				JMenu menu1 = new JMenu("Cadastrar");
				menu1.setFont(fonte);
					JMenuItem item1_1 = new JMenuItem("Turma");
					JMenuItem item1_2 = new JMenuItem("Professor");
					JMenuItem item1_3 = new JMenuItem("Aluno");
					
				JMenu menu2 = new JMenu("Excluir");
				menu2.setFont(fonte);
					JMenuItem item2_1 = new JMenuItem("Turma");
					JMenuItem item2_2 = new JMenuItem("Professor");
					JMenuItem item2_3 = new JMenuItem("Aluno");
					
				JMenu menu3 = new JMenu("Alterar");
				menu3.setFont(fonte);
					JMenuItem item3_1 = new JMenuItem("Turma");
					JMenuItem item3_2 = new JMenuItem("Professor");
					JMenuItem item3_3 = new JMenuItem("Aluno");
					
					JMenu menu4 = new JMenu("Visualizar");
					menu4.setFont(fonte);
						JMenuItem item4_1 = new JMenuItem("Turma");
						JMenuItem item4_2 = new JMenuItem("Professor");
						JMenuItem item4_3 = new JMenuItem("Aluno");
		
		//configurando o frame
								
			jf.setTitle("Alterar Aluno");
			jf.setSize(600, 400);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf.getContentPane().setLayout(null);
			
			JLabel lblNewLabel_1_1 = new JLabel("Nova Idade:");
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1_1.setBounds(162, 143, 66, 14);
			jf.getContentPane().add(lblNewLabel_1_1);
			
			JLabel resposta = new JLabel("");
			resposta.setBounds(102, 204, 186, 18);
			jf.getContentPane().add(resposta);
			jf.setLocationRelativeTo(null);
			jf.setVisible(true);
			
			textIdade = new JTextField();
			textIdade.setFont(new Font("Tahoma", Font.PLAIN, 12));
			textIdade.setColumns(10);
			textIdade.setBounds(229, 140, 121, 20);
			jf.getContentPane().add(textIdade);
			
			JButton AlterarBTT = new JButton("Alterar");
			AlterarBTT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Aluno aluno = new Aluno();
					AlunoController controller = new AlunoController();
					
					aluno.setId_aluno(Integer.parseInt(textID.getText()));
					
					if(textID.getText().equals(controller.verificacao("id_aluno",textID.getText()))) {
						
						aluno.setNome(textField.getText());
						aluno.setIdade(Integer.parseInt(textIdade.getText()));
						aluno.setId_turma(Integer.parseInt(textTurma.getText()));
	
						controller.update(aluno,textID.getText());
						
						resposta.setText("Concluido");
					}
					else
					{
						System.out.println("Id informado nao existe");
						resposta.setText("Id informado nao existe");
					}
					
				}
			});
			AlterarBTT.setFont(new Font("Tahoma", Font.PLAIN, 12));
			AlterarBTT.setBounds(343, 213, 89, 23);
			jf.getContentPane().add(AlterarBTT);
			
			
			JLabel lblNewLabel_1_1_1 = new JLabel("Nova Turma:");
			lblNewLabel_1_1_1.setBounds(158, 171, 70, 14);
			jf.getContentPane().add(lblNewLabel_1_1_1);
			lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			
			textTurma = new JTextField();
			textTurma.setFont(new Font("Tahoma", Font.PLAIN, 12));
			textTurma.setBounds(229, 168, 121, 20);
			jf.getContentPane().add(textTurma);
			textTurma.setColumns(10);
			
			textID = new JTextField();
			textID.setFont(new Font("Tahoma", Font.PLAIN, 12));
			textID.setColumns(10);
			textID.setBounds(229, 73, 121, 20);
			jf.getContentPane().add(textID);
			
			JLabel lblIdOriginal = new JLabel("ID:");
			lblIdOriginal.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblIdOriginal.setBounds(212, 76, 16, 14);
			jf.getContentPane().add(lblIdOriginal);
			
			JLabel lblNewLabel_1_1_2 = new JLabel("Novo Nome:");
			lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1_1_2.setBounds(158, 118, 70, 14);
			jf.getContentPane().add(lblNewLabel_1_1_2);
			
			textField = new JTextField();
			textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
			textField.setColumns(10);
			textField.setBounds(229, 112, 121, 20);
			jf.getContentPane().add(textField);
			jf.setLocationRelativeTo(null);
			jf.setVisible(true);
			
		//barra
			jf.setJMenuBar(barra);
			
			Color Cor_Back_barra = new Color(255,255,77);
			barra.setBackground(Cor_Back_barra);
			

			
			//menus
				barra.add(menu1);
				barra.add(menu2);
				barra.add(menu3);
				barra.add(menu4);
				
			//itens
				Color Cor_Back_itens = new Color(255,255,255);
				
					menu1.add(item1_1);
						menu1.setBackground(Cor_Back_barra);
						item1_1.setBackground(Cor_Back_itens);
					menu1.add(item1_2);
						item1_2.setBackground(Cor_Back_itens);
					menu1.add(item1_3);
						item1_3.setBackground(Cor_Back_itens);
						
					menu2.add(item2_1);
						item2_1.setBackground(Cor_Back_itens);
					menu2.add(item2_2);
						item2_2.setBackground(Cor_Back_itens);
					menu2.add(item2_3);
						item2_3.setBackground(Cor_Back_itens);
					
					menu3.add(item3_1);
						item3_1.setBackground(Cor_Back_itens);
					menu3.add(item3_2);
						item3_2.setBackground(Cor_Back_itens);
					menu3.add(item3_3);
						item3_3.setBackground(Cor_Back_itens);
						
					menu4.add(item4_1);
						item4_1.setBackground(Cor_Back_itens);
					menu4.add(item4_2);
						item4_2.setBackground(Cor_Back_itens);
					menu4.add(item4_3);
						item4_3.setBackground(Cor_Back_itens);
					
				//ações
						
						//cadastrar
						item1_1.addActionListener(new ActionListener()
						{public void actionPerformed(ActionEvent e)
						{
							CadastrarTurma j1 = new CadastrarTurma();
							jf.setVisible(false);
						}});
				
						item1_2.addActionListener(new ActionListener()
						{public void actionPerformed(ActionEvent e)
						{
							CadastrarProfessor j1 = new CadastrarProfessor();
							jf.setVisible(false);
						}});
				
						item1_3.addActionListener(new ActionListener()
						{public void actionPerformed(ActionEvent e)
						{
							CadastrarAluno j1 = new CadastrarAluno();
							jf.setVisible(false);
						}});
				
					//excluir
						item2_1.addActionListener(new ActionListener()
						{public void actionPerformed(ActionEvent e)
						{
							ExcluirTurma j1 = new ExcluirTurma();
							jf.setVisible(false);
						}});
				
						item2_2.addActionListener(new ActionListener()
						{public void actionPerformed(ActionEvent e)
						{
							ExcluirProfessor j1 = new ExcluirProfessor();
							jf.setVisible(false);
						}});
				
						item2_3.addActionListener(new ActionListener()
						{public void actionPerformed(ActionEvent e)
						{
							ExcluirAluno j1 = new ExcluirAluno();
							jf.setVisible(false);
						}});
				
					//alterar
						item3_1.addActionListener(new ActionListener()
						{public void actionPerformed(ActionEvent e)
						{
							AlterarTurma j1 = new AlterarTurma();
							jf.setVisible(false);
						}});
				
						item3_2.addActionListener(new ActionListener()
						{public void actionPerformed(ActionEvent e)
						{
							AlterarProfessor j1 = new AlterarProfessor();
							jf.setVisible(false);
						}});
				
						item3_3.addActionListener(new ActionListener()
						{public void actionPerformed(ActionEvent e)
						{
							AlterarAluno j1 = new AlterarAluno();
							jf.setVisible(false);
						}});
						
					//visualizar
						item4_1.addActionListener(new ActionListener()
						{public void actionPerformed(ActionEvent e)
						{
							VisualizarTurma j1 = new VisualizarTurma();
							jf.setVisible(false);
						}});
				
						item4_2.addActionListener(new ActionListener()
						{public void actionPerformed(ActionEvent e)
						{
							VisualizarProfessor j1 = new VisualizarProfessor();
							jf.setVisible(false);
						}});
				
						item4_3.addActionListener(new ActionListener()
						{public void actionPerformed(ActionEvent e)
						{
							VisualizarAluno j1 = new VisualizarAluno();
							jf.setVisible(false);
						}});
	}	

	public static void main(String[] args)
	{
		AlterarAluno j1 = new AlterarAluno();
	}
}