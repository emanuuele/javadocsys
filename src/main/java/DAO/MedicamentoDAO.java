package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import model.Medicamento;
import model.Paciente;
import conexao.Conexao;

public class MedicamentoDAO {
	private Connection conexao;
	private final String InserirMedicamento = "insert into medicamento(nome, preco, qtd) values(?,?,?)";
	private final String listarMedicamentos = "select idmed,nome,preco,qtd from medicamento";
	private final String atualizarMedicamento = "update medicamento set nome=?,preco=?,qtd=? where idmed=?";
	private final String listaMedicamentoPorId = "select idmed,nome,preco,qtd from medicamento where idmed=?";
	private final String removerMedicamentoPorId = "delete from medicamento where idmed=?";

	public MedicamentoDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public Medicamento salvar(Medicamento medicamento) throws Exception {
		Connection con = Conexao.criaConexaoComPostgree();
		try {
			PreparedStatement pstm = con.prepareStatement(InserirMedicamento);
			pstm.setString(1, medicamento.getNome());
			pstm.setDouble(2, medicamento.getPreco());
			pstm.setInt(3, medicamento.getQtd());
			pstm.executeUpdate();
			return medicamento;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return null;
	}

	public ArrayList<Medicamento> listarTodos() throws Exception {
		ArrayList<Medicamento> listaMedicamentos = new ArrayList<>();
		Connection con = Conexao.criaConexaoComPostgree();

		PreparedStatement pstm;
		try {
			pstm = con.prepareStatement(listarMedicamentos);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				var medicamento = new Medicamento(rs.getInt("id"), rs.getString("nome"), rs.getDouble("preco"),
						rs.getInt("id"));
				listaMedicamentos.add(medicamento);
			}
			System.out.println("P " + listaMedicamentos);
			return listaMedicamentos;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return null;
	}

	public Medicamento atualizar(Medicamento medicamento) throws Exception {
		Connection con = Conexao.criaConexaoComPostgree();
		PreparedStatement pstm;
		try {
			System.out.println("ATUALIZAR");

			pstm = con.prepareStatement(atualizarMedicamento);
			pstm.setString(1, medicamento.getNome());
			pstm.setDouble(2, medicamento.getPreco());
			pstm.setInt(3, medicamento.getQtd());
			pstm.setInt(4, medicamento.getIdmed());
			pstm.execute();
			return medicamento;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();

		}

		return null;
	}

	public void remover(int idmed) throws Exception {
		Connection con = Conexao.criaConexaoComPostgree();
		PreparedStatement pstm;
		try {
			pstm = con.prepareStatement(removerMedicamentoPorId);
			pstm.setInt(1, idmed);
			pstm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

	}

	public Medicamento getById(int idmed) throws Exception {
		Connection con = Conexao.criaConexaoComPostgree();
		Medicamento medicamento = null;
		PreparedStatement pstm;

		try {
			pstm = con.prepareStatement(listaMedicamentoPorId);
			pstm.setInt(1, idmed);
			ResultSet rs = pstm.executeQuery();

			if (rs.next()) {
				medicamento = new Medicamento(rs.getInt("id"), rs.getString("nome"), rs.getDouble("preco"),
						rs.getInt("qtd"));
			}
			return medicamento;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return null;
	}

	public void selecionarMedicamento(Medicamento medicamento) throws Exception {
		String select = "select * from medicamento where idMedicamento = ?";

		Connection con = Conexao.criaConexaoComPostgree();
		PreparedStatement pstm = con.prepareStatement(select);
		try {
			pstm.setString(1, select);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				medicamento.setIdmed(rs.getInt(1));
				medicamento.setNome(rs.getString(2));
				medicamento.setPreco(rs.getDouble(3));
				medicamento.setQtd(rs.getInt(4));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			con.close();
		}
	}

}