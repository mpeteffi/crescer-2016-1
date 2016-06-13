package dao;

import br.com.crescer.aula5.Cliente;
import javax.persistence.EntityManager;

/**
 * @author murillo.peteffi
 */
public class ClienteDAO extends DAO{

    final EntityManager EntityManager;
            
    public ClienteDAO(EntityManager em) {
        super(Cliente.class);
        this.EntityManager = em;
    }

    @Override
    public EntityManager getEntityManager() {
        return EntityManager; 
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
