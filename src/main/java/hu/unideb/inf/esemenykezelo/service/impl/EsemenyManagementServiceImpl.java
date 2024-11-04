package hu.unideb.inf.esemenykezelo.service.impl;

import hu.unideb.inf.esemenykezelo.data.entity.EsemenyEntity;
import hu.unideb.inf.esemenykezelo.data.repository.EsemenyRepository;
import hu.unideb.inf.esemenykezelo.service.EsemenyManagementService;
import hu.unideb.inf.esemenykezelo.service.dto.EsemenyDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EsemenyManagementServiceImpl implements EsemenyManagementService {

    @Autowired
    EsemenyRepository repo;

    @Autowired
    ModelMapper mapper;

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
        List<EsemenyEntity> entities = repo.findAll();
        List<EsemenyDto> dtos = new ArrayList<>();

        dtos = mapper.map(entities, new TypeToken<List<EsemenyDto>>(){}.getType());
        return dtos;
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public EsemenyDto save(EsemenyDto esemenyDto) {
        /*return mapper.map(repo.save(mapper.map(esemenyDto,EsemenyEntity.class))
                , EsemenyDto.class);*/

        EsemenyEntity entity = mapper.map(esemenyDto, EsemenyEntity.class);
        entity = repo.save(entity);
        EsemenyDto dto = mapper.map(entity, EsemenyDto.class);

        return dto;
    }
}
