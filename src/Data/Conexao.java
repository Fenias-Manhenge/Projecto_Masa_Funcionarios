
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
        String url = "jdbc:jtds:sqlserver://FENIAS-MANHENGE\\XIMIX:1433/EMPLOYEE";
        con = DriverManager.getConnection(url, "employee", "13579");
    }
    
    public Connection getConnection(){
        return  con;
    }
}
