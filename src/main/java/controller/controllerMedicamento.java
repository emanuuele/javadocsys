package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MedicamentoDAO;
import model.Medicamento;

/**
 * Servlet implementation class controllerReceita
 */
@WebServlet(urlPatterns = { "/controllerPaciente", "/listar", "/criar", "/editar", "/remover"})
public class controllerMedicamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MedicamentoDAO medicamentoDAO = new MedicamentoDAO(null);
	Medicamento medicamento = new Medicamento(0, null, 0, 0);

	public controllerMedicamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		var acao = request.getServletPath();
		System.out.println(acao);

		if (acao.equals("listar-medicamentos")) {
			listar_medicamentos(request, response);
		} else if (acao.equals("criar-medicamento")) {
			novoMedicamento(request, response);
		} else if (acao.equals("remover-medicamento")) {
			removerMedicamento(request, response);
		} else if (acao.equals("editar-medicamento")) {
			atualizarMedicamento(request, response);
		}
	}

	private void atualizarMedicamento(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		medicamento.setIdmed(Integer.parseInt(request.getParameter("id")));
		medicamento.setNome(request.getParameter("nome"));
		medicamento.setPreco(Integer.parseInt(request.getParameter("preco")));
		medicamento.setQtd(Integer.parseInt(request.getParameter("qtd")));

		medicamentoDAO.atualizar(medicamento);

		response.sendRedirect("listar-medicamentos");
	}

	private void getmedicamento(HttpServletRequest request, HttpServletResponse response) {
		int idMedicamento = Integer.parseInt(request.getParameter("id"));

		medicamento.setIdmed(idMedicamento);
		medicamentoDAO.selecionarMedicamento(medicamento);

		request.setAttribute("nome", medicamento.getNome());
		request.setAttribute("medicamento", medicamento.getPreco());
		request.setAttribute("estado", medicamento.getQtd());

		RequestDispatcher rd = request.getRequestDispatcher("atualizar-medicamento.jsp");

		rd.forward(request, response);
	}

	private void removerMedicamento(HttpServletRequest request, HttpServletResponse response) {

	}

	private void novoMedicamento(HttpServletRequest request, HttpServletResponse response) {

		medicamento.setNome(request.getParameter("nome"));
		medicamento.setPreco(Integer.toString(request.getParameter("preco")));
		medicamento.setQtd(Integer.toString(request.getParameter("qtd")));

		medicamentoDAO.salvar(medicamento);

		response.sendRedirect("criar");
	}

	private void listar_medicamentos(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Medicamento> listamedicamentos = medicamentoDAO.listarTodos();
		request.setAttribute("listar_medicamentos", listamedicamentos);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/listar_medicamentos.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
