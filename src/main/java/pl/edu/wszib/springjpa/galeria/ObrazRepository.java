package pl.edu.wszib.springjpa.galeria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface ObrazRepository extends JpaRepository<Obraz, String> {

    List<Obraz> findAllByMimeType(String mimeType);

    @Query("select o.mimeType from Obraz o")
    Set<String> mimeTypes();

}
