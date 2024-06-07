package giovannighirardelli.dao;

import giovannighirardelli.entities.Catalogo;
import giovannighirardelli.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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

    public Catalogo findById(long catalogoId) {
        Catalogo catalogo = em.find(Catalogo.class, catalogoId);
        if (catalogo == null) throw new NotFoundException(catalogoId);
        return catalogo;
    }
}
