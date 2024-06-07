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
//        ------RICERCA PER ISBM TRAMITE METODO E QUERY----
        Catalogo catFormDb = cd.findByIsbm(52);
        System.out.println("ricerca elemento per ISBM");
        cd.getElementoByIsbm(102).forEach(System.out::println);
        //        ------CANCELLAZIONE CON ISBM TRAMITE QUERY----
//        cd.findElementoByIdAndDelete(2);
//        ------RICERCA PER ISBM TRAMITE QUERY----
        System.out.println("ricerca elemento per anno di pubblicazione");
        cd.getElementoByAnnoPubblicazione(2020).forEach(System.out::println);
//        ------RICERCA PER AUTORE TRAMITE QUERY----
        System.out.println("ricerca elemento per autore");
        cd.getElementoByAutore("Sanford Champlin").forEach(System.out::println);
        //        ------RICERCA PER TIOLO O PARTE DI TITOLO TRAMITE QUERY----
        System.out.println("ricerca per titolo");
        cd.getElementoByTitolo("Pale Kings and Princes").forEach(System.out::println);
        cd.getElementoByTitolo("Kings").forEach(System.out::println);
        //        ------RICERCA ELEMENTO PER TESSERA E NON  ANCORA RESTITUITO ----
        System.out.println("ricerca elemento per numero tessera e non restituito");
        cd.getElementoByTesseraUtente(152).forEach(System.out::println);
//        ------RICERCA ELEMENTO PER TESSERA E NON  ANCORA RESTITUITO ----
        cd.getPrestitoScadutoNonRestituito(LocalDate.now()).forEach(System.out::println);

        Utente utenteFromDb = ud.findById(152);


//      ------------- COSTRUTTORE PER PRESTITO------------
        Prestito prestito = new Prestito(utenteFromDb, catFormDb, LocalDate.now().minusDays(125), LocalDate.now().minusDays(30));

//        pd.save(prestito);


    }


}
