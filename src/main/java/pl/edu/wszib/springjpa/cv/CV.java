package pl.edu.wszib.springjpa.cv;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
@Entity
public class CV {
  @Id
  @GeneratedValue
  private Integer id;
  private String imie;
  private String nazwisko;
  private String dataUrodzenia;
  @Lob
  private byte[] zdjecie;
  @OneToMany(mappedBy = "cv")
  private List<Praca> doswiadczenie;
  @OneToMany(mappedBy = "cv")
  private List<Kompetencja> kompetencje;
  @CreationTimestamp
  private Instant createdAt;
  @UpdateTimestamp
  private Instant updatedAt;

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

  public String getNazwisko() {
    return nazwisko;
  }

  public void setNazwisko(String nazwisko) {
    this.nazwisko = nazwisko;
  }

  public String getDataUrodzenia() {
    return dataUrodzenia;
  }

  public void setDataUrodzenia(String dataUrodzenia) {
    this.dataUrodzenia = dataUrodzenia;
  }

  public byte[] getZdjecie() {
    return zdjecie;
  }

  public void setZdjecie(byte[] zdjecie) {
    this.zdjecie = zdjecie;
  }

  public List<Praca> getDoswiadczenie() {
    return doswiadczenie;
  }

  public void setDoswiadczenie(List<Praca> doswiadczenie) {
    this.doswiadczenie = doswiadczenie;
  }

  public List<Kompetencja> getKompetencje() {
    return kompetencje;
  }

  public void setKompetencje(List<Kompetencja> kompetencje) {
    this.kompetencje = kompetencje;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }
}
