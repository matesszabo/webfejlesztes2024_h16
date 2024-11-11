package hu.unideb.inf.esemenykezelo.service;

import hu.unideb.inf.esemenykezelo.service.dto.BejelentkezesDto;
import hu.unideb.inf.esemenykezelo.service.dto.RegisztracioDto;

public interface AuthenticationService {

    public void regisztracio(RegisztracioDto dto);
    public void bejelentkezes(BejelentkezesDto dto);
}
