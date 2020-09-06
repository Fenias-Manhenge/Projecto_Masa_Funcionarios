package Data;

/**
 *
 * @author Fenias
 */
import Model.Funcionario;
import View.Cadastro;
import java.sql.*;

public class funcionarioData {
    Conexao con;
    
    public boolean include(Funcionario obj) throws Exception{
        con = new Conexao();
        
        String sql = "insert into register values (?,?,?,?)";
        PreparedStatement ps = con.getConnection().prepareStatement(sql);
        
        ps.setInt(1, obj.getCodigo());
        ps.setString(2, obj.nome);
        ps.setString(3, obj.sexo);
        ps.setString(4, obj.geteCivil());
        ps.execute();
        
        if (ps.executeUpdate() > 0) {
            return true;
        }else{
            return false;
        }
        
    }
}
