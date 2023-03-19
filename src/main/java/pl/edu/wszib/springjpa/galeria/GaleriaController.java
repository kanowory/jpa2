package pl.edu.wszib.springjpa.galeria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/galeria")
public class GaleriaController {

    @Autowired
    private ObrazRepository obrazRepository;

    @GetMapping
    public String galeria(Model model, @RequestParam(required = false) String mimeType) {
        if(mimeType == null) {
            model.addAttribute("obrazy", obrazRepository.findAll());
        } else {
            model.addAttribute("obrazy", obrazRepository.findAllByMimeType(mimeType));
        }

        return "galeria";
    }

    @PostMapping
    public String wrzuc(@RequestParam("obraz")MultipartFile file) throws IOException {
       if(file.isEmpty()){
           return "redirect:/galeria";
       }
        Obraz nowy = new Obraz();
        nowy.nazwa = file.getOriginalFilename();
        nowy.zawartosc = file.getBytes();
        nowy.mimeType = file.getContentType();
        obrazRepository.save(nowy);
        return "redirect:/galeria";
    }

    @GetMapping("/usun/{nazwa}")
    public String usun(@PathVariable String nazwa) {
        obrazRepository.deleteById(nazwa);
        return "redirect:/galeria";
    }

    @GetMapping("/{nazwa}")
    @ResponseBody
    public ResponseEntity<byte[]> zawartosc(@PathVariable String nazwa) {
        Obraz obraz = obrazRepository.findById(nazwa).get();

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.parseMediaType(obraz.mimeType))
                .body(obraz.zawartosc);
    }


}
