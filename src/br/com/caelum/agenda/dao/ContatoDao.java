package br.com.caelum.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.agenda.ConnectionFactory;
import br.com.caelum.agenda.modelo.Contato;

public class ContatoDao {
	
	private Connection connection;
	
	public ContatoDao(Connection connection) {
		this.connection = connection;
	}
	
	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato) {
		String sql = "INSERT INTO contatos "
				+ "(nome, email, endereco, dataNascimento)"
				+ "VALUES (?, ?, ?, ?)";
		
		try {
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setString(1, contato.getNome());
			psmt.setString(2, contato.getEmail());
			psmt.setString(3, contato.getEndereco());
			psmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			psmt.execute();
			psmt.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	}
	
	public List<Contato> getLista(){
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement psmt = connection.prepareStatement("SELECT * FROM contatos");
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				contatos.add(contato);
			}
			rs.close();
			psmt.close();
			return contatos;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	}
	
	public Contato pesquisa(long id) {
		try {
			Contato contato = null;
			PreparedStatement psmt = connection.prepareStatement("Select * from contatos where id = ?");
			psmt.setLong(1, id);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				contato = new Contato();
				contato.setId(Long.parseLong(rs.getString("id")));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
			}
			psmt.close();
			rs.close();
			return contato;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Contato contato) {
		String sql = "UPDATE contatos SET nome=?, email=?, endereco=?, dataNascimento=? WHERE id=?";
		try {
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setString(1, contato.getNome());
			psmt.setString(2, contato.getEmail());
			psmt.setString(3, contato.getEndereco());
			psmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			psmt.setLong(5, contato.getId());
			psmt.execute();
			psmt.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void remove(long id) {
		String sql = "DELETE FROM contatos WHERE id=?";
		try {
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setLong(1, id);
			psmt.execute();
			psmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
