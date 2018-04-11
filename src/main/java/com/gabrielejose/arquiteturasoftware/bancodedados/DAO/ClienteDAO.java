/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabrielejose.arquiteturasoftware.bancodedados.DAO;

import com.gabrielejose.arquiteturasoftware.bancodedados.AcessaBD;
import com.gabrielejose.arquiteturasoftware.entidades.Cliente;
import com.gabrielejose.arquiteturasoftware.entidades.Pais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    
    private AcessaBD bd;
    private Connection con;
    private PaisDAO paisDAO;
    
    public ClienteDAO(){
        super();
        bd = new AcessaBD();
    }
    
    public void salvaCliente(Cliente c) throws Exception {
        try{
            paisDAO = new PaisDAO();
            con = bd.getConnection();
            int idPais = -1;
            PreparedStatement st = con.prepareStatement("SELECT * FROM Pais WHERE nome_pais LIKE '" + c.getP().getNome() + "';");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                idPais = rs.getInt("id_pais");
            }
            st = con.prepareStatement("INSERT INTO Cliente (nome_cliente, idade, telefone, credito, id_pais_cliente) " +
                                                       "VALUES (?, ?, ?, ?, ?);");
            st.setString(1, c.getNome());
            st.setInt(2, c.getIdade());
            st.setString(3, c.getTelefone());
            st.setDouble(4, c.getCredito());
            st.setInt(5, idPais);
            st.execute();
            con.close();
        } catch (Exception e){
            if (e.getMessage().contains("duplicate key value violates unique constraint")){
            throw new Exception ("Nome Existente");
            } else {
                e.printStackTrace();
            }
        }
    }
    public void excluirCliente (Cliente c) throws Exception {
        try{
            con = bd.getConnection();
            PreparedStatement st = con.prepareStatement("DELETE FROM Cliente WHERE nome_cliente LIKE '" + c.getNome() + "';");
            st.execute();
            con.close();
        } catch (Exception e) {
            throw new Exception ("Nome Inexistente");
        }
    }
    public void alterarCliente (Cliente c, String nome) throws Exception {
        try{
            con = bd.getConnection();
            PreparedStatement st = con.prepareStatement("UPDATE Cliente SET nome_cliente = '"+ nome +"' WHERE nome_cliente LIKE '" + c.getNome() + "';");
            st.execute();
            con.close();
        } catch (Exception e) {
            throw new Exception ("Nome Inexistente");
        }
    }
    public Cliente buscarClienteNome (String nome) throws Exception {
        con = bd.getConnection();
        PreparedStatement st = con.prepareStatement("SELECT * FROM Cliente WHERE nome_cliente LIKE '" + nome +"';");
        ResultSet rs = st.executeQuery();
        if (rs.next()){
            Cliente c = new Cliente();
            c.setNome(rs.getString("nome_cliente"));
            try {
                int idPais = -1;
                st = con.prepareStatement("SELECT * FROM Pais WHERE nome_pais LIKE '" + c.getP().getNome() + "';");
                rs = st.executeQuery();
                while(rs.next()){
                    idPais = rs.getInt("id_pais");
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
            c.setCredito(rs.getDouble("credito"));
            c.setIdade(rs.getInt("idade"));
            c.setTelefone(rs.getString("telefone"));
            con.close();
            return c;
        } else {
            throw new Exception ("Pais não encontrado!");
        }
    }
    
    public List<Cliente> listarClientes() throws Exception{
        paisDAO = new PaisDAO();
        List<Cliente> lista = new ArrayList<>();
        con = bd.getConnection();
        PreparedStatement st = con.prepareStatement("SELECT * FROM Cliente;");
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            Cliente c = new Cliente();
            c.setNome(rs.getString("nome_cliente"));
            c.setIdade(rs.getInt("idade"));
            Pais p = new Pais();
            int idPais = rs.getInt("id_pais_cliente");
            p = paisDAO.buscarPaisId(idPais);
            c.setP(p);
            c.setTelefone(rs.getString("telefone"));
            c.setCredito(rs.getDouble("credito"));
            lista.add(c);
        }
        con.close();
        return lista;
    }
}
