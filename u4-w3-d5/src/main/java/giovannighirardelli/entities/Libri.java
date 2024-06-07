package giovannighirardelli.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("libro")
public class Libri extends Catalogo {
    private String autore;
    private String genere;

    public Libri() {
    }

    public Libri(String titolo, Integer annoPubbl, Integer numPage, String autore, String genere) {
        super(titolo, annoPubbl, numPage);
        this.autore = autore;
        this.genere = genere;
    }


    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libri{" +
                "genere='" + genere + '\'' +
                ", autore='" + autore + '\'' +
                ", codiceISBN=" + codiceISBN +
                ", titolo='" + titolo + '\'' +
                ", numPage=" + numPage +
                ", annoPubbl=" + annoPubbl +
                '}';
    }
}
