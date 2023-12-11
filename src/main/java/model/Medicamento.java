package model;


public class Medicamento {
    private int idmed;
    private String nome;
    private double preco;
    private int qtd;
//Atualizar    
public Medicamento(int idmed,String nome, double preco, int qtd){
    this.idmed = idmed;
    this.nome = nome;
    this.preco = preco;
    this.qtd = qtd;
}

//Cadastrar
public Medicamento(String nome, double preco, int qtd){
    this.nome = nome;
    this.preco = preco;
    this.qtd = qtd;
}

public String getNome() {
    return nome;
}
public void setNome(String nome) {
this.nome = nome;
}
public double getPreco() {
    return preco;
}
public void setPreco(double preco) {
this.preco = preco;
}
public int getQtd() {
    return qtd;
}
public void setQtd(int qtd) {
this.qtd = qtd;
}
public int getIdmed() {
    return idmed;
}
public void setIdmed(int idmed) {
this.idmed = idmed;
}
}
