package pl.edu.wszib.springjpa.zwierzeDomowe;

import javax.persistence.*;

@Entity
@Table
public class ZwierzeDomowe {

    @Id
    @GeneratedValue
    private Integer id;

    private String imie;

    @ManyToOne
    @JoinColumn
    private Gatunek gatunek;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public Gatunek getGatunek() {
        return gatunek;
    }

    public void setGatunek(Gatunek gatunek) {
        this.gatunek = gatunek;
    }
}
