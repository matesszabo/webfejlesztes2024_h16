package hu.unideb.inf.esemenykezelo.service.dto;

import jakarta.persistence.Column;

import java.util.Date;
import java.util.Objects;

public class RegisztracioDto {

    private String email;
    private String jelszo;
    private String nev;
    private Date szuletesiDatum;

    public RegisztracioDto() {
    }

    public RegisztracioDto(String email, String jelszo, String nev, Date szuletesiDatum) {
        this.email = email;
        this.jelszo = jelszo;
        this.nev = nev;
        this.szuletesiDatum = szuletesiDatum;
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
        RegisztracioDto that = (RegisztracioDto) o;
        return Objects.equals(email, that.email) && Objects.equals(jelszo, that.jelszo) && Objects.equals(nev, that.nev) && Objects.equals(szuletesiDatum, that.szuletesiDatum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, jelszo, nev, szuletesiDatum);
    }
}
