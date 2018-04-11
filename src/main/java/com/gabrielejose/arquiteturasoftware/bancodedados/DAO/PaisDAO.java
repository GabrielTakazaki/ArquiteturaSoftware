package com.gabrielejose.arquiteturasoftware.bancodedados.DAO;

import com.gabrielejose.arquiteturasoftware.bancodedados.AcessaBD;
import com.gabrielejose.arquiteturasoftware.entidades.Pais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.util.PSQLException;

/**
 *
 * @author Aluno
 */
public class PaisDAO {
    private AcessaBD bd;
    private Connection con;
    
    public PaisDAO() {
        super();
        bd = new AcessaBD();
    }
    
    public void salvaPais(Pais p) throws Exception {
        try{
            con = bd.getConnection();
            PreparedStatement st = con.prepareStatement("INSERT INTO Pais (nome_pais, sigla, telefone_pais) " +
                                                       "VALUES (?, ?, ?);");
            st.setString(1, p.getNome());
            st.setString(2, p.getSigla());
            st.setInt(3, p.getDigitosTel());
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
    public void excluirPais (Pais p) throws Exception {
        try{
            con = bd.getConnection();
            PreparedStatement st = con.prepareStatement("DELETE FROM Pais WHERE nome_pais LIKE '" + p.getNome() + "';");
            st.execute();
            con.close();
        } catch (Exception e) {
            throw new Exception ("Nome Inexistente");
        }
    }
    public void alterarPais (Pais p, String nome) throws Exception {
        try{
            con = bd.getConnection();
            PreparedStatement st = con.prepareStatement("UPDATE Pais SET nome_pais = '"+ nome +"' WHERE nome_pais LIKE '" + p.getNome() + "';");
            st.execute();
            con.close();
        } catch (Exception e) {
            throw new Exception ("Nome Inexistente");
        }
    }
    public Pais buscarPaisNome(String nome) throws Exception {
        con = bd.getConnection();
        PreparedStatement st = con.prepareStatement("SELECT * FROM Pais WHERE nome_pais LIKE '" + nome +"';");
        ResultSet rs = st.executeQuery();
        if (rs.next()){
            Pais p = new Pais();
            p.setNome(rs.getString("nome_pais"));
            p.setSigla(rs.getString("sigla"));
            p.setDigitosTel(rs.getInt("telefone_pais"));
            con.close();
            return p;
        } else {
            throw new Exception ("Pais não encontrado!");
        }
    }
    
    public Pais buscarPaisId(int id) throws Exception {
        con = bd.getConnection();
        PreparedStatement st = con.prepareStatement("SELECT * FROM Pais WHERE id_pais = " + id +";");
        ResultSet rs = st.executeQuery();
        if (rs.next()){
            Pais p = new Pais();
            p.setNome(rs.getString("nome_pais"));
            p.setSigla(rs.getString("sigla"));
            p.setDigitosTel(rs.getInt("telefone_pais"));
            con.close();
            return p;
        } else {
            throw new Exception ("Pais não encontrado!");
        }
    }
    
    public List<Pais> listarPaises() throws Exception{
        List<Pais> lista = new ArrayList<>();
        con = bd.getConnection();
        PreparedStatement st = con.prepareStatement("SELECT * FROM Pais;");
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            Pais p = new Pais();
            p.setNome(rs.getString("nome_pais"));
            p.setSigla(rs.getString("sigla"));
            p.setDigitosTel(rs.getInt("telefone_pais"));
            lista.add(p);
        }
        con.close();
        return lista;
    }
}
