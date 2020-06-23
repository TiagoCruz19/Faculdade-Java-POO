package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionFactory;
import model.Aluno;

public class AlunoDAO {
	
	public String create(Aluno aluno) {
		
		String turma; 
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		String resp = null;
		
		String sql = "insert into aluno(nome,idade,id_turma) values (?, ?, ?)";
		
		try {
			System.out.println(aluno.getId_turma());
			
			stmt = con.prepareStatement(sql);  		//instancia uma instrucao sql
			stmt.setString(1, aluno.getNome()); 	//primeiro parametro da query
			stmt.setInt(2, aluno.getIdade()); 		//segundo parametro
			stmt.setInt(3, aluno.getId_turma());	//terceiro parametro
			
			stmt.executeUpdate();
			resp = "Aluno criado com sucesso";
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
			resp = "Aluno não atualizado";
		}
		
		finally {
			ConnectionFactory.closeConnection(con,stmt);
		}
		return resp;
		
	}
	
	public String update(Aluno aluno, String id_aluno) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		String resp = null;
		
		String sql = "update Aluno set nome = (?), idade = (?), id_turma =(?) where id_aluno = (?) ";
		
		try {
			
			System.out.println(aluno.getId_turma());
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			stmt.setInt(2, aluno.getIdade());
			stmt.setInt(3, aluno.getId_turma());
			stmt.setString(4, id_aluno);
			
			stmt.executeUpdate();
			
			resp = "Aluno atualizado com sucesso";
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
			resp = "Aluno não atualizado";
		}
		
		finally {
			ConnectionFactory.closeConnection(con,stmt);
		}
		return resp;
		
	}
	
	public String delete(String id_aluno) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		String resp;
		
		String sql = "delete from Aluno where id_aluno = (?)";
		
		try {
			
			stmt = con.prepareStatement(sql); 	//instancia uma instrução sql
			stmt.setString(1, id_aluno);		//primeiro parametro da query
			
			stmt.executeUpdate();
			
			resp = "Aluno excluido com sucesso";
		} catch (SQLException e) {
			e.printStackTrace();
			resp = "Aluno não excluido com sucesso";
		}
		finally {
			ConnectionFactory.closeConnection(con,stmt);
		}
		
		return resp;
		
	}
	
	public List<Aluno> readAll()

	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = " select id_aluno,nome,idade,id_turma from aluno";
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		try{
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Aluno aluno = new Aluno();
				aluno.setId_aluno(rs.getInt("id_aluno"));
				aluno.setNome(rs.getString("nome"));
				aluno.setIdade(rs.getInt("idade"));
				aluno.setId_turma(rs.getInt("Id_turma"));
				
				alunos.add(aluno);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Erro ao tentar ler tabela aluno");
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
		return alunos;
		
	}
	
	public String verificacao(String col, String cod) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "select id_aluno from aluno where id_aluno = ?";
		
		try {
			
			stmt = con.prepareStatement(sql);
			//stmt.setString(1, col);
			//stmt.setString(2, col);
			stmt.setInt(1, Integer.parseInt(cod));
			
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
