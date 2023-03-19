package pl.edu.wszib.springjpa.zwierze;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ZwierzeRepository extends JpaRepository<Zwierze, Integer> {

    List<Zwierze> findAllByGatunek(String gatunek);

}
