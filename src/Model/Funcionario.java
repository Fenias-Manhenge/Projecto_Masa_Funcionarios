/**
 *
 * @author Fenias
 */
import java.io.*;
public class Funcionario implements Serializable {

    private int codigo;
    public String nome;
    public String sexo;
    private String eCivil;
    private double salario [] = new double[12];;

    public Funcionario(int codigo, String nome, String sexo, String eCivil) {
        this.codigo = codigo;
        this.nome = nome;
        this.sexo = sexo;
        this.eCivil = eCivil;
        for(int i=0;i<salario.length;i++){
          this.salario[i]=0.0;
        }
    }

    Funcionario() {

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String geteCivil() {
        return eCivil;
    }

    public void seteCivil(String eCivil) {
        this.eCivil = eCivil;
    }

    public double[] getSalario() {
        return salario;
    }

    public void setSalario(double salario, int mes) {
        this.salario[mes] = salario;
    }
    
}
