package controller;

import entidades.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClienteController {
    
    private ArrayList<Cliente> ListCliente;
    
    public ClienteController () {
        ListCliente = new ArrayList<>();
    }
    public ArrayList<Cliente> getClientes() {
        return ListCliente;
    }
    public void setClientes(ArrayList<Cliente> clientes) {
        this.ListCliente = clientes;
    }
    public void adcClientes(Cliente c) {
        ListCliente.add(c);
    }
    public int tamanhoArray() {
        return ListCliente.size();
    }
}
