package pl.edu.wszib.springjpa.zwierzeDomowe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZwierzeDomoweRepository extends JpaRepository<ZwierzeDomowe, Integer> {
}
