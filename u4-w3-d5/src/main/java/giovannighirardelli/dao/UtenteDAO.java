package giovannighirardelli.dao;


import giovannighirardelli.entities.Utente;
import giovannighirardelli.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UtenteDAO {
    private final EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Utente utente) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(utente);
        transaction.commit();
        System.out.println("L'utente " + utente.getNome() + " è stato aggiunto con successo");
    }

    public Utente findById(long utenteId) {
        Utente utente = em.find(Utente.class, utenteId);
        if (utente == null) throw new NotFoundException(utenteId);
        return utente;
    }

}
