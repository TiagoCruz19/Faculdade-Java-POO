package controller;

import java.util.ArrayList;
import java.util.List;

import dao.ProfessorDAO;
import model.Professor;

public class ProfessorController {
	
	public void create(Professor professor)
	{
		try {
			
			ProfessorDAO dao = new ProfessorDAO();

			dao.create(professor);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro no Controller");
		}
		finally {
			System.out.println("Fim inserção");
		}
	}
	
	public List<Professor> readAll()
	{
		List<Professor> professors = new ArrayList<Professor>();
		try{
			ProfessorDAO dao = new ProfessorDAO();
			professors = dao.readAll();		
		}
		finally {
			//System.out.println("Fim da leitura!");
		}
		
		return professors;
	}
	
	public String verificacao(String col, String cod)
	{
		try {
			ProfessorDAO dao = new ProfessorDAO();
			
			cod = dao.verificacao(col, cod);
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return cod;
	}
	
	public String update(Professor professor, String id_professor)
	{
		String resp = null;
		
		try {
			ProfessorDAO dao = new ProfessorDAO();
			
				resp = dao.update(professor,id_professor);
			
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return resp;
	}
	
	public String delete(String id_professor)
	{
		String resp = null;
		try {
			ProfessorDAO dao = new ProfessorDAO();
			
				resp = dao.delete(id_professor);
			
			return resp;
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
	}
	
	

}
