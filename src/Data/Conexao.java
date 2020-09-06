package Data;

/**
 *
 * @author Fenias
 */
import java.sql.*;

public class Conexao {
    private Connection con;

    public Conexao() throws Exception{
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        String url1 = "jdbc:jtds:sqlserver://FENIAS-MANHENGE:1433/EMPLOYEE";
        con = DriverManager.getConnection(url1, "employee", "13579");
    }
    
    public Connection getConnection(){
        return  con;
    }
}
