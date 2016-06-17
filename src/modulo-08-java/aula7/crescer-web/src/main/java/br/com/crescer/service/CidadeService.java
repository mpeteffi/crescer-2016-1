package br.com.crescer.service;

import br.com.crescer.service.abstracts.AbstractService;
import br.com.crescer.entity.Cidade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Murillo Peteffi
 */
@Stateless
public class CidadeService extends AbstractService<Cidade> {

    @PersistenceContext(unitName = "crescerPU")
    private EntityManager entityManager;

    public CidadeService() {
        super(Cidade.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }
}
