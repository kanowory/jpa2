package pl.edu.wszib.springjpa.galeria;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Obraz {
    @Lob
    public byte[] zawartosc;

    @Id
    public String nazwa;

    public String mimeType;
}
