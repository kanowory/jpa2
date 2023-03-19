package pl.edu.wszib.springjpa.zwierze;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zwierze")
public class ZwierzeController {

    @Autowired
    private ZwierzeRepository repository;

    @GetMapping
    public List<Zwierze> list(@RequestParam(required = false) String gatunek){
        if(gatunek == null) {
            return repository.findAll();
        }
        return repository.findAllByGatunek(gatunek);
    }

    @GetMapping("/{id}")
    public Zwierze get(@PathVariable Integer id){
        return repository.findById(id).get();
    }

    @PostMapping
    public Zwierze create(@RequestBody Zwierze zwierze) {
        zwierze.setId(null);
        return repository.save(zwierze);
    }

    @PutMapping
    public Zwierze update(@RequestBody Zwierze zwierze) {
        Zwierze istniejace = get(zwierze.getId());
        istniejace.setGatunek(zwierze.getGatunek());
        istniejace.setNazwa(zwierze.getNazwa());
        istniejace.setWiek(zwierze.getWiek());
        return  repository.save(istniejace);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        repository.deleteById(id);
    }

}
