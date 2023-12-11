package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Conexao;
import model.Paciente;

public class PacienteDAO {
	private Conexao conexao;
	private final String InserirPaciente = "insert into paciente(nome, doenca, estado) values(?,?,?)";
	private final String listarPacientes = "select id,nome,doenca,estado from paciente";
	private final String atualizarPaciente = "update paciente set nome=?,doenca=?,estado=? where id=?";
	private final String listaPacientePorId = "select id,nome,doenca,estado from paciente where id=?";
	private final String removerPacientePorId = "delete from paciente where id=?";
	
	public Paciente salvar(Paciente paciente) throws Exception {
		Connection con = Conexao.criaConexaoComPostgree();
		try{
			PreparedStatement pstm = con.prepareStatement(InserirPaciente);
			pstm.setString(1, paciente.getNome());
			pstm.setString(2, paciente.getDoenca());
			pstm.setString(3, paciente.getEstado());
			pstm.executeUpdate();
			return paciente;
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			con.close();
		}
		return null;
	}
	
	 public ArrayList<Paciente> listarTodos() throws Exception {
	        ArrayList<Paciente> listaPacientes = new ArrayList<>();
	        Connection con = Conexao.criaConexaoComPostgree();

	        PreparedStatement pstm;
	        try {
	            pstm = con.prepareStatement(listarPacientes);
	            ResultSet rs = pstm.executeQuery();
	            while (rs.next()) {
	                var paciente = new Paciente(rs.getInt("id"), rs.getString("nome"), rs.getString("doenca"), rs.getString("estado"));
	                listaPacientes.add(paciente);
	            }
	            System.out.println("P " + listaPacientes);
	            return listaPacientes;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	con.close();
	        }

	        return null;
	    }
	 
	 public Paciente atualizar(Paciente paciente) throws Exception {
	        Connection con = Conexao.criaConexaoComPostgree();
	        PreparedStatement pstm;
	        try {
	            System.out.println("ATUALIZAR");

	            pstm = con.prepareStatement(atualizarPaciente);
	            pstm.setString(1, paciente.getNome());
	            pstm.setString(2, paciente.getDoenca());
	            pstm.setString(3, paciente.getEstado());
	            pstm.setInt(4, paciente.getId());
	            pstm.execute();
	            return paciente;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	con.close();
	        }
	        return null;
	    }
	 
	 public void remover(Paciente paciente) throws Exception {
		    Connection con = Conexao.criaConexaoComPostgree();
		    PreparedStatement pstm;
		    try {
		        pstm = con.prepareStatement(removerPacientePorId);
		        pstm.setInt(1, paciente.getId());
		        pstm.execute();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }finally {
		    	con.close();
		    }
		    }
	 
	public Paciente getById(int id)throws Exception {
		Connection con = Conexao.criaConexaoComPostgree();
		Paciente paciente = null;
		PreparedStatement pstm;
		
		try {
			pstm = con.prepareStatement(listaPacientePorId);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			
			if (rs.next()){
				paciente = new Paciente(rs.getInt("id"),rs.getString("nome"),rs.getString("doenca"),rs.getString("estado"));
			} return paciente;
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return null;
	}
	
	public void selecionarPaciente(Paciente paciente)throws Exception {
		String select = "select * from pacientes where idPaciente = ?";
		
		Connection con = Conexao.criaConexaoComPostgree();
		PreparedStatement pstm = con.prepareStatement(select);
		try {
			pstm.setString(1, select);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				paciente.setId(rs.getInt(1));
				paciente.setNome(rs.getString(2)); 
				paciente.setDoenca(rs.getString(3));
				paciente.setEstado(rs.getString(4));
			}
		} catch (Exception e) {
			System.out.println(e);		
			}finally {
				con.close();
			}
	}
}