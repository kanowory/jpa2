package pl.edu.wszib.springjpa.osoba;

import javax.persistence.*;

@Entity
@Table
public class Obowiązek {

    @Id
    @GeneratedValue
    private Integer id;

    private String nazwa;

    @ManyToOne
    @JoinColumn
    private Pracownik pracownik;

    public Pracownik getPracownik() {
        return pracownik;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
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
}
