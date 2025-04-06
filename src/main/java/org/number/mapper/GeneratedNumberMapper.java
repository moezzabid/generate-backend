package org.number.mapper;

import org.mapstruct.Mapper;
import org.number.dto.GeneratedNumberDTO;
import org.number.entity.GeneratedNumber;

@Mapper(componentModel = "spring")
public interface GeneratedNumberMapper {
    GeneratedNumberDTO toDTO(GeneratedNumber generatedNumber);
    GeneratedNumber toEntity(GeneratedNumberDTO generatedNumberDTO);
}
