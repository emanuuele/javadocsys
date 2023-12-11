package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PacienteDAO;
import DAO.ReceitaDAO;

import model.Receita;

/**
 * Servlet implementation class controllerReceita
 */
@WebServlet(urlPatterns = { "/controllerPaciente", "/listar", "/criar", "/editar", "/remover"})
public class controllerReceita extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReceitaDAO receitaDAO = new ReceitaDAO(null);
	Receita receita = new Receita(0, null, null, null);

	public controllerReceita() {
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

		if (acao.equals("listar-receitas")) {
			listar_receitas(request, response);
		} else if (acao.equals("criar-receita")) {
			novaReceita(request, response);
		} else if (acao.equals("remover-receita")) {
			removerReceita(request, response);
		} else if (acao.equals("editar-receita")) {
			atualizarReceita(request, response);
		}
	}

	private void atualizarReceita(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		receita.setIdrec(Integer.parseInt(request.getParameter("id")));
		receita.setNome(request.getParameter("nome"));
		receita.setMedicamento(request.getParameter("doenca"));
		receita.setDescricao(request.getParameter("estado"));

		receitaDAO.atualizar(receita);

		response.sendRedirect("listar-receitas");
	}

	private void getreceita(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int idReceita = Integer.parseInt(request.getParameter("id"));

		receita.setIdrec(idReceita);
		receitaDAO.selecionarReceita(receita);

		request.setAttribute("nome", receita.getNome());
		request.setAttribute("medicamento", receita.getMedicamento());
		request.setAttribute("estado", receita.getDescricao());

		RequestDispatcher rd = request.getRequestDispatcher("atualizar-receita.jsp");

		rd.forward(request, response);
	}

	private void removerReceita(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void novaReceita(HttpServletRequest request, HttpServletResponse response) {
		receita.setNome(request.getParameter("nome"));
		receita.setMedicamento(request.getParameter("medicamento"));
		receita.setDescricao(request.getParameter("descricao"));

		receitaDAO.salvar(receita);

		response.sendRedirect("main");
	}

	private void listar_receitas(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Receita> listareceitas = receitaDAO.listarTodos();
		request.setAttribute("listar_pacientes", listareceitas);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/listar_pacientes.jsp");
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
