package hu.unideb.inf.esemenykezelo.service.mapper;

import hu.unideb.inf.esemenykezelo.data.entity.FelhasznaloEntity;
import hu.unideb.inf.esemenykezelo.service.dto.FelhasznaloAlapAdatDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface FelhasznaloEntityMapper {
    FelhasznaloEntity toEntity(FelhasznaloAlapAdatDto felhasznaloAlapAdatDto);

    FelhasznaloAlapAdatDto toDto(FelhasznaloEntity felhasznaloEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FelhasznaloEntity partialUpdate(FelhasznaloAlapAdatDto felhasznaloAlapAdatDto, @MappingTarget FelhasznaloEntity felhasznaloEntity);
}