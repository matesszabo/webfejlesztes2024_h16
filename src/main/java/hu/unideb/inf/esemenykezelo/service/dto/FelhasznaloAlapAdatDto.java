package hu.unideb.inf.esemenykezelo.service.dto;

import jakarta.persistence.Column;

import java.util.Date;
import java.util.Objects;

public class FelhasznaloAlapAdatDto {

    private Long id;
    private String email;
    private String jelszo;
    private String nev;
    private Date szuletesiDatum;

    public FelhasznaloAlapAdatDto() {
    }

    public FelhasznaloAlapAdatDto(Long id, String email, String jelszo, String nev, Date szuletesiDatum) {
        this.id = id;
        this.email = email;
        this.jelszo = jelszo;
        this.nev = nev;
        this.szuletesiDatum = szuletesiDatum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJelszo() {
        return jelszo;
    }

    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Date getSzuletesiDatum() {
        return szuletesiDatum;
    }

    public void setSzuletesiDatum(Date szuletesiDatum) {
        this.szuletesiDatum = szuletesiDatum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FelhasznaloAlapAdatDto that = (FelhasznaloAlapAdatDto) o;
        return Objects.equals(id, that.id) && Objects.equals(email, that.email) && Objects.equals(jelszo, that.jelszo) && Objects.equals(nev, that.nev) && Objects.equals(szuletesiDatum, that.szuletesiDatum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, jelszo, nev, szuletesiDatum);
    }
}
