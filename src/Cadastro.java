/**
 *
 * @author Fenias
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Cadastro extends JFrame{

    public Vector <Funcionario> x = new Vector();
        
        public JPanel painel = new JPanel();
        public JPanel painelEstado = new JPanel();
        
        public JLabel lblCodigo = new JLabel ("CODIGO:");
        public JLabel lblNome = new JLabel ("NOME:");
        public JLabel lblSexo = new JLabel ("SEXO:");
        
        String lista [] = {"MASCULINO","FEMENINO"};
        public JComboBox cboSexo= new JComboBox(lista);
        
        public JTextField txtCodigo = new JTextField("");
        public JTextField txtNome = new JTextField("");
        
        public JRadioButton radCasado = new JRadioButton("CASADO");
        public JRadioButton radSolteiro = new JRadioButton("SOLTEIRO");  
        public JRadioButton radQualquer = new JRadioButton("");
        
        ButtonGroup g1 = new ButtonGroup();
        
        public JButton butIntroduz = new JButton ("REGISTAR");
        public JButton butProcurar = new JButton ("PROCURAR");
        public JButton butActualiza = new JButton ("ACTUALIZAR");        
        public JButton butApaga = new JButton ("APAGAR");
        public JButton butProcessar = new JButton ("PROC.SALARIO");
        public JButton butMenu = new JButton ("FOLHA");
        public JButton butLimpar = new JButton ("LIMPAR");
        public JButton butArq = new JButton("ARQ-FICH");
        
        public Container contentor = getContentPane();
        
        public Cadastro(){
            super ("CADASTRO DE FUNCIONARIO");
            
            painel.setLayout(null);
            painelEstado.setLayout(null);
            
            painel.setBackground(Color.decode("#f0efbd"));
            butApaga.setBackground(Color.decode("#d70c1b"));
            butIntroduz.setBackground(Color.decode("#1e8a23"));
            butActualiza.setBackground(Color.decode("#31ce85"));
            butMenu.setBackground(Color.decode("#3946c6"));
            butArq.setBackground(Color.decode("#768289"));
            butProcurar.setBackground(Color.decode("#5b96a4"));
            butProcessar.setBackground(Color.decode("#ebab14"));
            butArq.setBackground(Color.decode("#768289"));
            butLimpar.setBackground(Color.decode("#eff1ee"));
            
            butApaga.setFocusCycleRoot(true);
            
            painel.add(lblCodigo);  painel.add(txtCodigo);
            painel.add(lblNome);  painel.add(txtNome);
            painel.add(lblSexo);  painel.add(cboSexo);
            painel.add(radCasado);  painel.add(radSolteiro);
            painel.add(radQualquer);  painel.add(butLimpar);
            painel.add(butIntroduz);  painel.add(butProcurar);
            painel.add(butActualiza);  painel.add(butApaga);
            painel.add(butProcessar);  painel.add(butMenu);
            painel.add(butArq);
            painel.add(painelEstado);  contentor.add(painel);
            g1.add(radCasado);  g1.add(radSolteiro);  g1.add(radQualquer);
            
            painelEstado.setBorder(BorderFactory.createTitledBorder("ESTADO CIVIL"));

            lblCodigo.setBounds(40, 30, 80, 30);txtCodigo.setBounds(140, 30, 180, 30);
            lblNome.setBounds(40, 70, 80, 30);txtNome.setBounds(140, 70, 180, 30);
            lblSexo.setBounds(40, 110, 80, 30);cboSexo.setBounds(140, 110, 180, 30);
            
            painelEstado.setBounds(40,180,430,80);         
            
            radCasado.setBounds(60, 200, 110, 30);
            radSolteiro.setBounds(60, 220, 110, 30);        
            
            butIntroduz.setBounds(40, 310, 150, 40);butProcurar.setBounds(220, 310, 150, 40);
            butActualiza.setBounds(40, 360, 150, 40);butApaga.setBounds(220, 360, 150, 40);
            butProcessar.setBounds(40, 410, 150, 40);butMenu.setBounds(220, 410, 150, 40);
            butLimpar.setBounds(40, 460, 330, 40);  butArq.setBounds(350, 110, 100, 30);
            
            this.setSize(600, 600);
            this.setVisible(true);
            
            txtCodigo.setToolTipText("INTRODUZA O CODIGO DO FUNCIONARIO");
            txtNome.setToolTipText("INTRODUZA O NOME DO FUNCIONARIO");
            cboSexo.setToolTipText("SELECIONE O SEXO");
            
            butIntroduz.setToolTipText("CLICK AQUI PARA CADASTRAR O FUNCIONARIO");
            butActualiza.setToolTipText("CLICK AQUI PARA ATUALIZAR OS DADOS");
            butProcurar.setToolTipText("CLICK AQUI PARA ENCOTRAR O FUNCIONARIO");
            butApaga.setToolTipText("CLICK AQUI PARA ELIMINAR OS DADOS DO FUNCIONARIO");
            butProcessar.setToolTipText("CLICK AQUI PARA PROCESSAR OS SALARIOS");
            butMenu.setToolTipText("CLICK AQUI PARA ENTRAR NO MENU");
            butLimpar.setToolTipText("CLICK AQUI PARA LIMPAR O FORMULARIO");
            painelEstado.setToolTipText("SELECIONE A OPCAO ESTADO CIVIL");
            butArq.setToolTipText("CLICK AQUI PARA GRAVAR OS DADOS");
            
            leituraFicheiro();
            eventos();
            
        }    
        
        public void registar(){
            Funcionario g ;
            
            int code = Integer.parseInt(txtCodigo.getText());
            
            
                if(code>0 && existeFuncionario(code)==false){
                    g= new Funcionario();
                    g.setCodigo(code);
                    g.nome = txtNome.getText();
                    g.sexo =(String) cboSexo.getSelectedItem();
                    if(radCasado.isSelected()){
                       g.seteCivil("CASADO");
                    }else{
                        if(radSolteiro.isSelected()){
                            g.seteCivil("SOLTEIRO");
                        }
                    }
                    x.addElement(g);
                    escritaFicheiro();
                    
                    txtCodigo.setText("");
                    txtNome.setText("");
                    cboSexo.setSelectedIndex(-1);
                    radCasado.setSelected(false);
                    radSolteiro.setSelected(false);
                    radQualquer.setSelected(true);
                    
                    JOptionPane.showMessageDialog(this,"REGISTO FEITO COM SUCESSO");
                    
                }else{JOptionPane.showMessageDialog(this, "CODIGO EXISTENTE", "ATRIBUICAO", 0);}
            
        }
        
        public  boolean existeFuncionario(int code){
            boolean hasCode = false;
            
            for (int i = 0; i < x.size(); i++) {
                if(x.get(i).getCodigo()==code){
                    hasCode = true;
                }
            }
            return hasCode;
        }
        
        public void actualiza(){
            
            Funcionario k;
            boolean hasCode = false; 
            int code = Integer.parseInt(txtCodigo.getText());        
            
            for(int i = 0; i<x.size(); i++){
                if(x.get(i).getCodigo()== code){
                    k = x.get(i);
                    hasCode = true;
                    k.nome= txtNome.getText();
                    k.sexo = (String) cboSexo.getSelectedItem();
                    if(radCasado.isSelected()){
                       k.seteCivil("CASADO");
                    }else{
                        if(radSolteiro.isSelected()){
                            k.seteCivil("SOLTEIRO");
                        }
                    }
                    
                    x.setElementAt(k, i);
                    escritaFicheiro();
                    
                    JOptionPane.showMessageDialog(null, "ACTUALIZACAO FEITA COM SUCESSO");
                    
                    txtCodigo.setText("");
                    txtNome.setText("");
                    cboSexo.setSelectedIndex(-1);
                    radCasado.setSelected(false);
                    radSolteiro.setSelected(false);
                    radQualquer.setSelected(true);
                }
            }
            if(!hasCode){JOptionPane.showMessageDialog(this, "CODIGO INESISTENTE", "SENHA", 0);}
        } 
        
        public void procurar(){
            
            Funcionario p;
            int code = Integer.parseInt(txtCodigo.getText());
            boolean tem = false;
            
            for(int i = 0;i<x.size(); i++){
                p=x.get(i); 
                if(p.getCodigo()== code){
                    
                    tem = true;
                    
                    x.elementAt(i);
                    txtNome.setText(p.nome);
                    cboSexo.setSelectedItem(p.sexo);
                    if(p.geteCivil().equals("CASADO")){
                        radCasado.setSelected(true);
                      }else{
                            if(p.geteCivil().equals("SOLTEIRO")){
                                radSolteiro.setSelected(true);
                            }
                        }
                }
            }
            if(!tem){JOptionPane.showMessageDialog(this, "CODIGO INESISTENTE", "SENHA", 0);}

        }

        public void apaga(){
            
            int code = Integer.parseInt(txtCodigo.getText());
            boolean existe = false;
            
            for(int i = 0;i<x.size(); i++){
                if(x.get(i).getCodigo()==code){
                    int resp = JOptionPane.showConfirmDialog(this, "FUNCIONARIO ENCOTRADA,DESEJA MESMO REMOVE-LHO? ");
                    if(resp == 0 ){
                        x.remove(i);
                        escritaFicheiro();
                        JOptionPane.showMessageDialog(this, "REMOCAO FEITA COM SUCESSO");
                        
                        txtCodigo.setText("");
                        txtNome.setText("");
                        cboSexo.setSelectedIndex(-1);
                        radCasado.setSelected(false);
                        radSolteiro.setSelected(false);
                        radQualquer.setSelected(true);
                    }
                }
            }    
            if(!existe){JOptionPane.showMessageDialog(this, "CODIGO INESISTENTE", "SENHA", 0);}
        }
        
        public void limpar(){
            txtCodigo.setText("");
            txtNome.setText("");
            cboSexo.setSelectedIndex(-1);
            radCasado.setSelected(false);
            radSolteiro.setSelected(false);
            radQualquer.setSelected(true);
        }
        
        public void escritaFicheiro(){
            try{
                File f = new File("Funcionario.Dat");
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(x);
                oos.close();
            }catch(Exception e){
                //System.err.println("error: " + e.getMessage());
                JOptionPane.showMessageDialog(this, "Error");
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
                //System.err.println("error: " + e.getMessage());
                JOptionPane.showMessageDialog(this, "Error");}
        }
        
        public void eventos(){
            
            butIntroduz.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    registar();
                }                
            }
            );
            
            butProcurar.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                  procurar();
                }                
            }
            );
            
            butActualiza.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                  actualiza();
                }                
            }
            );
            
            butApaga.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                  apaga();
                }                
            }
            );
            
            butProcessar.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    new Processamento();
                    dispose();
                }                
            }
            );
            
            butLimpar.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    limpar();
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
            
            butMenu.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    new Folha();
                    dispose();
                }                
            }
            );
        }  
        
        public static void main(String[] args) {
            new Cadastro();
        }
    
}
