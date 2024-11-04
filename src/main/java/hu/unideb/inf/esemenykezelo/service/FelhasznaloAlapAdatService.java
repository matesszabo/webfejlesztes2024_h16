package hu.unideb.inf.esemenykezelo.service;

import hu.unideb.inf.esemenykezelo.service.dto.FelhasznaloAlapAdatDto;

import java.util.List;

public interface FelhasznaloAlapAdatService {

    FelhasznaloAlapAdatDto findById(Long id);
    List<FelhasznaloAlapAdatDto> findAll();
    void deleteById(Long id);
}
