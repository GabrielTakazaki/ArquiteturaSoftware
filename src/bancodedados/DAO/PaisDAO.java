/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancodedados.DAO;

import bancodedados.PaisController;
import bancodedados.PaisController;
import entidades.Pais;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class PaisDAO {
    private PaisController Paises;
    
    public PaisDAO(PaisController Paises) {
        this.Paises = Paises;
    }
    
    public void salvaPais (Pais p) throws Exception {
        boolean verif = true;
        if (Paises.getPaises() == null) {
            Paises.setPaises(new ArrayList<Pais>());
        }
        for (int i = 0; i < Paises.getPaises().size(); i++) {
            if (Paises.getPaises().get(i).getNome().equals(p.getNome())) {
                verif = false;
            }
        }
        if (verif) {
            Paises.getPaises().add(p);
        }
        else {
            throw new Exception ("Nome Existente");
        }
    }
    public void excluirPais (Pais p) throws Exception {
        boolean verif = true;
        if (Paises.getPaises() == null) {
            Paises.setPaises(new ArrayList<Pais>());
        }
        for (int i = 0; i < Paises.getPaises().size(); i++) {
            if (Paises.getPaises().get(i).getNome().equals(p.getNome())) {
                verif = true;
            }
        }
        if (verif) {
            Paises.getPaises().remove(p);
        }
        else {
            throw new Exception ("Nome Inexistente");
        }
    }
    public void alterarPais (Pais p) throws Exception {
        boolean verif = true;
        int posicao = -1;
        if (Paises.getPaises() == null) {
            Paises.setPaises(new ArrayList<Pais>());
        }
        for (int i = 0; i < Paises.getPaises().size(); i++) {
            if (Paises.getPaises().get(i).getNome().equals(p.getNome())) {
                verif = true;
                posicao = i;
            }
        }
        if (verif) {
            Paises.getPaises().set(posicao,p);
        }
        else {
            throw new Exception ("Nome Inalterado");
        }
    }
    public Pais buscarPais (String nome) throws Exception {
        Pais c = new Pais();
        boolean verif = true;
        if (Paises.getPaises() == null) {
            Paises.setPaises(new ArrayList<Pais>());
        }
        else {
            throw new Exception ("Paises vazio");
        }
        
        for (Pais Pais : Paises.getPaises()) {
            if (Pais.getNome().equals(nome)) {
                verif = true;
                c = Pais;
            }
        }
        if (verif) {
            return c;
        }
        else {
            throw new Exception ("Nome Inalterado");
        }
    }
    
    public List<Pais> listarPaises(){
        return Paises.getPaises();
    }
}
