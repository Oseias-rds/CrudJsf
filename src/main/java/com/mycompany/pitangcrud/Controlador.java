package com.mycompany.pitangcrud;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;


/**
 *
 * @author user
 */
@ViewScoped
@Named
@ManagedBean(name="f")
public class Controlador {
       //para fazer a chamada para a classe "responsavel" pelo banco de dados
    private UsuarioRepository  ur = new UsuarioRepository ();
    private FormularioBean H = new FormularioBean();
    private EditarBean eb = new EditarBean();

    public FormularioBean getH() {
        return H;
    }

    public void setH(FormularioBean H) {
        this.H = H;
    }
    private Usuario[] listaCadastro = new Usuario[100];
    private Usuario usuario = new Usuario();
    
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
    
    public void fazerLoging(String email, String senha){
                
        this.ur.fazerLoging(email, senha);
        
    }
    
    
    public void incluirUsuario(String nome, String email, int DDD , String telefone , String senha) {
        Usuario c1 = new Usuario();
       
        
        //preencher o objeto c1 que esta vazio com os dados que recebe como parâmetro
        c1.setNome(nome);
        c1.setEmail(email);
        c1.setSenha(senha);
        c1.setTelefone(telefone);
        c1.setDdd(DDD);
        
        
        List<String> f = new ArrayList<>();
        f.add("18793871");
        f.add("a987298137198");
        
        this.ur.incluirUsuario(c1, f);
        
    }
      
    
        
        
    public void EditarUsuario(int id, String novoNome ) {

        this.ur.alterarUsuario(id,novoNome);
        
        

    }
    
    



    public void removerUsuario(int id) {

       this.ur.excluirUsuario(id);
    }
       

    private List<Usuario> pesquisarUsuario(String nome) {
    
             return this.ur.pesquisar(nome);
          
    }
      public List<Usuario> listar() {
    
             return this.ur.listar();
          
    }
      
      public String cadastrar(){
      this.incluirUsuario(H.getNome(), H.getEmail(), H.getDDD() , H.getTelefone() ,H.getSenha());
      return "listar.xhtml";
      }
    
//    public void hello(){
//        UsuarioRepository s = new UsuarioRepository();
//        Usuario us = new Usuario();
//        
//        ArrayList<String> li = new ArrayList();
////        li.add("98127787");
////        li.add("98120778");
////        li.add("32132137");
////        li.add("98127115");
//        s.excluirTelefone(4);
//        
////        us.setNome("oseias");
////        us.setEmail("oseas-ramos123@hotmail.com");
////        us.setSenha("B123@");
////        us.setDdd(81);
////        us.setTelefones(li);
////        s.incluirUsuario(us, li);

   // }
    
    
    
    
    
}
