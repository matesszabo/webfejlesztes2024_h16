package hu.unideb.inf.esemenykezelo.data.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "esemeny")
public class EsemenyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "nev", nullable = false)
    private String nev;
    @Column(name = "kezdo_ip", nullable = false)
    private Date kezdes;
    @Column(name = "veg_ip", nullable = false)
    private Date veg;
    @Column(name = "leiras")
    private String leiras;
    @Column(name = "letrehozo")
    private String letrehozo;

    public EsemenyEntity() {
    }

    public EsemenyEntity(long id, String nev, Date kezdes, Date veg, String leiras, String letrehozo) {
        this.id = id;
        this.nev = nev;
        this.kezdes = kezdes;
        this.veg = veg;
        this.leiras = leiras;
        this.letrehozo = letrehozo;
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

    public Date getKezdes() {
        return kezdes;
    }

    public void setKezdes(Date kezdes) {
        this.kezdes = kezdes;
    }

    public Date getVeg() {
        return veg;
    }

    public void setVeg(Date veg) {
        this.veg = veg;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public String getLetrehozo() {
        return letrehozo;
    }

    public void setLetrehozo(String letrehozo) {
        this.letrehozo = letrehozo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EsemenyEntity that = (EsemenyEntity) o;
        return id == that.id && Objects.equals(nev, that.nev) && Objects.equals(kezdes, that.kezdes) && Objects.equals(veg, that.veg) && Objects.equals(leiras, that.leiras) && Objects.equals(letrehozo, that.letrehozo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nev, kezdes, veg, leiras, letrehozo);
    }
}
