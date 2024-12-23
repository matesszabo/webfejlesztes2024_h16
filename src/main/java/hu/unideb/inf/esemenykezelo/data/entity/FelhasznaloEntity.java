package hu.unideb.inf.esemenykezelo.data.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Felhasznalo")
public class FelhasznaloEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "email")
    private String email;
    @Column(name = "jelszo")
    private String jelszo;
    @Column(name = "nev")
    private String nev;
    @Column(name = "szuletesiDatum")
    private Date szuletesiDatum;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable( name =  "felhasznalo_esemenyek",
            joinColumns = {@JoinColumn(name = "felhasznalo_id")},
            inverseJoinColumns = {@JoinColumn(name = "esemeny_id")}
    )
    private List<EsemenyEntity> esemenyek;

    @ManyToOne
    private JogosultsagEntity jogosultsag;

    public FelhasznaloEntity() {
    }

    public FelhasznaloEntity(long id, String email, String jelszo, String nev, Date szuletesiDatum) {
        this.id = id;
        this.email = email;
        this.jelszo = jelszo;
        this.nev = nev;
        this.szuletesiDatum = szuletesiDatum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<EsemenyEntity> getEsemenyek() {
        return esemenyek;
    }

    public void setEsemenyek(List<EsemenyEntity> esemenyek) {
        this.esemenyek = esemenyek;
    }

    public JogosultsagEntity getJogosultsag() {
        return jogosultsag;
    }

    public void setJogosultsag(JogosultsagEntity jogosultsag) {
        this.jogosultsag = jogosultsag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FelhasznaloEntity that = (FelhasznaloEntity) o;
        return id == that.id && Objects.equals(email, that.email) && Objects.equals(jelszo, that.jelszo) && Objects.equals(nev, that.nev) && Objects.equals(szuletesiDatum, that.szuletesiDatum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, jelszo, nev, szuletesiDatum);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(jogosultsag);
    }

    @Override
    public String getPassword() {
        return jelszo;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
