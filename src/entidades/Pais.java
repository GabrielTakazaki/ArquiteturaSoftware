package entidades;

public class Pais {
    
    private String nome;
    private String sigla;
    private int digitosTel;
    
    public Pais(){
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public int getDigitosTel() {
        return digitosTel;
    }

    public void setDigitosTel(int digitosTel) {
        this.digitosTel = digitosTel;
    }
    
}
