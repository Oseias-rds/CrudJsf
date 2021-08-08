
package com.mycompany.pitangcrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class TelefoneRepository {
    private Connection conn;
    private List<String> getTelefones(int id, Connection conexao){
     ArrayList<String> lista = new ArrayList();

        try  {

            PreparedStatement src = conexao.prepareStatement("SELECT *FROM telefone WHERE id = ? ");
           
            src.setInt(1, id);
            src.executeQuery();

            // Resultset é o resultado da busca no banco de dados
            ResultSet r = src.getResultSet();

            // Percorrendo o resultado da busca
            
            while (r.next()) {

                String telefone = r.getString("telefone");
                lista.add(telefone);
               
               
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
        
    }
    public void salvarTelefone(int id,Connection conn, Usuario usuario){
        
        try {

            
                        String sql = "INSERT INTO telefones (id_usuario,telefone, ddd)"
                    + "VALUES (?, ?, ?)";
            //Preparar statement com os parâmetros recebidos
            PreparedStatement src = conn.prepareStatement(sql);
            src.setInt(1, id);
            src.setString(2, usuario.getTelefone());
            src.setInt(3, usuario.getDdd());
            src.executeUpdate();
            
            //Preparar SQL para inserção de dados do Usuario                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 .
    
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    }
    
    
  
