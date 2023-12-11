package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Paciente;
import model.Receita;
import conexao.Conexao;

public class ReceitaDAO {
	private Conexao conexao;
	private final String InserirReceita = "insert into receita(nome, medicamento, descricao) values(?,?,?)";
	private final String listarReceitas = "select idrec,nome,medicamento,descricao from receita";
	private final String atualizarReceita = "update medicamento set nome=?,medicamento=?,descricao=? where idrec=?";
	private final String listaReceitaPorId = "select id,nome,medicamento,descricao from medicamento where idrec=?";
	private final String removerReceitaPorId = "delete from receita where idrec=?";
	
	public ReceitaDAO(Conexao conexao) {
		this.conexao = conexao;
	}

	public Receita salvar(Receita receita) throws Exception {
		Connection con = Conexao.criaConexaoComPostgree();
		try{
			PreparedStatement pstm = con.prepareStatement(InserirReceita);
			pstm.setString(1, receita.getNome());
			pstm.setString(2, receita.getMedicamento());
			pstm.setString(3, receita.getDescricao());
			pstm.executeUpdate();
			return receita;
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			con.close();
		}
		return null;
	}
	
	 public ArrayList<Receita> listarTodos() throws Exception {
	        ArrayList<Receita> listaReceitas = new ArrayList<>();
	        Connection con = Conexao.criaConexaoComPostgree();

	        PreparedStatement pstm;
	        try {
	        	pstm = con.prepareStatement(listarReceitas);
	        	ResultSet rs = pstm.executeQuery();
	            while (rs.next()) {
	                var receita = new Receita(rs.getInt("id"), rs.getString("nome"), rs.getString("medicamento"), rs.getString("descricao"));
	                listaReceitas.add(receita);
	            }
	            System.out.println("P " + listaReceitas);
	            return listaReceitas;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	con.close();
	        }

	        return null;
	    }
	 
	 public Receita atualizar(Receita receita) throws Exception {
	        Connection con = Conexao.criaConexaoComPostgree();
	        PreparedStatement pstm;
	        try {
	            System.out.println("ATUALIZAR");

	            pstm = con.prepareStatement(atualizarReceita);
	            pstm.setString(1, receita.getNome());
	            pstm.setString(2, receita.getMedicamento());
	            pstm.setString(3, receita.getDescricao());
	            pstm.setInt(4, receita.getIdrec());
	            pstm.execute();
	            return receita;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	con.close();
	        }
	        return null;
	    }
	 
	 public void remover(int idrec) throws Exception {
		    Connection con = Conexao.criaConexaoComPostgree();
		    PreparedStatement pstm;
		    try {
		        pstm = con.prepareStatement(removerReceitaPorId);
		        pstm.setInt(1,idrec);
		        pstm.execute();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }finally {
		    	con.close();
		    }
		    }
	 
	public Receita getById(int idrec)throws Exception {
		Connection con = Conexao.criaConexaoComPostgree();
		Receita receita = null;
		PreparedStatement pstm;
		
		try {
			pstm = con.prepareStatement(listaReceitaPorId);
			pstm.setInt(1, idrec);
			ResultSet rs = pstm.executeQuery();
			
			if (rs.next()){
				receita = new Receita(rs.getInt("id"),rs.getString("nome"),rs.getString("medicamento"),rs.getString("descricao"));
			} return receita;
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return null;
	}
	public void selecionarReceita(Receita receita)throws Exception {
		String select = "select * from receitas where idReceita = ?";
		
		Connection con = Conexao.criaConexaoComPostgree();
		PreparedStatement pstm = con.prepareStatement(select);
		try {
			pstm.setString(1, select);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				receita.setIdrec(rs.getInt(1));
				receita.setNome(rs.getString(2)); 
				receita.setMedicamento(rs.getString(3));
				receita.setDescricao(rs.getString(4));
			}
		} catch (Exception e) {
			System.out.println(e);		
			}finally {
				con.close();
			}
	}
}