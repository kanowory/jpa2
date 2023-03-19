package pl.edu.wszib.springjpa.todo;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
@Entity
public class ToDo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String zadanie;
  @Enumerated(EnumType.STRING)
  private ToDoStatus status;
  private Instant termin;
  @CreationTimestamp
  private Instant createdAt;
  @UpdateTimestamp
  private Instant updatedAt;

  public Integer getId() {
    return id;
  }

  public void setId(Integer integer) {
    this.id = integer;
  }

  public String getZadanie() {
    return zadanie;
  }

  public void setZadanie(String zadanie) {
    this.zadanie = zadanie;
  }

  public ToDoStatus getStatus() {
    return status;
  }

  public void setStatus(ToDoStatus status) {
    this.status = status;
  }

  public Instant getTermin() {
    return termin;
  }

  public void setTermin(Instant termin) {
    this.termin = termin;
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
