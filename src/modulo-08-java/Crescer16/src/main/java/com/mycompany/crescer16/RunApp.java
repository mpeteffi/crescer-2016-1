package com.mycompany.crescer16;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Murillo
 */
public class RunApp {
    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER16");
    static final EntityManager em = emf.createEntityManager();
    
    public static void main(String[] args) {
        System.out.print(em.isOpen());
    }
}
