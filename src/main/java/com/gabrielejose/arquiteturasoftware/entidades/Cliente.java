package com.gabrielejose.arquiteturasoftware.entidades;

public class Cliente {
    
    private String nome;
    private String telefone;
    private double credito;
    private int idade;
    private Pais p;

    public Pais getP() {
        return p;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito){
        if (this.getIdade() < 18){
            this.credito = 100;
        } else if (this.getIdade() >= 18 && this.getIdade() <= 35){
            this.credito = 300;
        } else {
            this.credito = 500;
        }
        if(this.p.getNome().equalsIgnoreCase("brasil")){
            this.credito += 100;
        }
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setP(Pais p) throws Exception {
        if (p == null){
            throw new Exception("Um país deve ser selecionado!");
        } else {
            this.p = p;
        }
    }
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) throws Exception {
        if (nome.length() < 5){
            throw new Exception("Nome não pode ser menor que 5 caracteres");
        } else {
            this.nome = nome;
        }
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) throws Exception {
        if (telefone.length() != p.getDigitosTel()){
            throw new Exception("Numero de telefone inválido");
        } else {
            this.telefone = telefone;
        }
    }

    
    public String creditoString(){
        return "" + credito;
    }
    
    public String idadeString(){
        return "" + idade;
    }
}
