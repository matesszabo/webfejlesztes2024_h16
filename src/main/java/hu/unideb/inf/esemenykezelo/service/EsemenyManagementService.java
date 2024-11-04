package hu.unideb.inf.esemenykezelo.service;

import hu.unideb.inf.esemenykezelo.service.dto.EsemenyDto;

import java.util.List;

public interface EsemenyManagementService {

    EsemenyDto findById(Long id);
    List<EsemenyDto> findAll();
    void deleteById(Long id);
    EsemenyDto save(EsemenyDto esemenyDto);
}
