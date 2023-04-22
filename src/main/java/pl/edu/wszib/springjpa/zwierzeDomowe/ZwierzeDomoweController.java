package pl.edu.wszib.springjpa.zwierzeDomowe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/zwierze-domowe")
public class ZwierzeDomoweController {

    @Autowired
    private ZwierzeDomoweRepository zwierzeDomoweRepository;

    @GetMapping("{id}")
    public ZwierzeDomowe get(@PathVariable Integer id){
        return zwierzeDomoweRepository.findById(id).get();
    }

    @PostMapping
    public ZwierzeDomowe create (@RequestBody ZwierzeDomowe zwierzeDomowe){
        return zwierzeDomoweRepository.save(zwierzeDomowe);
    }
}
