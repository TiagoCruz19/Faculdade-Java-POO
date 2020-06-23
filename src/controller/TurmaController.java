package controller;

import java.util.ArrayList;
import java.util.List;

import dao.TurmaDAO;
import model.Turma;

public class TurmaController {
	
	public void create(Turma turma)
	{
		try {
			
			TurmaDAO dao = new TurmaDAO();

			dao.create(turma);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro no Controller");
		}
		finally {
			System.out.println("Fim inserção");
		}
	}
	
	public List<Turma> readAll()
	{
		List<Turma> turmas = new ArrayList<Turma>();
		try{
			TurmaDAO dao = new TurmaDAO();
			turmas = dao.readAll();		
		}
		finally {
			//System.out.println("Fim da leitura!");
		}
		
		return turmas;
	}
	
	public String verificacao(String col, String cod)
	{
		try {
			TurmaDAO dao = new TurmaDAO();
			
			cod = dao.verificacao(col, cod);
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return cod;
	}
	
	public String update(Turma turma, String id_turma)
	{
		String resp = null;
		
		try {
			TurmaDAO dao = new TurmaDAO();
			
				resp = dao.update(turma,id_turma);
			
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return resp;
	}
	
	public String delete(String id_turma)
	{
		String resp = null;
		try {
			TurmaDAO dao = new TurmaDAO();
			
				resp = dao.delete(id_turma);
			
			return resp;
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
	}
	
	

}
