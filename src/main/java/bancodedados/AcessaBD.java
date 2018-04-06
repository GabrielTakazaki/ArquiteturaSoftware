package bancodedados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AcessaBD {
    
    private Connection con ;
    
    public Connection getConnection(){
        
        try{
        String driver = "org.postgresql.Driver";
        String user = "postgres";
        String senha = "utfpr";
        String url = "jdbc:postgres://localhost/postgres";
        Class.forName(driver);
        con = DriverManager.getConnection(
                    url, user, senha);
            PreparedStatement ps = con.prepareStatement("INSERT INTO Pais VALUES (Brasil, BRA, 8);");
            ps.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return con;
    }
    
}
