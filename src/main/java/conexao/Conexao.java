package conexao;

//Importar os recursos para a conex�o e a mensagem de confirma��o de conex�o
import java.sql.*;

public class Conexao {
	/*Revis�o de B.D
	 * 
	 * acesso ao bd pelo terminal -> 
	 * 
	 * mysql -uroot -p
	 * 123456 -> senha do b.d
	 * 
	 * criando o banco de dados
	 * 
	 * create database agenda;
	 * use agenda;
	 * create table contatos (id int primary key auto_increment, nome varchar (20) not null, idade int not null, dataCadastro data not null);
	 *
	 *desc contatos;
	 * 
	 * use agenda;
	 * select*from contatos;
	 * 
	 * truncante table contatos; - zera os auto incrementes (zera toda a tabela)
	 * 
	 *  drop database agenda; -exclui o banco de dados
	 * */
	
	//Nome do usuario do MySQL 
	private static final String USERNAME="root";
	
	//Senha do MySQL
	private static final String PASSWORD="emanuele";
	
	/*Dados dde caminho:
	 * Porta = jdbc:mysql://localhost:3306/
	 * Nome da base de dados = hipertrofia
	 * */
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/docsys?rootTimezone=true&serverTimezone=UTC";
	
	public static Connection criaConexaoComPostgree() throws Exception{
		//Class.forName("org.postgresql.Driver"); //Faz com que a classe seja carregada pela JVM
		Connection conexao = DriverManager.getConnection(DATABASE_URL,USERNAME, PASSWORD); //Cria a conex�o com o banco de dados
		return conexao;
	}
	 public static void main (String [] args) throws Exception {
		 Connection rede=criaConexaoComPostgree(); //Recupera uma conex�o com o banco de dados
		 //Testa se a conex�o � nula
		 if (rede!=null) {
			 System.out.println("Conex�o bem sucedida!\nSobre:"+rede);
			 rede.close(); //Apos o teste, encerra a conex�o
		 }
	 }
	
	
	   /**
	   * Cria uma conex�o com o banco de dados PSQL utilizando o nome de usu�rio e senha fornecidos
	   * @param username
	   * @param senha
	   * @return uma conex�o com o banco de dados
	   * @throws Exception
	   */
}