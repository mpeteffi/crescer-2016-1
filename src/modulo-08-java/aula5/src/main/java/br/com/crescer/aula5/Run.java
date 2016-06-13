package br.com.crescer.aula5;


import br.com.crescer.aula5.Cliente;
import dao.ClienteDAO;
import dao.DAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author murillo.peteffi
 */
public class Run {
    
    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER16");
    static final EntityManager em = emf.createEntityManager();
    
     public static void main(String[] args){
     
        
        //ClienteDAO dao = new ClienteDAO(em);
        
//        DAO<Cliente> dao = new DAO<Cliente>(Cliente.class){
//            @Override
//            public EntityManager getEntityManager(){
//                return em;
//            }
//        };
        
        System.out.println(em.isOpen());
        
     }
}
