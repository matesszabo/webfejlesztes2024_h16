package hu.unideb.inf.esemenykezelo.controller;

import hu.unideb.inf.esemenykezelo.data.entity.EsemenyEntity;
import hu.unideb.inf.esemenykezelo.data.repository.EsemenyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/updateesemeny")
    public EsemenyEntity update(@RequestBody EsemenyEntity entity){
        if(entity.getId() > 0L){
            return repository.save(entity);
        }
        return null;
    }

}
