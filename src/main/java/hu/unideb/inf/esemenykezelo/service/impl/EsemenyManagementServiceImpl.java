package hu.unideb.inf.esemenykezelo.service.impl;

import hu.unideb.inf.esemenykezelo.data.entity.EsemenyEntity;
import hu.unideb.inf.esemenykezelo.data.repository.EsemenyRepository;
import hu.unideb.inf.esemenykezelo.service.EsemenyManagementService;
import hu.unideb.inf.esemenykezelo.service.dto.EsemenyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EsemenyManagementServiceImpl implements EsemenyManagementService {

    @Autowired
    EsemenyRepository repo;

    @Override
    public EsemenyDto findById(Long id) {
        EsemenyEntity entity = repo.getReferenceById(id);
        EsemenyDto dto = new EsemenyDto();

        dto.setId(entity.getId());
        dto.setKezdes(entity.getKezdes());
        dto.setVeg(entity.getVeg());
        dto.setLeiras(entity.getLeiras());
        dto.setNev(entity.getNev());
        dto.setLetrehozo(entity.getLetrehozo());

        return dto;
    }

    @Override
    public List<EsemenyDto> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public EsemenyDto save(EsemenyDto semenyDto) {
        return null;
    }
}
