package org.number.mapper;

import org.mapstruct.Mapper;
import org.number.dto.ConfigurationCreateDTO;
import org.number.dto.ConfigurationDTO;
import org.number.entity.Configuration;

@Mapper(componentModel = "spring")
public interface ConfigurationMapper {

    ConfigurationDTO toDTO(Configuration configuration);
    Configuration toEntity(ConfigurationCreateDTO configurationDTO);
}
