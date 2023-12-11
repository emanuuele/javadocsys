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
import model.Paciente;

/**
 * Servlet implementation class controllerPaciente
 */
@WebServlet(urlPatterns = { "/controllerPaciente", "/listar", "/criar", "/editar", "/remover"})
public class controllerPaciente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PacienteDAO pacienteDAO = new PacienteDAO();
	Paciente paciente = new Paciente(0, null, null, null);

	public controllerPaciente() {
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

		if (acao.equals("listar")) {
			listar_pacientes(request, response);
		} else if (acao.equals("criar")) {
			novoPaciente(request, response);
		} else if (acao.equals("remover")) {
			removerPaciente(request, response);
		} else if (acao.equals("editar")) {
			atualizarPaciente(request, response);
		}
	}

	private void atualizarPaciente(HttpServletRequest request, HttpServletResponse response) {
		paciente.setId(Integer.parseInt(request.getParameter("id")));
		paciente.setNome(request.getParameter("nome"));
		paciente.setDoenca(request.getParameter("doenca"));
		paciente.setEstado(request.getParameter("estado"));

		pacienteDAO.atualizar(paciente);

		response.sendRedirect("listar");
	}

	private void getpaciente(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int idPaciente = Integer.parseInt(request.getParameter("id"));

		paciente.setId(idPaciente);
		pacienteDAO.selecionarPaciente(paciente);

		request.setAttribute("nome", paciente.getNome());
		request.setAttribute("doenca", paciente.getDoenca());
		request.setAttribute("estado", paciente.getEstado());

		RequestDispatcher rd = request.getRequestDispatcher("atualizar.jsp");

		rd.forward(request, response);
	}

	private void removerPaciente(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int idPaciente = Integer.parseInt(request.getParameter("id"));
		paciente.setId(idPaciente);

		pacienteDAO.remover(paciente);

		response.sendRedirect("listar");
	}

	private void novoPaciente(HttpServletRequest request, HttpServletResponse response) {
		paciente.setNome(request.getParameter("nome"));
		paciente.setDoenca(request.getParameter("doenca"));
		paciente.setEstado(request.getParameter("estado"));

		pacienteDAO.salvar(paciente);

		response.sendRedirect("listar");
	}

	private void listar_pacientes(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Paciente> lista = pacienteDAO.listarTodos();
		request.setAttribute("listar_pacientes", lista);
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
