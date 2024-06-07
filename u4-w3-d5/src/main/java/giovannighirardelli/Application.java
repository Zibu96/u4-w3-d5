package giovannighirardelli;

import com.github.javafaker.Faker;
import giovannighirardelli.dao.CatalogoDAO;
import giovannighirardelli.dao.PrestitoDAO;
import giovannighirardelli.dao.UtenteDAO;
import giovannighirardelli.entities.*;
import giovannighirardelli.enums.Periodicità;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogo");

    public static void main(String[] args) {
        System.out.println("Hello World!");
        EntityManager em = emf.createEntityManager();
        CatalogoDAO cd = new CatalogoDAO(em);
        UtenteDAO ud = new UtenteDAO(em);
        PrestitoDAO pd = new PrestitoDAO(em);


//      -------------FAKER E COSTRUTTORE PER LIBRI E RIVISTE------------
        String fakeTitolo = new Faker().book().title();
        String fakeAutore = new Faker().book().author();


        Libri libro1 = new Libri(fakeTitolo, 2008, 230, fakeAutore, "Biografia");
        Riviste rivista = new Riviste(fakeTitolo, 2023, 216, Periodicità.SEMESTRALE);
//        cd.save(rivista);

        //      -------------FAKER E COSTRUTTORE PER UTENTE------------
        String fakeNome = new Faker().pokemon().name();
        String fakeCognome = new Faker().elderScrolls().lastName();


        Utente utente = new Utente(fakeNome, fakeCognome, LocalDate.of(1998, 5, 8));

//        ud.save(utente);

        Catalogo catFormDb = cd.findById(102);
        Utente utenteFromDb = ud.findById(152);


//      ------------- COSTRUTTORE PER PRESTITO------------
        Prestito prestito = new Prestito(utenteFromDb, catFormDb, LocalDate.now().minusDays(85), LocalDate.now().minusDays(42));

//        pd.save(prestito);


    }


}
