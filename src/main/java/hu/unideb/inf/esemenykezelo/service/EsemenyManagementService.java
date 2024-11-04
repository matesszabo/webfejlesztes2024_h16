package hu.unideb.inf.esemenykezelo.service;

import hu.unideb.inf.esemenykezelo.service.dto.EsemenyDto;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

public interface EsemenyManagementService {

    EsemenyDto findById(Long id);
    List<EsemenyDto> findAll();
    void deleteById(Long id);
    EsemenyDto save(EsemenyDto esemenyDto);

    List<EsemenyDto> findAllByNevKod(String nev);
    List<EsemenyDto> findAllByNevDb(String nev);
    List<EsemenyDto> findAllByAny(String nev,
                                  Date kezdo,
                                  Date veg,
                                  String leiras,
                                  String letrehozo);

}
