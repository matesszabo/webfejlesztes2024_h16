package hu.unideb.inf.esemenykezelo.service.impl;

import hu.unideb.inf.esemenykezelo.data.entity.FelhasznaloEntity;
import hu.unideb.inf.esemenykezelo.data.repository.FelhasznaloRepository;
import hu.unideb.inf.esemenykezelo.service.FelhasznaloAlapAdatService;
import hu.unideb.inf.esemenykezelo.service.dto.FelhasznaloAlapAdatDto;
import hu.unideb.inf.esemenykezelo.service.mapper.FelhasznaloAlapAdatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FelhasznaloAlapAdatServiceImpl implements FelhasznaloAlapAdatService {

    @Autowired
    FelhasznaloAlapAdatMapper mapper;

    @Autowired
    FelhasznaloRepository repo;

    @Override
    public FelhasznaloAlapAdatDto findById(Long id) {
        FelhasznaloEntity entity = repo.getReferenceById(id);
        FelhasznaloAlapAdatDto dto = mapper.felhasznaloEntityToAdatDto(entity);
        return dto;
    }

    @Override
    public List<FelhasznaloAlapAdatDto> findAll() {
        List<FelhasznaloEntity> entities = repo.findAll();

        return mapper.felhasznaloAlapAdatList(entities);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);

    }
}
