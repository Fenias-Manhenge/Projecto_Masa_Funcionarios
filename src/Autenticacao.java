
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
            
            lblNome.setBounds(40, 40, 100, 30); lblSenha.setBounds(40, 80, 100, 30);
            txtNome.setBounds(120, 40, 170, 30); txtSenha.setBounds(120, 80, 170, 30);
            butOk.setBounds(40, 140, 70, 30); butCANCEL.setBounds(140, 140, 150, 30);
            
            txtNome.setToolTipText("INTRODUZA O SEU NOME");
            txtSenha.setToolTipText("INTRODUZA UMA SENHA VALIDA");

            this.setLocation(400, 300);
            this.setSize(350,250);
            this.setVisible(true);
            this.setTitle("AUTENTICACAO");
            
            eventos(); 
            
        }    
    
        
    public void ok(){
        try{
            File f=new File("NET.TXT");
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
        new Autenticacao();
    }
}
