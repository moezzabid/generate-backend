package org.number.mapper;

import org.mapstruct.Mapper;
import org.number.dto.NumberingCriteriaDTO;
import org.number.entity.NumberingCriteria;

@Mapper(componentModel = "spring")
public interface NumberingCriteriaMapper {

    // Convertir NumberingCriteria en NumberingCriteriaDTO
    NumberingCriteriaDTO toDTO(NumberingCriteria numberingCriteria);

    // Convertir NumberingCriteriaDTO en NumberingCriteria
    NumberingCriteria toEntity(NumberingCriteriaDTO numberingCriteriaDTO);
}
