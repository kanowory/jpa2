package pl.edu.wszib.springjpa.osoba;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Pracownik {

    @Id
    @GeneratedValue
    private Integer id;

    private String stanowisko;

    @OneToOne
    @JoinColumn
    private Osoba osoba;

    @OneToMany(mappedBy = "pracownik")
    private List<Obowiązek> obowiazki;

    public List<Obowiązek> getObowiazki() {
        return obowiazki;
    }

    public void setObowiazki(List<Obowiązek> obowiazki) {
        this.obowiazki = obowiazki;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public Osoba getOsoba() {
        return osoba;
    }

    public void setOsoba(Osoba osoba) {
        this.osoba = osoba;
    }
}
