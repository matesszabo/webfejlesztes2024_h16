package hu.unideb.inf.esemenykezelo.controller;

import hu.unideb.inf.esemenykezelo.service.AuthenticationService;
import hu.unideb.inf.esemenykezelo.service.dto.BejelentkezesDto;
import hu.unideb.inf.esemenykezelo.service.dto.RegisztracioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
