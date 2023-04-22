package pl.edu.wszib.springjpa.osoba;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Osoba {

    @Id
    @GeneratedValue
    private Integer id;
    private String imię;
    private String nazwisko;

    @OneToOne(mappedBy = "osoba")
    private Pracownik pracownik;

    @ManyToMany
    @JoinTable
    private List<Adres> adresy;

    public Pracownik getPracownik() {
        return pracownik;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }

    public List<Adres> getAdresy() {
        return adresy;
    }

    public void setAdresy(List<Adres> adresy) {
        this.adresy = adresy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImię() {
        return imię;
    }

    public void setImię(String imię) {
        this.imię = imię;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
}
