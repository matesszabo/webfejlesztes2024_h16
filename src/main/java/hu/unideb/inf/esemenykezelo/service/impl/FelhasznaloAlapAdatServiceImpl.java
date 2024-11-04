package hu.unideb.inf.esemenykezelo.service.impl;

import hu.unideb.inf.esemenykezelo.service.FelhasznaloAlapAdatService;
import hu.unideb.inf.esemenykezelo.service.dto.FelhasznaloAlapAdatDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FelhasznaloAlapAdatServiceImpl implements FelhasznaloAlapAdatService {
    @Override
    public FelhasznaloAlapAdatDto findById(Long id) {
        return null;
    }

    @Override
    public List<FelhasznaloAlapAdatDto> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(Long id) {

    }
}
