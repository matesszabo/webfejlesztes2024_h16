package hu.unideb.inf.esemenykezelo.data.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Hely")
public class HelyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "nev")
    private String nev;

    public HelyEntity() {
    }

    public HelyEntity(long id, String nev) {
        this.id = id;
        this.nev = nev;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HelyEntity that = (HelyEntity) o;
        return id == that.id && Objects.equals(nev, that.nev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nev);
    }
}
