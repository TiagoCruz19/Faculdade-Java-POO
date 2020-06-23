  
package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.AlunoController;
import model.Aluno;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpringLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

public class VisualizarAluno extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VisualizarAluno() {
		setTitle("Listagem de Alunos");
		setVisible(true);
		setBounds(100, 100, 700, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		AlunoController controller = new AlunoController();
		
		
		for(Aluno aluno:controller.readAll())
		{
			JLabel txtMatricula = new JLabel("Matricula");
			contentPane.add(txtMatricula, "flowy,cell 0 0");
			
			JTextField textField = new JTextField();
			contentPane.add(textField, "cell 0 0,alignx left,aligny top");
			textField.setColumns(10);
			textField.setText(Integer.toString(aluno.getId_aluno()));
			
			JLabel txtNome = new JLabel("Nome");
			contentPane.add(txtNome, "cell 0 1");
			
			JTextField textField_1 = new JTextField();
			contentPane.add(textField_1, "cell 0 2,alignx right \n");
			textField_1.setColumns(10);
			textField_1.setText(aluno.getNome());
			
			JLabel txtsexo = new JLabel("Idade");
			contentPane.add(txtsexo, "cell 0 1");
			
			JTextField textField_2 = new JTextField();
			contentPane.add(textField_2, "cell 0 2,alignx right \n");
			textField_2.setColumns(10);
			textField_2.setText(Integer.toString(aluno.getIdade()));
			
			JLabel txtid_turma = new JLabel("idturma");
			contentPane.add(txtid_turma, "cell 0 1");
			
			JTextField textField_3 = new JTextField();
			contentPane.add(textField_3, "cell 0 2,alignx right \n");
			textField_3.setColumns(10);
			textField_3.setText(Integer.toString(aluno.getId_turma()));
		
		}
		
		JButton btnNewButton = new JButton("Atualizar");
		contentPane.add(btnNewButton, "cell 0 0,alignx left,aligny top");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisualizarAluno jp = new VisualizarAluno();
				setVisible(false);
			}
		});

	}
}
