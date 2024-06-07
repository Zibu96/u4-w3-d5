package giovannighirardelli.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "catalogo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "libreria")

public abstract class Catalogo {
    @Id
    @GeneratedValue
    @Column(name = "codice_isbn")
    protected Long codiceISBN;
    protected String titolo;
    @Column(name = "anno_pubblicazione")
    protected Integer annoPubbl;
    @Column(name = "numero_pagine")
    protected Integer numPage;

    public Catalogo() {
    }


    public Catalogo(String titolo, Integer annoPubbl, Integer numPage) {


        this.titolo = titolo;
        this.annoPubbl = annoPubbl;
        this.numPage = numPage;

    }


    public Long getCodiceISBN() {
        return codiceISBN;
    }

    public void setCodiceISBN(Long codiceISBN) {
        this.codiceISBN = codiceISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Integer getAnnoPubbl() {
        return annoPubbl;
    }

    public void setAnnoPubbl(Integer annoPubbl) {
        this.annoPubbl = annoPubbl;
    }

    public Integer getNumPage() {
        return numPage;
    }

    public void setNumPage(Integer numPage) {
        this.numPage = numPage;
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "codiceISBN=" + codiceISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubbl=" + annoPubbl +
                ", numPage=" + numPage +
                '}';
    }


}
