/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import conexao.Conecta;
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
public class TrilhaDAO {
    
        
    
    public String addTrilha(Trilha cli) {
        
        Conecta c = new Conecta();

            if ("sucesso".equals(c.getMsg())) {
                String sql = "INSERT INTO APP.TRILHAS (NOME_TRILHA) "
                        + "VALUES ('"+ cli.getNometrilha()+"')"; 
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
    
    public List<Trilha> getTrilhas() {
        List<Trilha> lista = new ArrayList<Trilha>();
        
        Conecta c = new Conecta();

            if ("sucesso".equals(c.getMsg())) {

                // Vamos preparar o comando SQL:
                String sql = "select tri.* from TRILHAS TRI ";

                // Definido o Statement, executamos o comando no banco de dados.
                ResultSet rs;
                    
            try {
                rs = c.getStm().executeQuery(sql);
            

                    int nregistros = 0;

                    // caso existir resultados, percorremos a lista.
                    while (rs.next()) {
                        //leitura dos campos da tabela em variáveis
                        int cod = rs.getInt("CODIGO");
                        String nometrilha = rs.getString("NOME_TRILHA");
                        
                        
                        Trilha cli = new Trilha(cod,nometrilha);
                        
                        lista.add(cli);
                    }
                
            } catch (SQLException ex) {
                Logger.getLogger(TrilhaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return lista;
    }
        return lista;
            
    
    }
    
    
    
    
}
