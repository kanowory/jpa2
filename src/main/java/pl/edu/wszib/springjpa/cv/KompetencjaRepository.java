package pl.edu.wszib.springjpa.cv;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KompetencjaRepository extends JpaRepository<Kompetencja, Integer> {
}
