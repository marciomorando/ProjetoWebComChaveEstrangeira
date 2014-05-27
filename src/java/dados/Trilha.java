/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dados;

/**
 *
 * @author MarcioMorando
 */
public class Trilha {
    private int codigo;
    String nometrilha;

    public Trilha(int codigo, String nometrilha) {
        this.codigo = codigo;
        this.nometrilha = nometrilha;
    }
    
    public Trilha(){
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNometrilha() {
        return nometrilha;
    }

    public void setNometrilha(String nometrilha) {
        this.nometrilha = nometrilha;
    }
    
    
}
