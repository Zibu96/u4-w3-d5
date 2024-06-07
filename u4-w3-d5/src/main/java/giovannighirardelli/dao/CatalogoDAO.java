package giovannighirardelli.dao;

import giovannighirardelli.entities.Catalogo;
import giovannighirardelli.entities.Prestito;
import giovannighirardelli.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class CatalogoDAO {
    private final EntityManager em;

    public CatalogoDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Catalogo catalogo) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(catalogo);
        transaction.commit();
        System.out.println("L'oggetto " + catalogo.getTitolo() + " è stato aggiunto con successo");
    }

    public Catalogo findByIsbm(long catalogoId) {
        Catalogo catalogo = em.find(Catalogo.class, catalogoId);
        if (catalogo == null) throw new NotFoundException(catalogoId);
        return catalogo;
    }

    public List<Catalogo> getElementoByIsbm(long id) {
        TypedQuery<Catalogo> query = em.createQuery("SELECT c From Catalogo c Where c.codiceISBN = :id", Catalogo.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    public void findElementoByIdAndDelete(long id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query deleteQuery = em.createQuery("DELETE FROM Catalogo c WHERE c.codiceISBN = :id");
        deleteQuery.setParameter("id", id);
        int numeroCancellati = deleteQuery.executeUpdate();

        transaction.commit();
        System.out.println(numeroCancellati + " elemnto con id " + id + " cancellato correttamente");
    }


    public List<Catalogo> getElementoByAnnoPubblicazione(long anno) {
        TypedQuery<Catalogo> query = em.createQuery("SELECT c From Catalogo c Where c.annoPubbl = :anno", Catalogo.class);
        query.setParameter("anno", anno);
        return query.getResultList();
    }


    public List<Catalogo> getElementoByAutore(String autore) {
        TypedQuery<Catalogo> query = em.createQuery("SELECT c From Catalogo c Where c.autore = :autore", Catalogo.class);
        query.setParameter("autore", autore);
        return query.getResultList();
    }

    public List<Catalogo> getElementoByTitolo(String partialTitle) {
        TypedQuery<Catalogo> query = em.createQuery("SELECT c FROM Catalogo c WHERE LOWER(c.titolo) LIKE LOWER(:partialTitle)", Catalogo.class);

        query.setParameter("partialTitle", "%" + partialTitle + "%");
        return query.getResultList();
    }

    public List<Catalogo> getElementoByTesseraUtente(long tesseraId) {
        TypedQuery<Catalogo> query = em.createQuery("SELECT c.catalogo From Prestito c Where c.utente.numeroTessera = :tesseraId AND c.dataRestituzioneEffettiva IS NULL", Catalogo.class);
        query.setParameter("tesseraId", tesseraId);
        return query.getResultList();
    }

    public List<Prestito> getPrestitoScadutoNonRestituito(LocalDate oggi) {
        TypedQuery<Prestito> query = em.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzioneEffettiva IS NULL AND p.dataRestituzionePrevista < :oggi", Prestito.class);
        query.setParameter("oggi", oggi);
        return query.getResultList();

    }
}

