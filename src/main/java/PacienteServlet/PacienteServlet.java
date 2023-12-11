package PacienteServlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Paciente.Paciente;
import java.util.*;
@WebServlet("/PacienteServlet")
public class PacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Paciente>lista=new ArrayList<>();

    public PacienteServlet() {
        super();
    }
    
	public void init(ServletConfig config) throws ServletException {
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		var acao = request.getParameter("acao");
		if(acao.equals("listar")) {
			request.setAttribute("Pacientes",this.lista);
			request.getRequestDispatcher("WEB-INF/listar_pacientes.jsp").forward(request, response);
			return;
		}
		if(acao.equals("editar")) {
			request.setAttribute("paciente",this.getPacienteById(Integer.parseInt(request.getParameter("id"))));
			request.getRequestDispatcher("WEB-INF/atualizar.jsp").forward(request, response);
			return;
		}
		if(acao.equals("remover")) {
			this.removePaciente(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("paciente",this.lista);
			request.getRequestDispatcher("WEB-INF/listar_pacientes.jsp").forward(request, response);
			return;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var nome=request.getParameter("nome");
		var doenca=request.getParameter("doenca");
		var estado=request.getParameter("estado");
		
		if(request.getParameter("id")==null) {
			nome = request.getParameter("nome");
			var paciente= new Paciente(getId(),nome,doenca,estado);
			lista.add(paciente);
			response.sendRedirect("http://localhost:8086/DocSys/PacienteServlet?acao=listar");		
		}
		else {			
			int idPaciente = Integer.parseInt(request.getParameter("id"));
			var paciente = new Paciente(idPaciente,nome,doenca,estado);
			this.atualizar(paciente);
			response.sendRedirect("http://localhost:8086/DocSys/PacienteServlet?acao=listar");
		}
	}
	private void atualizar(Paciente paciente) {
		var indice = this.lista.indexOf(getPacienteById(paciente.getId()));
		this.lista.set(indice, paciente);		
	}

	private void removePaciente(int id) {
		this.lista.remove(getPacienteById(id));	
	}
	
	private Paciente getPacienteById(int id) {
		for (Paciente lista: lista) {
			if(lista.getId()==id) { 
				return lista;
			}
		}
		return null;
	}
	public int getId() {
		return this.lista.size()+1;
	}
}