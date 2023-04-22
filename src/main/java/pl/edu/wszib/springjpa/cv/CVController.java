package pl.edu.wszib.springjpa.cv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/moje-cv")
public class CVController {

    @Autowired
    private CVRepository cvRepository;

    @Autowired
    private KompetencjaRepository kompetencjaRepository;

    @Autowired
    private PracaRepository pracaRepository;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("cvs", cvRepository.findAll());
        return "list-cv";
    }

    @GetMapping("/dodaj")
    public String dodaj(Model model) {
        CV nowy = new CV();
        model.addAttribute("noweCV", nowy);
        return "dodaj-cv";
    }

    @PostMapping("/dodaj")
    public String dodajPost(CV cv, @RequestParam("obraz") MultipartFile obraz) throws IOException {
        cv.setZdjecie(obraz.getBytes());
        cvRepository.save(cv);
        return "redirect:/moje-cv";
    }

    @GetMapping( value="/obrazek/{id}", produces="image/*")
    @ResponseBody
    public byte[] obrazek(@PathVariable Integer id) {
        return cvRepository.findById(id)
                .get()
                .getZdjecie();
    }

    @GetMapping("/widok/{id}")
    public String widok(Model model, @PathVariable Integer id){
        model.addAttribute("cv", cvRepository.findById(id).get());
        return "widok-cv";
    }

    @GetMapping("/edytuj/{id}")
    public String edytuj(Model model, @PathVariable Integer id){
        model.addAttribute("cv", cvRepository.findById(id).get());
        Kompetencja nowaKompetencja = new Kompetencja();
        model.addAttribute("nowaKompetencja", nowaKompetencja);
        model.addAttribute("rodzaje", KompetencjaRodzaj.values());
        Praca nowaPraca = new Praca();
        model.addAttribute("nowaPraca", nowaPraca);
        return "edytuj-cv";
    }

    @PostMapping("/edytuj/{id}")
    public String edytujPost(@PathVariable Integer id, CV cv, @RequestParam("obraz") MultipartFile obraz) throws IOException {
        CV istniejacy = cvRepository.findById(id).get();
        istniejacy.setDataUrodzenia(cv.getDataUrodzenia());
        istniejacy.setImie(cv.getImie());
        istniejacy.setNazwisko(cv.getNazwisko());

        if(!obraz.isEmpty()){
            istniejacy.setZdjecie(obraz.getBytes());
        }

        cvRepository.save(istniejacy);
        return "redirect:/moje-cv/widok/" + id;
    }

    @PostMapping("/edytuj/{cvId}/kompetencja")
    public String dodajKompetencje( Kompetencja kompetencja, @PathVariable Integer cvId) {
        CV istnieje = cvRepository.findById(cvId).get();
        kompetencja.setCv(istnieje);
        kompetencjaRepository.save(kompetencja);
        return "redirect:/moje-cv/edytuj/" + cvId;
    }

    @GetMapping("/edytuj/{cvId}/kompetencja/{id}/usun")
    public String usunKompetencje(@PathVariable Integer cvId, @PathVariable Integer id) {
        kompetencjaRepository.deleteById(id);
        return "redirect:/moje-cv/edytuj/" + cvId;
    }

    @PostMapping("/edytuj/{cvId}/praca")
    public String dodajPrace( Praca praca, @PathVariable Integer cvId) {
        CV istnieje = cvRepository.findById(cvId).get();
        praca.setCv(istnieje);
        pracaRepository.save(praca);
        return "redirect:/moje-cv/edytuj/" + cvId;
    }

    @GetMapping("/edytuj/{cvId}/praca/{id}/usun")
    public String usunPrace(@PathVariable Integer cvId, @PathVariable Integer id) {
        pracaRepository.deleteById(id);
        return "redirect:/moje-cv/edytuj/" + cvId;
    }


}
