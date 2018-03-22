package controller;

import entidades.*;
import java.util.ArrayList;

public class ClienteController {
    
    private ArrayList<Cliente> clientes = new ArrayList<>();

    /**
     * @return the clientes
     */
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(Cliente clientes) {
        this.clientes.add(clientes);
    }

}
