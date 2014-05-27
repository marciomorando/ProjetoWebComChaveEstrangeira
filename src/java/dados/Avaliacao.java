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
public class Avaliacao {
    private int codigo;
    String nome_pessoa;
    String avaliacao;
    private Trilha trilha;

    public Avaliacao(int codigo, String nome_pessoa, String avaliacao, Trilha trilha) {
        this.codigo = codigo;
        this.nome_pessoa = nome_pessoa;
        this.avaliacao = avaliacao;
        this.trilha = trilha;
    }
    
   public Avaliacao(){
       
   }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome_pessoa() {
        return nome_pessoa;
    }

    public void setNome_pessoa(String nome_pessoa) {
        this.nome_pessoa = nome_pessoa;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Trilha getTrilha() {
        return trilha;
    }

    public void setTrilha(Trilha trilha) {
        this.trilha = trilha;
    }

  
    
}
