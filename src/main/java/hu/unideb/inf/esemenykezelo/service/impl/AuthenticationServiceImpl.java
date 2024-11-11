package hu.unideb.inf.esemenykezelo.service.impl;

import hu.unideb.inf.esemenykezelo.data.entity.FelhasznaloEntity;
import hu.unideb.inf.esemenykezelo.data.entity.JogosultsagEntity;
import hu.unideb.inf.esemenykezelo.data.repository.FelhasznaloRepository;
import hu.unideb.inf.esemenykezelo.data.repository.JogosultsagRepository;
import hu.unideb.inf.esemenykezelo.service.AuthenticationService;
import hu.unideb.inf.esemenykezelo.service.dto.BejelentkezesDto;
import hu.unideb.inf.esemenykezelo.service.dto.RegisztracioDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    FelhasznaloRepository felhasznaloRepository;

    @Autowired
    JogosultsagRepository jogRepo;

    @Override
    public void regisztracio(RegisztracioDto dto) {
        FelhasznaloEntity entity = modelMapper.map(dto, FelhasznaloEntity.class);
        entity.setJelszo(passwordEncoder.encode(entity.getJelszo()));

        JogosultsagEntity jog = jogRepo.findByNev("FELHASZNALO");
        if (jog != null) {
            entity.setJogosultsag(jog);
        } else {
            jog = new JogosultsagEntity();
            jog.setNev("FELHASZNALO");
            jog = jogRepo.save(jog);

            entity.setJogosultsag(jog);
        }

        felhasznaloRepository.save(entity);
    }

    @Override
    public void bejelentkezes(BejelentkezesDto dto) {

    }
}
