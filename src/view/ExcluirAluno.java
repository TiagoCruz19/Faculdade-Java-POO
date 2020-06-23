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

public class ExcluirAluno extends JFrame {
	private JTextField textID;

	public ExcluirAluno() {
		
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
			jf.setTitle("Excluir Aluno");
			jf.setSize(600, 400);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf.getContentPane().setLayout(null);
			
			JLabel lblNome = new JLabel("ID: ");
			lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNome.setBounds(181, 106, 20, 14);
			jf.getContentPane().add(lblNome);
			
			textID = new JTextField();
			textID.setColumns(10);
			textID.setBounds(205, 104, 121, 20);
			jf.getContentPane().add(textID);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(150, 156, 176, 14);
			jf.getContentPane().add(lblNewLabel);
			jf.setLocationRelativeTo(null);
			jf.setVisible(true);
			
			JButton ExcluirBTT = new JButton("Excluir");
			ExcluirBTT.setFont(new Font("Tahoma", Font.PLAIN, 12));
			ExcluirBTT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Aluno aluno = new Aluno();
					AlunoController controller = new AlunoController();
					
					if(textID.getText().equals(controller.verificacao("",textID.getText())))
					{
						controller.delete(textID.getText());
					    lblNewLabel.setText("Excluido com sucesso");
					}
					else {
					lblNewLabel.setText("Matricula nao existe");
					}
					
				}
			});
			ExcluirBTT.setBounds(336, 103, 89, 23);
			jf.getContentPane().add(ExcluirBTT);
			
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
		ExcluirAluno j1 = new ExcluirAluno();
	}
}
