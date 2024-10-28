package hu.unideb.inf.esemenykezelo.controller;

import hu.unideb.inf.esemenykezelo.data.entity.EsemenyEntity;
import hu.unideb.inf.esemenykezelo.data.repository.EsemenyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController//json-t küld, json-t fogad
@RequestMapping("/api")
public class EsemenyController {

    @Autowired
    EsemenyRepository repository;

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/hw")
    public ResponseEntity<String> helloworld(){
        return new ResponseEntity<>("Hello, world!", HttpStatus.NOT_FOUND);
    }

    // localhost:8080/api/saveesemeny
    //CREATE
    @PostMapping("/saveesemeny")
    public EsemenyEntity save(@RequestBody EsemenyEntity entity){
        return repository.save(entity);
    }

    // localhost:8080/api/updateesemeny
    //UPDATE
    @PutMapping("/updateesemeny")
    public EsemenyEntity update(@RequestBody EsemenyEntity entity){
        if(entity.getId() > 0L){
            return repository.save(entity);
        }
        return null;
    }

    // localhost:8080/api/esemeny?id=1
    //DELETE
    @DeleteMapping("/esemeny")
    public void delete(@RequestParam Long id){
        repository.deleteById(id);
    }

    @GetMapping("/esemenyek")
    public List<EsemenyEntity> findAll(){
        return repository.findAll();
    }

    //localhost:8080/api/esemeny/napfogyatkozas
    @GetMapping("/esemeny/{nev}")
    public List<EsemenyEntity> findAllByNev(@PathVariable String nev){
        List<EsemenyEntity> szurt = new ArrayList<>();

        szurt = repository.findAll()
                .stream()
                .filter(x -> x.getNev().contains(nev))
                .toList();

        return szurt;
    }

    //localhost:8080/api/esemenybynev?nev=napfogyatkozas
    @GetMapping("/esemenybynev")
    public List<EsemenyEntity> findAllByNevRp(@RequestParam String nev){
        return repository.findAllByNevContains(nev);
    }

    //localhost:8080/api/filteresemeny?kezdo=2024-10-28&letrehozo=mancs
    //localhost:8080/api/filteresemeny?nev=csillag&veg=2024-11-02
    @GetMapping("/filteresemeny")
    public List<EsemenyEntity> filterEsemeny(@RequestParam(required = false) String nev,
                                             @RequestParam(required = false)@DateTimeFormat(pattern = "yyyy-MM-dd") Date kezdo,
                                             @RequestParam(required = false)@DateTimeFormat(pattern = "yyyy-MM-dd") Date veg,
                                             @RequestParam(required = false) String leiras,
                                             @RequestParam(required = false) String letrehozo){

        List<EsemenyEntity> szurt = new ArrayList<>();

        szurt = repository.findAll()
                .stream()
                .filter(x -> nev == null || x.getNev().equals(nev))
                .filter(x -> kezdo == null || x.getKezdes().after(kezdo))
                .filter(x -> veg == null || x.getVeg().before(veg))
                .filter(x -> leiras == null || x.getLeiras().contains(leiras))
                .filter(x -> letrehozo == null || x.getLetrehozo().equals(letrehozo))
                .toList();

        return szurt;
    }


}
