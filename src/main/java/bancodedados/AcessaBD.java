package bancodedados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class AcessaBD {
    
    private Connection con ;
    
    public Connection getConnection(){
        try{
        con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/postgres", "postgres", "utfpr");
        } catch (SQLException e){
            e.printStackTrace();
        }
        return con;
    }
    
}
