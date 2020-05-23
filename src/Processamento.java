/**
 *
 * @author Fenias
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Processamento extends JFrame{
    
    public Vector <Funcionario> x = new Vector();
    
    public JPanel painel = new JPanel();
    public JPanel painelPesquisa = new JPanel();
    public JPanel painelResultado = new JPanel();
    public JPanel painelSalario = new JPanel();
    public JPanel painelOperacao = new JPanel();
    
    public JLabel lblCodigo = new JLabel ("CODIGO:");
    public JLabel lblNome = new JLabel ("NOME:");
    public JLabel lblSexo = new JLabel ("SEXO:");
    public JLabel lblCivil = new JLabel ("E.Civil:");
    public JLabel lblMes = new JLabel ("MES:");
    public JLabel lblValor = new JLabel ("VALOR:");
    
    String lista [] = {"","MASCULINO","FEMENINO"};
    public JComboBox cboSexo= new JComboBox(lista);
    
    String mes [] = {"JANEIRO", "FEVEIRO", "MARCO", "ABRIL", "MAIO",  "JUNHO", "JULHO",
                            "AGOSTO", "SETEMBRO", "OUTUBRO", "NOVEMBRO", "DEZEMBRO"
                    };
    public JComboBox cboMes= new JComboBox(mes);
    
    public JTextField txtCodigo = new JTextField("");
    public JTextField txtNome = new JTextField("");
    public JTextField txtCivil = new JTextField("");
    public JTextField txtValor = new JTextField("");
    
    public JRadioButton radAtribui = new JRadioButton("ATRIBUIR");
    public JRadioButton radActualiza = new JRadioButton("ACTUALIZAR");
    public JRadioButton radAnula = new JRadioButton("ANULAR");
    public JRadioButton radQualquer = new JRadioButton("");
    
    ButtonGroup g = new ButtonGroup();
    
    public JButton butExecutar = new JButton("EXECUTAR");
    public JButton butProcurar = new JButton("PROCURAR");
    public JButton butArq = new JButton("ARQ-FICH");
    public JButton butMenu = new JButton("MENU");
    
    public Container contentor = getContentPane();
    
    public Processamento(){
        
        super("PROCESSAMENTO-SALARIO");
        
        painel.setLayout(null);
        painelPesquisa.setLayout(null);
        painelResultado.setLayout(null);
        painelSalario.setLayout(null);
        painelOperacao.setLayout(null);
        
        painel.setBackground(Color.ORANGE);
        butExecutar.setBackground(Color.decode("#50af76"));
        butProcurar.setBackground(Color.getHSBColor(180, 22, 57));
        butMenu.setBackground(Color.decode("#d1f4da"));
        butArq.setBackground(Color.decode("#768289"));
        
            painel.add(lblCodigo);  painel.add(txtCodigo);
            painel.add(lblNome);  painel.add(txtNome);
            painel.add(lblSexo);  painel.add(cboSexo);
            painel.add(lblCivil);  painel.add(txtCivil);
            painel.add(lblMes);  painel.add(cboMes);
            painel.add(lblValor);  painel.add(txtValor);
            painel.add(radAtribui);  painel.add(radActualiza);
            painel.add(radQualquer);  painel.add(radAnula);
            painel.add(butProcurar);  painel.add(butExecutar);
            painel.add(butArq);  painel.add(butMenu);  
            painel.add(painelPesquisa);  painel.add(painelResultado);
            painel.add(painelOperacao);  painel.add(painelSalario);   
            contentor.add(painel);
            g.add(radAtribui);  g.add(radActualiza);  g.add(radAnula);  g.add(radQualquer);
            
            painelPesquisa.setBorder(BorderFactory.createTitledBorder("PESQUISA DADOS"));
            painelResultado.setBorder(BorderFactory.createTitledBorder("RESULTADO"));
            painelSalario.setBorder(BorderFactory.createTitledBorder("DEFINIR SALARIO"));
            painelOperacao.setBorder(BorderFactory.createTitledBorder("OPERACAO"));
            
            lblCodigo.setBounds(60, 50, 80, 30);txtCodigo.setBounds(130, 50, 140, 30);
            lblNome.setBounds(60, 120, 80, 30);txtNome.setBounds(120, 120, 180, 30);
            lblSexo.setBounds(60, 160, 80, 30);cboSexo.setBounds(120, 160, 180, 30);
            lblCivil.setBounds(60, 200, 80, 30);txtCivil.setBounds(120, 200, 180, 30);
            lblMes.setBounds(60, 280, 80, 30);cboMes.setBounds(120, 280, 180, 30);
            lblValor.setBounds(60, 320, 80, 30);txtValor.setBounds(120, 320, 180, 30);
            
            painelPesquisa.setBounds(40,30,430,60);         
            painelResultado.setBounds(40,100,430, 150);         
            painelSalario.setBounds(40,260,430,300);         
            painelOperacao.setBounds(60,360,310,100);         
            
            radAtribui.setBounds(80, 380, 110, 30);
            radActualiza.setBounds(80, 400, 110, 30);        
            radAnula.setBounds(80, 420, 110, 30);        
            
            butProcurar.setBounds(285, 50, 140, 30);butExecutar.setBounds(60, 490, 150, 40);
            butArq.setBounds(320, 200, 100, 30); butMenu.setBounds(285, 490, 150, 40);
            
            this.setSize(600, 650);
            this.setVisible(true);
            
            txtCodigo.setToolTipText("DIGITE O CODIGO DO FUNCIONARIO");
            cboMes.setToolTipText("SELECIONE O MES");
            txtValor.setToolTipText("INTRODUZA O SALARIO");
            butProcurar.setToolTipText("CLICK AQUI PARA OBTER AS INFORMACOES DO FUNCIONARIO");
            butExecutar.setToolTipText("CLICK AQUI PARA EXECUTAR A ACCAO");
            butMenu.setToolTipText("CLICK AQUI PARA ENTRAR NO MENU");
            painelOperacao.setToolTipText("ESCOLHA UMA OPCAO A SER EXECUTADA");
            
            eventos();
            leituraFicheiro();
    }
    
    public void procurar(){
            
            Funcionario p;
            int code = Integer.parseInt(txtCodigo.getText());
            boolean has = false;
            
            for(int i = 0;i<x.size(); i++){
                if(x.get(i).getCodigo()== code){
                    p=x.get(i); 
                    x.elementAt(i);
                    
                    has = true;
                    
                    txtNome.setText(p.nome);
                    cboSexo.setSelectedItem(p.sexo);
                    txtCivil.setText(p.geteCivil());
                }
            }
            if(!has){JOptionPane.showMessageDialog(this, "CODIGO INESISTENTE", "SENHA", 0);}
    }
    
    public void atribui(){
        Funcionario h = new Funcionario();
        
        int code = Integer.parseInt(txtCodigo.getText());
        
        for (int i = 0; i < x.size(); i++) {
            h = x.get(i);
            if(h.getCodigo()==code && radAtribui.isSelected()){
                
                int Mes = (int) cboMes.getSelectedIndex();
                
                h.setSalario(Double.parseDouble(txtValor.getText()),Mes);
                
                escritaFicheiro();
            }
        }
        JOptionPane.showMessageDialog(this, "ATRIBUICAO FEITA COM SUCESSO");
        
        txtCodigo.setText("");
        txtNome.setText("");
        cboSexo.setSelectedIndex(-1);
        txtCivil.setText("");
        cboMes.setSelectedIndex(-1);
        txtValor.setText("");
        radAtribui.setSelected(false);
        radActualiza.setSelected(false);
        radQualquer.setSelected(true);
        radAnula.setSelected(false);
    }
    
    public void Actualiza(){
        
        Funcionario d;
            
            int code = Integer.parseInt(txtCodigo.getText());
            
            for(int i = 0; i<x.size(); i++){
                d = x.get(i);
                if(d.getCodigo() == code && radActualiza.isSelected()){
                    
                    int m = (int) cboMes.getSelectedIndex();
                
                    d.setSalario(Double.parseDouble(txtValor.getText()),m);
                    
                    escritaFicheiro();
                }    
            }
            JOptionPane.showMessageDialog(this, "ACTUALIZACAO FEITA COM SUCESSO");
            
            txtCodigo.setText("");
            txtNome.setText("");
            cboSexo.setSelectedIndex(-1);
            txtCivil.setText("");
            cboMes.setSelectedIndex(-1);
            txtValor.setText("");
            radAtribui.setSelected(false);
            radActualiza.setSelected(false);
            radAnula.setSelected(false);
            radQualquer.setSelected(true);
    } 
    
    public void anula(){
        
        Funcionario v;
        
       // int code = Integer.parseInt(txtCodigo.getText());
        
        for(int i = 0; i<x.size(); i++){
             v = x.get(i);
                if(v.getCodigo() == Integer.parseInt(txtCodigo.getText()) && radAnula.isSelected()){
                    
                    int mes1 = (int) cboMes.getSelectedIndex();
                    
                    v.setSalario(0.0, mes1);
                    
                    escritaFicheiro();
                }
        }    
        
        JOptionPane.showMessageDialog(this, "ANULAMENTO FEITO COM SUCESSO");
            
            txtCodigo.setText("");
            txtNome.setText("");
            cboSexo.setSelectedIndex(-1);
            txtCivil.setText("");
            cboMes.setSelectedIndex(-1);
            txtValor.setText("");
            radAtribui.setSelected(false);
            radActualiza.setSelected(false);
            radAnula.setSelected(false);
            radQualquer.setSelected(true);
            
    }
    
    public void rads(){
        if(radAtribui.isSelected()){
            atribui(); 
        }    
        if(radActualiza.isSelected()){
            Actualiza(); 
        }
        if (radAnula.isSelected()){
            anula(); 
        }
    }
    
        public void escritaFicheiro(){
            try{
                File f = new File("Funcionario.Dat");
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(x);
                oos.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Error " + e.getMessage());
            }
        }

        public void leituraFicheiro(){
            try{
                File f = new File("Funcionario.Dat");
                FileInputStream fis = new FileInputStream (f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                x=(Vector)ois.readObject();
                ois.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Error " + e.getMessage());
            }
        }
    
    public void eventos(){
            
        butProcurar.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                   procurar();
                }                
            }
        );
            
        butExecutar.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    rads(); escritaFicheiro();
                }                
            }
        );
        
        butArq.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    escritaFicheiro();
                }                
            }
        );
        
        butMenu.addActionListener((ActionEvent ae) -> {
            new Menu_Do_Sistema();
            dispose();
        });
        
    }  
    
    public static void main(String[] args) {
        new Processamento();
    }
}
