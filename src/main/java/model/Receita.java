package model;
public class Receita {
    private int idrec;
    private String nome;
    private String medicamento;
    private String descricao;

public Receita(int idrec,String nome, String medicamento, String descricao){
    this.idrec = idrec;
    this.nome = nome;
    this.medicamento = medicamento;
    this.descricao = descricao;
}

public Receita(String nome, String medicamento, String descricao){
    this.nome = nome;
    this.medicamento = medicamento;
    this.descricao = descricao;
}

public String getNome() {
    return nome;
}
public void setNome(String nome) {
this.nome = nome;
}
public String getMedicamento() {
    return medicamento;
}
public void setMedicamento(String medicamento) {
this.medicamento = medicamento;
}
public String getDescricao() {
    return descricao;
}
public void setDescricao(String descricao) {
this.descricao = descricao;
}
public int getIdrec() {
    return idrec;
}
public void setIdrec(int idrec) {
this.idrec = idrec;
}
}
