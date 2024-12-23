package hu.unideb.inf.esemenykezelo.controller;

import hu.unideb.inf.esemenykezelo.service.EsemenyManagementService;
import hu.unideb.inf.esemenykezelo.service.dto.EsemenyDto;
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

    @RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handleOptions(){
        return ResponseEntity.ok().build();
    }

    @Autowired
    EsemenyManagementService service;

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
    public EsemenyDto save(@RequestBody EsemenyDto dto){
        return service.save(dto);
    }

    // localhost:8080/api/updateesemeny
    //UPDATE
    @PutMapping("/updateesemeny")
    public EsemenyDto update(@RequestBody EsemenyDto dto){
        if(dto.getId() > 0L){
            return service.save(dto);
        }
        return null;
    }

    // localhost:8080/api/esemeny?id=1
    //DELETE
    @DeleteMapping("/esemeny")
    public void delete(@RequestParam Long id){
        service.deleteById(id);
    }

    @GetMapping("/esemenyek")
    public List<EsemenyDto> findAll(){
        return service.findAll();
    }

    //localhost:8080/api/esemeny/napfogyatkozas
    @GetMapping("/esemeny/{nev}")
    public List<EsemenyDto> findAllByNev(@PathVariable String nev){
        return service.findAllByNevKod(nev);
    }

    //localhost:8080/api/esemenybynev?nev=napfogyatkozas
    @GetMapping("/esemenybynev")
    public List<EsemenyDto> findAllByNevRp(@RequestParam String nev){
        return service.findAllByNevDb(nev);
    }

    //localhost:8080/api/filteresemeny?kezdo=2024-10-28&letrehozo=mancs
    //localhost:8080/api/filteresemeny?nev=csillag&veg=2024-11-02
    @GetMapping("/filteresemeny")
    public List<EsemenyDto> filterEsemeny(@RequestParam(required = false) String nev,
                                             @RequestParam(required = false)@DateTimeFormat(pattern = "yyyy-MM-dd") Date kezdo,
                                             @RequestParam(required = false)@DateTimeFormat(pattern = "yyyy-MM-dd") Date veg,
                                             @RequestParam(required = false) String leiras,
                                             @RequestParam(required = false) String letrehozo){
        return service.findAllByAny(nev,kezdo,veg,leiras,letrehozo);
    }


}
