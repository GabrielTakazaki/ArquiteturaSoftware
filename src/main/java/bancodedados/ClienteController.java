package bancodedados;

import entidades.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    
    private List<Cliente> clientes;

    public List<Cliente> getClientes() {
        return clientes;
    }
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    public void adcClientes(Cliente c) throws Exception {
        boolean verif = true;
        if (clientes == null) {
            clientes = new ArrayList<Cliente>();
        }
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getNome().equals(c.getNome())) {
                verif = false;
            }
        }
        if (verif) {
            clientes.add(c);
        }
        else {
            throw new Exception ("Nome Existente");
        }
    }
    
    public int tamanhoArray() {
        return clientes.size();
    }
}
