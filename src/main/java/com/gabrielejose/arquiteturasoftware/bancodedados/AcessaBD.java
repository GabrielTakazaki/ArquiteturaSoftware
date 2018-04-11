package com.gabrielejose.arquiteturasoftware.bancodedados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AcessaBD {
    
    private Connection con ;
    
    public Connection getConnection(){
        try{
        String driver = "org.postgresql.Driver";
        String user = "postgres";
        String senha = "utfpr";
        String url = "jdbc:postgresql://localhost:5432/postgres";
        Class.forName(driver);
        con = DriverManager.getConnection(
                    url, user, senha);
        } catch (SQLException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return con;
    }
    
    public void criaTabelas(){
        try{
            con = getConnection();
            PreparedStatement st = con.prepareStatement(   
                                    "CREATE TABLE IF NOT EXISTS Pais (" +
                                    "    id_pais SERIAL PRIMARY KEY," +
                                    "    nome_pais VARCHAR(50) UNIQUE," +
                                    "    sigla VARCHAR(3)," +
                                    "    telefone_pais int" +
                                    ");" +

                                    "CREATE TABLE IF NOT EXISTS Cliente(\n" +
                                    "    id_cliente serial,\n" +
                                    "    nome_cliente VARCHAR (50) UNIQUE,\n" +
                                    "    idade int,\n" +
                                    "    telefone VARCHAR (50),\n" +
                                    "    credito REAL,\n" +
                                    "    id_pais_cliente int,\n" +
                                    "    CONSTRAINT pk_cliente PRIMARY KEY (id_cliente),\n" +
                                    "    CONSTRAINT fk_pais FOREIGN KEY (id_pais_cliente)\n" +
                                    "    REFERENCES Pais (id_pais) \n" +
                                    ");");
            st.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
}
