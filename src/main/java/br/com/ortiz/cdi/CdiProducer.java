package br.com.ortiz.cdi;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CdiProducer {

    @PersistenceContext
    private EntityManager entityManager;

    @Produces
    public EntityManager createEntityManager() {
        return entityManager;
    }

    public void dispose(@Disposes EntityManager em) {
        em.close();
    }

}