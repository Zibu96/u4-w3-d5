package giovannighirardelli.dao;

import giovannighirardelli.entities.Prestito;
import giovannighirardelli.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PrestitoDAO {
    private final EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Prestito prestito) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(prestito);
        transaction.commit();
        System.out.println("Il prestito di " + prestito.getUtente() + " è stato aggiunto con successo");
    }

    public Prestito findById(long prestitoId) {
        Prestito prestito = em.find(Prestito.class, prestitoId);
        if (prestito == null) throw new NotFoundException(prestitoId);
        return prestito;
    }
}
