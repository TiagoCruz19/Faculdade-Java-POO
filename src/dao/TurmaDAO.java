package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionFactory;
import model.Turma;

public class TurmaDAO {
	
	public String create(Turma turma) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		String resp = null;
		
		String sql = "insert into turma(nome,id_professor) values (?, ?)";
		
		try {
			
			stmt = con.prepareStatement(sql);  				//instancia uma instrucao sql
			stmt.setString(1, turma.getNome()); 			//primeiro parametro da query
			stmt.setInt(2, turma.getId_professor()); 		//segundo parametro

			
			stmt.executeUpdate();
			resp = "Turma criado com sucesso";
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
			resp = "Turma não atualizado";
		}
		
		finally {
			ConnectionFactory.closeConnection(con,stmt);
		}
		return resp;
		
	}
	
	public String update(Turma Turma, String id_turma) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		String resp = null;
		
		String sql = "update Turma set id_turma = (?), nome = (?), id_professor = (?) where id_turma = (?) ";
		
		try {
			
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, Turma.getId_turma());
			stmt.setString(2, Turma.getNome());
			stmt.setInt(3, Turma.getId_professor());
			stmt.setString(4, id_turma);
			
			stmt.executeUpdate();
			
			resp = "Turma atualizado com sucesso";
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
			resp = "Turma não atualizado";
		}
		
		finally {
			ConnectionFactory.closeConnection(con,stmt);
		}
		return resp;
		
	}
	
	public String delete(String id_turma) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		String resp;
		
		String sql = "delete from Turma where id_turma = (?)";
		
		try {
			
			stmt = con.prepareStatement(sql); 		//instancia uma instrução sql
			stmt.setString(1, id_turma);		//primeiro parametro da query
			
			stmt.executeUpdate();
			
			resp = "Turma excluido com sucesso";
		} catch (SQLException e) {
			e.printStackTrace();
			resp = "Turma não excluido com sucesso";
		}
		finally {
			ConnectionFactory.closeConnection(con,stmt);
		}
		
		return resp;
		
	}
	
	public List<Turma> readAll()

	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = " select id_turma,nome,id_professor from turma";
		List<Turma> turmas = new ArrayList<Turma>();
		
		try{
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Turma turma = new Turma();
				turma.setId_turma(rs.getInt("id_turma"));
				turma.setNome(rs.getString("nome"));
				turma.setId_professor(rs.getInt("id_professor"));
				
				turmas.add(turma);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Erro ao tentar ler tabela turma");
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
		return turmas;
		
	}
	
	public String verificacao(String col, String cod) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "select id_turma from Turma where id_turma = (?)";
		
		try {
			
			stmt = con.prepareStatement(sql);
			//stmt.setString(1, col);
			//stmt.setString(2, col);
			stmt.setString(1, cod);
			
			rs = stmt.executeQuery();
			
			if(!rs.next())
			{
				cod = null;
			}	
			
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			ConnectionFactory.closeConnection(con,stmt);
		}
		
		return cod;
		
	}

}
