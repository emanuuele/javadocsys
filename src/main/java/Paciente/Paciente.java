package Paciente;
    public class Paciente {
        private int id;
        private String nome;
        private String doenca;
        private String estado;
    
    public Paciente(int id,String nome, String doenca, String estado){
        this.id = id;
        this.nome = nome;
        this.doenca = doenca;
        this.estado = estado;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
	this.nome = nome;
    }
    public String getDoenca() {
        return doenca;
    }
    public void setDoenca(String doenca) {
	this.doenca = doenca;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
	this.estado = estado;
    }
    public int getId() {
        return id;
    }
    public void setId(String id) {
	this.estado = id;
    }
}
