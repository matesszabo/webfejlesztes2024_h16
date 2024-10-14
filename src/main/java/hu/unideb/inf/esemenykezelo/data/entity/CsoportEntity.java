package hu.unideb.inf.esemenykezelo.data.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "csoport")
public class CsoportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "nev")
    private String nev;
    @Column(name = "tema")
    private String tema;

    public CsoportEntity() {
    }

    public CsoportEntity(long id, String nev, String tema) {
        this.id = id;
        this.nev = nev;
        this.tema = tema;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CsoportEntity that = (CsoportEntity) o;
        return id == that.id && Objects.equals(nev, that.nev) && Objects.equals(tema, that.tema);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nev, tema);
    }
}
