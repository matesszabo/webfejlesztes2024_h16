package hu.unideb.inf.esemenykezelo.service.mapper;

import hu.unideb.inf.esemenykezelo.data.entity.FelhasznaloEntity;
import hu.unideb.inf.esemenykezelo.service.dto.FelhasznaloAlapAdatDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FelhasznaloAlapAdatMapper {

    @Mapping(source = "id", target = "id")
    FelhasznaloAlapAdatDto felhasznaloEntityToAdatDto(FelhasznaloEntity entity);
    List<FelhasznaloAlapAdatDto> felhasznaloAlapAdatList(List<FelhasznaloEntity> entities);

    FelhasznaloEntity felhasznaloAdatToEntity(FelhasznaloAlapAdatDto adat);
    List<FelhasznaloEntity> felhasznaloAdatListToEntityList(List<FelhasznaloAlapAdatDto> entities);



}
