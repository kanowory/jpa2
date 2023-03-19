package pl.edu.wszib.springjpa.zwierze;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Zwierze {

    enum Plec {
        SAMICA,
        SAMIEC,
        INNE
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nazwa;
    private Integer wiek;
    private String gatunek;
    private LocalDateTime zapisane;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;
    private Boolean albinos;
    @Enumerated(EnumType.STRING)
    private Plec plec;

    @Transient
    private boolean test = false;


    public Plec getPlec() {
        return plec;
    }

    public void setPlec(Plec plec) {
        this.plec = plec;
    }

    public Boolean getAlbinos() {
        return albinos;
    }

    public void setAlbinos(Boolean albinos) {
        this.albinos = albinos;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public LocalDateTime getZapisane() {
        return zapisane;
    }

    public void setZapisane(LocalDateTime zapisane) {
        this.zapisane = zapisane;
    }

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Integer getWiek() {
        return wiek;
    }

    public void setWiek(Integer wiek) {
        this.wiek = wiek;
    }
}
