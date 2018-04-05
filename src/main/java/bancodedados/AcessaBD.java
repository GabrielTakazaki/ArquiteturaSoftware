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
        Class.forName(driver);
        con = (Connection) DriverManager.getConnection(
                    "jdbc:postgres://localhost/postgres", "postgres", "utfpr");
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
