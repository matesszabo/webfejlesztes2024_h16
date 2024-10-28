package hu.unideb.inf.esemenykezelo.controller;

import hu.unideb.inf.esemenykezelo.data.entity.EsemenyEntity;
import hu.unideb.inf.esemenykezelo.data.repository.EsemenyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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


}
