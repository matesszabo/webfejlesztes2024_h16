package hu.unideb.inf.esemenykezelo.data.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Emlekezteto")
public class EmlekeztetoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "idopont")
    private Date idopont;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "esemeny_id", referencedColumnName = "id")
    private EsemenyEntity esemeny;

    public EmlekeztetoEntity() {
    }

    public EmlekeztetoEntity(long id, Date idopont) {
        this.id = id;
        this.idopont = idopont;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getIdopont() {
        return idopont;
    }

    public void setIdopont(Date idopont) {
        this.idopont = idopont;
    }

    public EsemenyEntity getEsemeny() {
        return esemeny;
    }

    public void setEsemeny(EsemenyEntity esemeny) {
        this.esemeny = esemeny;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmlekeztetoEntity that = (EmlekeztetoEntity) o;
        return id == that.id && Objects.equals(idopont, that.idopont);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idopont);
    }
}
