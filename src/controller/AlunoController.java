package controller;

import java.util.ArrayList;
import java.util.List;

import dao.AlunoDAO;
import model.Aluno;

public class AlunoController {
	
	public void create(Aluno aluno)
	{
		try {
			
			AlunoDAO dao = new AlunoDAO();

			dao.create(aluno);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro no Controller");
		}
		finally {
			System.out.println("Fim inserção");
		}
	}
	
	public List<Aluno> readAll()
	{
		List<Aluno> alunos = new ArrayList<Aluno>();
		try{
			AlunoDAO dao = new AlunoDAO();
			alunos = dao.readAll();		
		}
		finally {
			//System.out.println("Fim da leitura!");
		}
		
		return alunos;
	}
	
	public String verificacao(String col, String cod)
	{
		try {
			AlunoDAO dao = new AlunoDAO();
			
			cod = dao.verificacao(col, cod);
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return cod;
	}
	
	public String update(Aluno aluno, String id_aluno)
	{
		String resp = null;
		
		try {
			AlunoDAO dao = new AlunoDAO();
			
				resp = dao.update(aluno,id_aluno);
			
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return resp;
	}
	
	public String delete(String id_aluno)
	{
		String resp = null;
		try {
			AlunoDAO dao = new AlunoDAO();
			
				resp = dao.delete(id_aluno);
			
			return resp;
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
	}
	
	

}
