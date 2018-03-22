package controller;

import entidades.Pais;
import java.util.ArrayList;

public class PaisController {
    private ArrayList<Pais> paises = new ArrayList<Pais>();

    /**
     * @return the paises
     */
    public ArrayList<Pais> getPaises() {
        return paises;
    }

    /**
     * @param paises the paises to set
     */
    public void setPaises(Pais pais) {
        this.paises.add(pais);
    }
    
}
