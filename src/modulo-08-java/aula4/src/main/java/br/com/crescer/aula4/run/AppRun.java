package br.com.crescer.aula4.run;

import br.com.crescer.aula4.entity.Amizade;
import br.com.crescer.aula4.entity.Pessoa;
import br.com.crescer.aula4.entity.Usuario;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * @author murillo.peteffi
 */
public class AppRun {
    
    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER16");
    static final EntityManager em = emf.createEntityManager();
    
    public static void main(String[] args){       
        
        // INSERT PESSOA
        em.getTransaction().begin();
        
        Usuario usuario = new Usuario();
        usuario.setNome("MURILLO");
//        Usuario usuario2 = new Usuario();
//        usuario2.setNome("PEDRO");
//        Amizade amizade = new Amizade();
//        amizade.setUsuario(usuario1);
//        amizade.setUsuario_amigo(usuario2);
//        amizade.setData_amizade(new Date());
        
        em.persist(usuario);
//        em.persist(usuario2);
//        em.persist(amizade);
        em.getTransaction().commit();

        // SELECT PESSOA
//        Query query = em.createQuery("SELECT p FROM Pessoa p");
//        List<Pessoa> pessoas = query.getResultList();
//        pessoas.forEach(p -> System.out.println(p.getNmPessoa())); 

        // UPDATE PESSOA
//        Query query = em.createQuery("SELECT p FROM Pessoa p");
//        List<Pessoa> pessoas = query.getResultList();
//        Pessoa editar = pessoas.get(0);
//        editar.setNmPessoa("MURILLO");
//        em.getTransaction().begin();
//        em.merge(editar);
//        em.getTransaction().commit();

        // DELETE PESSOA
//        Query query = em.createQuery("SELECT p FROM Pessoa p");
//        List<Pessoa> pessoas = query.getResultList();
//        em.getTransaction().begin();
//        pessoas.forEach(p -> em.remove(p));
//        em.getTransaction().commit();
        

        em.close(); 
        emf.close();
    }    
}
