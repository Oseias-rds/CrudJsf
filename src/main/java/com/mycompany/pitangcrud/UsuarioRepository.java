package com.mycompany.pitangcrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class UsuarioRepository {

    private String url = "jdbc:mysql://localhost:3306/cadatro";
    private String driver = "";
    private String Name = "root";
    private String password = "";
    private Connection conn;
    TelefoneRepository tr = new TelefoneRepository();
    

    public UsuarioRepository() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(
                    url, Name, password);

        } catch (Exception ex) {
            Logger.getLogger(UsuarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fazerLoging(String email, String senha) {
        try {

            //Preparar SQL para inserção de dados do Usuario                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 .
            String sql = "select *FROM Usuario WHERE email=?, senha=?";
            //Preparar statement com os parâmetros recebidos
            PreparedStatement src = conn.prepareStatement(sql);
            src.setString(0, email);
            src.setString(1, senha);

            int rowsAffected = src.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("usuario já existe");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void incluirUsuario(Usuario usuario, List<String>telefones) {
        try {

            //Preparar SQL para inserção de dados do Usuario                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 .
            String sql = "INSERT INTO usuario(nome, email, senha)"
                    + "VALUES (?, ?, ?)";
            //Preparar statement com os parâmetros recebidos
            PreparedStatement src = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            src.setString(1, usuario.getNome());
            src.setString(2, usuario.getEmail());
            src.setString(3, usuario.getSenha());
            
            src.executeUpdate();
            ResultSet fl = src.getGeneratedKeys();
            
            
            if (fl.next()) {
                int id = fl.getInt(1);
                this.tr.salvarTelefone(id, conn, usuario );
            }
            

            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 public void excluirUsuario(int id) {
        try {

            String sql = "delete FROM usuario WHERE id = ?";
            PreparedStatement src = conn.prepareStatement(sql);
            src.setInt(1, id);

            src.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void excluirTelefone(int id) {
        try {

            String sql = "delete FROM telefones WHERE id = ?";
            PreparedStatement src = conn.prepareStatement(sql);
            src.setInt(1, id);

            src.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void alterarUsuario(int id, String novoNome) {
        try  {
            String sql = "update usuario set nome = ? "
                    + " where id = ?";

            PreparedStatement src = conn.prepareStatement(sql);
            src.setString(1, novoNome);
            src.setInt(2, id);

            int rowsAffected = src.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
public List listar() {

        ArrayList<Usuario> lista = new ArrayList();

        try  {

            PreparedStatement src = conn.prepareStatement("SELECT * FROM usuario ");
           
            src.executeQuery();

            // Resultset é o resultado da busca no banco de dados
            ResultSet r = src.getResultSet();

            // Percorrendo o resultado da busca
            
            while (r.next()) {

                Usuario pessoa = new Usuario();

                pessoa.setNome(r.getString("nome"));
                pessoa.setEmail(r.getString("email"));
                //pessoa.setTelefones( r.getStrint("telefone"));
                pessoa.setId(r.getInt("id"));
                lista.add(pessoa);
               
               
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    public List pesquisar(String nome) {

        ArrayList<Usuario> lista = new ArrayList();

        try  {

            PreparedStatement src = conn.prepareStatement("SELECT * FROM usuario WHERE nome LIKE ?");
           
            src.setString(1, "%" + nome + "%");
            src.executeQuery();

            // Resultset é o resultado da busca no banco de dados
            ResultSet r = src.getResultSet();

            // Percorrendo o resultado da busca
            
            while (r.next()) {

                Usuario pessoa = new Usuario();

                pessoa.setNome(r.getString("nome"));
                pessoa.setEmail(r.getString("email"));
                //pessoa.setTelefones( r.getStrint("telefone"));
                pessoa.setId(r.getInt("id"));
                lista.add(pessoa);
               
               
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    private Connection ConnectionFactory() {
        return null;
    }
}
