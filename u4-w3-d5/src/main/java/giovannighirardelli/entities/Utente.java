package giovannighirardelli.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "utente")
public class Utente {
    @Id
    @GeneratedValue
    @Column(name = "numero_tessera")
    private long numeroTessera;
    private String nome;
    private String cognome;
    @Column(name = "data_nascita")
    private LocalDate dataNascita;


    public Utente() {
    }

    public Utente(String nome, String cognome, LocalDate dataNascita) {

        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
    }

    public long getNumeroTessera() {
        return numeroTessera;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "numeroTessera=" + numeroTessera +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
                '}';
    }
}
