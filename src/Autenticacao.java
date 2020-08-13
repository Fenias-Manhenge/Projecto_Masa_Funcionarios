
/**
 *
 * @author Fenias
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Autenticacao extends JFrame{
    
    public JPanel painel = new JPanel();
        
        public JLabel lblNome = new JLabel ("NOME:");
        public JLabel lblSenha = new JLabel ("SENHA:");
        
        public JTextField txtNome = new JTextField("");
        public JTextField txtSenha = new JTextField("");
        
        public JButton butOk = new JButton("OK");
        public JButton butCANCEL = new JButton("CANCEL");
        
        public Container contentor = getContentPane();
        
        public Autenticacao(){ //formacao de um painel de interacao
        
            painel.setLayout(null); //criacao de um painel vazio
            
            butOk.setBackground(Color.decode("#31ce85"));
            butCANCEL.setBackground(Color.decode("#E06868"));
            painel.setBackground(Color.decode("#c84e40"));
            
            painel.add(lblNome); painel.add(lblSenha);
            painel.add(txtNome); painel.add(txtSenha);
            painel.add(butOk) ; painel.add(butCANCEL);
            contentor.add(painel);
            
            lblNome.setBounds(35, 30, 100, 30); lblSenha.setBounds(35, 70, 100, 30);
            txtNome.setBounds(95, 30, 170, 27); txtSenha.setBounds(95, 70, 170, 25);
            butOk.setBounds(35, 110, 70, 30); butCANCEL.setBounds(140, 110, 125, 30);
            
            txtNome.setToolTipText("INTRODUZA O SEU NOME");
            txtSenha.setToolTipText("INTRODUZA UMA SENHA VALIDA");

            this.setLocation(400, 300);
            this.setSize(310,200);
            this.setVisible(true);
            this.setTitle("AUTENTICACAO");
            
            eventos(); 
            
        }    
    
        
    public void ok(){
        try{
            File f=new File("C:\\Users\\Fenias\\Documents\\NetBeansProjects\\Projecto_Masa_Funcionarios\\NET.TXT");
            FileReader fr=new FileReader(f);
            BufferedReader br=new BufferedReader(fr);
            
            String nome="", senha="";
            nome=br.readLine();
            while(nome!=null){
                senha=br.readLine();
                if(nome.equalsIgnoreCase(txtNome.getText()) && senha.equalsIgnoreCase(txtSenha.getText())){
                    new Menu_Do_Sistema(); 
                    dispose(); break;
                }else{
                    JOptionPane.showMessageDialog(this, "AUTENTICACAO INVALIDA", "VALIDACAO", 0);
                    txtNome.setText(""); txtSenha.setText("");
                }
                nome=br.readLine();
            }
            br.close(); 
        }catch(IOException e){JOptionPane.showMessageDialog(this, "ERROR");}  
    }
   
    public void eventos(){
        butOk.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ok();
            }
        }
        );
        butCANCEL.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    System.exit(0);
                }
            }    
        );
    }
    
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Autenticacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Autenticacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Autenticacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Autenticacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        new Autenticacao();
    }
}
