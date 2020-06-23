package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionFactory;
import model.Professor;

public class ProfessorDAO {
	
	public String create(Professor professor) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		String resp = null;
		
		String sql = "insert into professor(nome,materia) values (?, ?)";
		
		try {
			
			stmt = con.prepareStatement(sql);  				//instancia uma instrucao sql
			stmt.setString(1, professor.getNome()); 		//primeiro parametro da query
			stmt.setString(2, professor.getMateria()); 		//segundo parametro

			
			stmt.executeUpdate();
			resp = "Professor criado com sucesso";
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
			resp = "Professor não atualizado";
		}
		
		finally {
			ConnectionFactory.closeConnection(con,stmt);
		}
		return resp;
		
	}
	
	public String update(Professor Professor, String id_professor) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		String resp = null;
		
		String sql = "update Professor set id_professor = (?), nome = (?), materia = (?) where id_professor = (?) ";
		
		try {
			
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, Professor.getId_professor());
			stmt.setString(2, Professor.getNome());
			stmt.setString(3, Professor.getMateria());
			stmt.setString(4, id_professor);
			
			stmt.executeUpdate();
			
			resp = "Professor atualizado com sucesso";
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
			resp = "Professor não atualizado";
		}
		
		finally {
			ConnectionFactory.closeConnection(con,stmt);
		}
		return resp;
		
	}
	
	public String delete(String id_professor) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		String resp;
		
		String sql = "delete from Professor where id_professor = (?)";
		
		try {
			
			stmt = con.prepareStatement(sql); 		//instancia uma instrução sql
			stmt.setString(1, id_professor);		//primeiro parametro da query
			
			stmt.executeUpdate();
			
			resp = "Professor excluido com sucesso";
		} catch (SQLException e) {
			e.printStackTrace();
			resp = "Professor não excluido com sucesso";
		}
		finally {
			ConnectionFactory.closeConnection(con,stmt);
		}
		
		return resp;
		
	}
	
	public List<Professor> readAll()

	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = " select id_professor,nome,materia from professor";
		List<Professor> professors = new ArrayList<Professor>();
		
		try{
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Professor professor = new Professor();
				professor.setId_professor(rs.getInt("id_professor"));
				professor.setNome(rs.getString("nome"));
				professor.setMateria(rs.getString("materia"));
				
				professors.add(professor);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Erro ao tentar ler tabela professor");
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
		return professors;
		
	}
	
	public String verificacao(String col, String cod) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "select id_professor from Professor where id_professor = (?)";
		
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
