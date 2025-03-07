package View;

/**
 *
 * @author Fenias
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu_Do_Sistema extends JFrame{
        
    public  JPanel painel = new JPanel();
    
    ImageIcon fundo = new ImageIcon (getClass().getResource("transferir.png"));
    public JLabel lblImagem = new JLabel(fundo);
    
    public JMenuBar barra = new JMenuBar();
    public JMenu cadastro = new JMenu("CADASTRO");
    public JMenu processar = new JMenu("PROC.SALARIO");        
    public JMenu exit = new JMenu("EXIT");
    public JMenuItem iCadastro = new JMenuItem("CADASTRO");
    public JMenuItem iProcessar = new JMenuItem("PROCESSAR");
    public JMenuItem iVisualizar = new JMenuItem("VISUALIZAR");
    public JMenuItem iExit = new JMenuItem("EXIT");
    
    public Container contentor = getContentPane();
    
    public Menu_Do_Sistema(){
        
        super("MENU DO SISTEMA");
        
        painel.setLayout(null);
        painel.setBackground(Color.BLACK);
      
        barra.add(cadastro);
        barra.add(processar);
        barra.add(exit);
        cadastro.add(iCadastro);
        processar.add(iProcessar);
        processar.add(iVisualizar);
        exit.add(iExit);
         painel.add(lblImagem);
        contentor.add(painel);
       
        this.setSize(400, 400);
        this.setJMenuBar(barra);
        this.setVisible(true);
        
        eventos();
    }
    
    public void eventos(){
        iCadastro.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        try {
                            new Cadastro();
                            dispose();
                        } catch (Exception ex) {
                            Logger.getLogger(Menu_Do_Sistema.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }       
                } 
        );
        
        iExit.addActionListener(
                new ActionListener(){  
                    public void actionPerformed(ActionEvent e){ 
                        dispose();    
                    } 
                }                                                                                                                                                     
        );
        
        iProcessar.addActionListener((ActionEvent e) -> {
            new Processamento();
            dispose();
        }); 
        
        iVisualizar.addActionListener( 
                new ActionListener(){ 
                    public void actionPerformed(ActionEvent e){   
                        new Folha();
                        dispose();
                    }     
                }
        ); 
    }
    
    public static void main(String[] args) {
        new Menu_Do_Sistema();
    }

}
