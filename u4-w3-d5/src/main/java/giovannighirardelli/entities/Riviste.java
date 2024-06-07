package giovannighirardelli.entities;

import giovannighirardelli.enums.Periodicità;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@DiscriminatorValue("rivista")
public class Riviste extends Catalogo {
    @Enumerated(EnumType.STRING)
    private Periodicità periodicità;


    public Riviste(String titolo, Integer annoPubbl, Integer numPage, Periodicità periodicità) {
        super(titolo, annoPubbl, numPage);
        this.periodicità = periodicità;
    }

    public Riviste() {
    }

    public Riviste(Periodicità periodicità) {
        this.periodicità = periodicità;
    }

    public Periodicità getPeriodicità() {
        return periodicità;
    }

    public void setPeriodicità(Periodicità periodicità) {
        this.periodicità = periodicità;
    }

    @Override
    public String toString() {
        return "Riviste{" +
                "periodicità=" + periodicità +
                ", codiceISBN=" + codiceISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubbl=" + annoPubbl +
                ", numPage=" + numPage +
                '}';
    }


}
