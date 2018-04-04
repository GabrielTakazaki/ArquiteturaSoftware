/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import bancodedados.ClienteController;
import entidades.Cliente;
import java.util.ArrayList;

public class ClienteDAO {
    private ClienteController clientes;
    
    public ClienteDAO(ClienteController clientes) {
        this.clientes = clientes;
    }
    
    public void salvaCliente (Cliente c) throws Exception {
        boolean verif = true;
        if (clientes.getClientes() == null) {
            clientes.setClientes(new ArrayList<Cliente>());
        }
        for (int i = 0; i < clientes.getClientes().size(); i++) {
            if (clientes.getClientes().get(i).getNome().equals(c.getNome())) {
                verif = false;
            }
        }
        if (verif) {
            clientes.getClientes().add(c);
        }
        else {
            throw new Exception ("Nome Existente");
        }
    }
    public void excluirCliente (Cliente c) throws Exception {
        boolean verif = true;
        if (clientes.getClientes() == null) {
            clientes.setClientes(new ArrayList<Cliente>());
        }
        for (int i = 0; i < clientes.getClientes().size(); i++) {
            if (clientes.getClientes().get(i).getNome().equals(c.getNome())) {
                verif = true;
            }
        }
        if (verif) {
            clientes.getClientes().remove(c);
        }
        else {
            throw new Exception ("Nome Inexistente");
        }
    }
    public void alterarCliente (Cliente c) throws Exception {
        boolean verif = true;
        int posicao = -1;
        if (clientes.getClientes() == null) {
            clientes.setClientes(new ArrayList<Cliente>());
        }
        for (int i = 0; i < clientes.getClientes().size(); i++) {
            if (clientes.getClientes().get(i).getNome().equals(c.getNome())) {
                verif = true;
                posicao = i;
            }
        }
        if (verif) {
            clientes.getClientes().set(posicao,c);
        }
        else {
            throw new Exception ("Nome Inalterado");
        }
    }
    public Cliente buscarCliente (String nome) throws Exception {
        boolean verif = true;
        if (clientes.getClientes() == null) {
            clientes.setClientes(new ArrayList<Cliente>());
        }
        else {
            throw new Exception ("Clientes vazio");
        }
        
        for (Cliente cliente : clientes.getClientes()) {
            if (cliente.getNome().equals(nome)) {
                verif = true;
            }
        }
        if (verif) {
            return sala
        }
        else {
            throw new Exception ("Nome Inalterado");
        }
    }
}
