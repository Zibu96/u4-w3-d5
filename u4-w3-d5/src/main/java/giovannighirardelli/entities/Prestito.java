package giovannighirardelli.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("prestito")
public class Prestito {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name = "id_utente", nullable = false)
    private Utente utente;
    @ManyToOne
    @JoinColumn(name = "id_catalogo", nullable = false)
    private Catalogo catalogo;
    @Column(name = "data_inizio_prestito")
    private LocalDate dataInizioPrestito;
    @Column(name = "data_restituzione_prevista")
    private LocalDate dataRestituzionePrevista;
    @Column(name = "data_restituzione_effettiva")
    private LocalDate dataRestituzioneEffettiva;


    public Prestito() {
    }

    public Prestito(Utente utente, Catalogo catalogo, LocalDate dataInizioPrestito, LocalDate dataRestituzioneEffettiva) {
        this.utente = utente;
        this.catalogo = catalogo;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = dataInizioPrestito.plusDays(30);
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    public long getId() {
        return id;
    }


    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataRestituzionePrevista;
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", utente=" + utente +
                ", catalogo=" + catalogo +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                '}';
    }
}
