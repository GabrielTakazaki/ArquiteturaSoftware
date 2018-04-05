package bancodedados;

import entidades.Pais;
import java.util.ArrayList;
import java.util.List;

public class PaisController {
    private List<Pais> paises;
    /**
     * @return the paises
     */
    public List<Pais> getPaises() {
        return paises;
    }
    public int ArrayPais() {
        return paises.size();
    }
    public void setPaises(List<Pais> paises){
        this.paises = paises;
    }

    /**
     * @param paises the paises to set
     */
    public void addPaises(Pais p)throws Exception{
        if (paises == null)
            paises = new ArrayList<Pais>();
        
        boolean b = true;
        for(int i = 0; i < paises.size(); i++){
            if(p.getNome().equals(paises.get(i).getNome()))
                b = false;
        }
        if (b){
            paises.add(p);
        } else {
            throw new Exception("Pais ja existente");
        }
    }
    
}
