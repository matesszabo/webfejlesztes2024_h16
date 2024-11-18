package hu.unideb.inf.esemenykezelo.controller;

import hu.unideb.inf.esemenykezelo.service.AuthenticationService;
import hu.unideb.inf.esemenykezelo.service.dto.BejelentkezesDto;
import hu.unideb.inf.esemenykezelo.service.dto.RegisztracioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationService service;

    @PostMapping("/regisztracio")
    public void regisztracio(@RequestBody RegisztracioDto dto){
        service.regisztracio(dto);
    }

    @PostMapping("/bejelentkezes")
    public String bejelentkezes(@RequestBody BejelentkezesDto dto){
        return service.bejelentkezes(dto);
    }

    @GetMapping("/vt")
    public String vt(){
        return Thread.currentThread().toString();
    }

}
