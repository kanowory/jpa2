package pl.edu.wszib.springjpa.cv;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
@Entity
public class Kompetencja {

  @Id
  @GeneratedValue
  private Integer id;
  @Enumerated(EnumType.STRING)
  private KompetencjaRodzaj rodzaj;
  private String nazwa;
  private Integer stopien;

  @ManyToOne
  @JoinColumn
  private CV cv;
  @CreationTimestamp
  private Instant createdAt;
  @UpdateTimestamp
  private Instant updatedAt;

  public CV getCv() {
    return cv;
  }

  public void setCv(CV cv) {
    this.cv = cv;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public KompetencjaRodzaj getRodzaj() {
    return rodzaj;
  }

  public void setRodzaj(KompetencjaRodzaj rodzaj) {
    this.rodzaj = rodzaj;
  }

  public String getNazwa() {
    return nazwa;
  }

  public void setNazwa(String nazwa) {
    this.nazwa = nazwa;
  }

  public Integer getStopien() {
    return stopien;
  }

  public void setStopien(Integer stopien) {
    this.stopien = stopien;
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
