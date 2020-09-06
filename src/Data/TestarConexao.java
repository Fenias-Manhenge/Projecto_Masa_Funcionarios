package Data;

/**
 *
 * @author Fenias
 */
import javax.swing.*;

public class TestarConexao {

    public static void main(String[] args) {
        try {
            Conexao conn = new Conexao();
            JOptionPane.showMessageDialog(null, "Conexao Ok!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
}
