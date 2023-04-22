package pl.edu.wszib.springjpa.zwierzeDomowe;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Gatunek {

    @Id
    @GeneratedValue
    private Integer id;

    private String nazwa;

    @OneToMany(mappedBy = "gatunek")
    @JsonIgnore
    private List<ZwierzeDomowe> zwierzeDomoweList;

    public List<ZwierzeDomowe> getZwierzeDomoweList() {
        return zwierzeDomoweList;
    }

    public void setZwierzeDomoweList(List<ZwierzeDomowe> zwierzeDomoweList) {
        this.zwierzeDomoweList = zwierzeDomoweList;
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
