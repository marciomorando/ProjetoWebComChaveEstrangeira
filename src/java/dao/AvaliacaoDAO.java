/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import conexao.Conecta;
import dados.Avaliacao;
import dados.Trilha;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MarcioMorando
 */
public class AvaliacaoDAO {
    
    
        
    
    public String addAvaliacao(Avaliacao cli) {
        
        Conecta c = new Conecta();

            if ("sucesso".equals(c.getMsg())) {
                String sql = "INSERT INTO APP.AVALIACAO (NOME_PESSOA, AVALIACAO, COD_TRILHA) "
                        + "VALUES ('"+ cli.getNome_pessoa()+"','"+cli.getAvaliacao()+"',"+cli.getTrilha().getCodigo()+")"; 
                try {
                    c.getStm().execute(sql);
                    return "sucesso";
                } catch (SQLException ex) {
                    return ("erro:" + ex.getMessage());
                }
            } else {
                return ("erro:" + c.getMsg());
            }
    }
    
    public List<Avaliacao> getAvaliacoes() {
        List<Avaliacao> lista = new ArrayList<Avaliacao>();
        
        Conecta c = new Conecta();

            if ("sucesso".equals(c.getMsg())) {

                // Vamos preparar o comando SQL:
                String sql = "SELECT AVALIACAO.NOME_PESSOA,AVALIACAO.AVALIACAO,TRILHAS.NOME_TRILHA\n" +
                "    FROM AVALIACAO\n" +
                "    INNER JOIN TRILHAS\n" +
                "    ON AVALIACAO.COD_TRILHA = TRILHAS.CODIGO";

                // Definido o Statement, executamos o comando no banco de dados.
                ResultSet rs;
                    
            try {
                rs = c.getStm().executeQuery(sql);
            

                    int nregistros = 0;

                    // caso existir resultados, percorremos a lista.
                    while (rs.next()) {
                        //leitura dos campos da tabela em variáveis
                        int cod = rs.getInt("CODIGO");
                        String nome = rs.getString("NOME_PESSOA");
                        String avaliacao = rs.getString("AVALIACAO");
                        
                        
                        int codCategoria = rs.getInt("COD_TRILHA");
                        Trilha trilha = new Trilha();
                        trilha.setCodigo(codCategoria);
                        
                        String nomeTrilha = rs.getString("NOME_TRILHA");
                        trilha.setNometrilha(nomeTrilha);
                       
                        
                    
                        
                        
                        Avaliacao cli = new Avaliacao(cod,nome,avaliacao,trilha);
                        
                        lista.add(cli);
                    }
                
            } catch (SQLException ex) {
                Logger.getLogger(AvaliacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return lista;
    }
        return lista;
            
    
    }
    
    
    
    
}
