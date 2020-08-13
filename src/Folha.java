/**
 *
 * @author Fenias
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.table.*;

public class Folha extends JFrame{
    
    public Vector<Funcionario> x = new Vector();
    
    public JPanel painel = new JPanel ();
    
    public JLabel lblTotal = new JLabel ("TOTAL");
    public JLabel lblInss = new JLabel ("INSS(3%)");
    public JLabel lblMes = new JLabel ("MES");
    
    public JTextField txtTotal = new JTextField ("");
    public JTextField txtInss = new JTextField ("");

    String mes [] = {"JANEIRO", "FEVEREIRO", "MARCO", "ABRIL", "MAIO",  "JUNHO", "JULHO",
                            "AGOSTO", "SETEMBRO", "OUTUBRO", "NOVEMBRO", "DEZEMBRO"
                    };
    public JComboBox cboMes= new JComboBox(mes);
    
    public JButton butVisualiza = new JButton ("VISUALIZAR");
    public JButton butFich_Txt = new JButton ("FICH.TEXT");
    public JButton butMenu = new JButton ("MENU");
    
    String colunas [] = {"CODIGO", "NOME", "SALARIO"};
    Object dados[][];
    
    DefaultTableModel modelo = new DefaultTableModel(dados,colunas);
    
    JTable tabela = new JTable(modelo);
    
    JScrollPane scrol = new JScrollPane(tabela);
    
    public Container contetor = getContentPane();
    
    public Folha(){
        
        super ("FOLHA DE SALARIOS-MES");
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        painel.setLayout(null);
        
         painel.setBackground(Color.green);
         cboMes.setBackground(Color.decode("#ff9100"));
         butVisualiza.setBackground(Color.decode("#216d3a"));
         butMenu.setBackground(Color.decode("#12edc7"));
         butFich_Txt.setBackground(Color.decode("#768289"));
         
         painel.add(lblTotal);  painel.add(txtTotal);
         painel.add(lblInss);  painel.add(txtInss);
         painel.add(lblMes);  painel.add(cboMes);
         painel.add(butVisualiza);  painel.add(butFich_Txt);   
         painel.add(scrol);  contetor.add(painel);
         painel.add(butMenu);
         
         lblTotal.setBounds(200, 260, 60, 30);txtTotal.setBounds(280, 260, 230, 30);
         lblInss.setBounds(200, 300, 60, 30);txtInss.setBounds(280, 300, 230, 30);
         lblMes.setBounds(200, 340, 40, 30);cboMes.setBounds(250, 340, 100, 30);
         
         butVisualiza.setBounds(360, 340, 150, 30);butFich_Txt.setBounds(360, 380, 150, 30);
         butMenu.setBounds(40, 380, 150, 30);
         
         scrol.setBounds(40, 40, 470, 202);
         
         this.setVisible(true);
         this.setSize(600, 500);
         
         cboMes.setToolTipText("SELECIONE O MES");
         butVisualiza.setToolTipText("CLIQUE AQUI PARA VISUALIZAR OS DADOS");
         butFich_Txt.setToolTipText("CLIQUE PARA GRAVAR OS DADOS");
         butMenu.setToolTipText("CLIQUE AQUI PARA ENTRAR NO MENU");
         
         eventos();
         leituraFicheiro();
         
    }
    
    public void visualiza(){
        Funcionario g;
        
        String dados1 [] = new String [3];
        
            while(modelo.getRowCount()>0){
                modelo.removeRow(0);
            }
            
            for(int i = 0;i<x.size(); i++){
                g = x.get(i);
                
                    int Mes =  cboMes.getSelectedIndex();
                    
                    dados1[0] = g.getCodigo() + "";
                    dados1[1] = g.nome;
                    dados1[2] = g.getSalario()[Mes] + "";

                    if(g.getSalario()[Mes] > 0){
                        modelo.addRow(dados1);
                    }
                    
                    this.setTitle("FOLHA DE SALARIO - " + cboMes.getSelectedItem());
                    
                    salario();
            }    
    }
    
    
    public void salario(){
        Funcionario k;
        
        double a = 0.0, inss = 0;
        
        for(int i = 0; i<x.size(); i++){
            k = x.get(i);
            
            int Mes =  cboMes.getSelectedIndex();
            
            a+=k.getSalario()[Mes];
            txtTotal.setText(a + "");
            
            inss = a * 0.03;
            txtInss.setText(inss + "");
        }
        
    }
    

    
    public void Ficheiro(){
        try{
            File f=new File("FOLHA.TXT");
            FileWriter fw=new FileWriter(f);
            BufferedWriter bw=new BufferedWriter(fw);
            
            for (int i = 0; i < modelo.getRowCount(); i++) {
                bw.write((String) modelo.getValueAt(i, 0)); bw.newLine();
                bw.write((String) modelo.getValueAt(i, 1)); bw.newLine();
                bw.write((String) modelo.getValueAt(i, 2)); bw.newLine();
            }
            
            JOptionPane.showMessageDialog(this, "DADOS GRAVADOS COM SUCESSO", "TABELA DE CONFIRMACAO", 1);
            
        }catch(IOException e){JOptionPane.showMessageDialog(this, "ERROR");}     
    }
    
    public void leituraFicheiro(){
            try{
                File f = new File("Funcionario.Dat");
                FileInputStream fis = new FileInputStream (f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                x=(Vector)ois.readObject();
                ois.close();
            }catch(Exception e){//System.err.println("ERROR"+ e.getMessage());
                JOptionPane.showMessageDialog(this, "Error");}
    }
    
    public void eventos(){
            
        butVisualiza.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    visualiza();
                }                
            }
        );
            
        butFich_Txt.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                   Ficheiro();
                }                
            }
        );
        
        butMenu.addActionListener(((ae) -> {
            new Menu_Do_Sistema(); dispose();
        }));
    }  
    
    public static void main(String[] args) {
        new Folha();
    }
 
}
