package org.number.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.number.dto.ConfigurationCreateDTO;
import org.number.dto.ConfigurationDTO;
import org.number.dto.NumberingCriteriaDTO;
import org.number.entity.Configuration;
import org.number.entity.NumberingCriteria;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConfigurationMapperTest {

    private ConfigurationMapper configurationMapper;

    @BeforeEach
    public void setUp() {
        configurationMapper = Mappers.getMapper(ConfigurationMapper.class);
    }

    // Test de la méthode toDTO
    @Test
    public void testToDTO() {
        Configuration configuration = new Configuration();
        configuration.setId(1L);
        configuration.setCriteria(Arrays.asList(
                new NumberingCriteria(1L,"first_name","-","-",10,1,configuration),
                new NumberingCriteria()
        ));

        ConfigurationDTO configurationDTO = configurationMapper.toDTO(configuration);

        assertEquals(1L, configurationDTO.getId());
        assertEquals(2, configurationDTO.getCriteria().size());
        assertEquals("first_name", configurationDTO.getCriteria().get(0).getType());
        assertEquals("-", configurationDTO.getCriteria().get(0).getPrefix());
        assertEquals(10, configurationDTO.getCriteria().get(0).getLength());
        assertEquals(1, configurationDTO.getCriteria().get(0).getOrder());
    }

    // Test de la méthode toEntity
    @Test
    public void testToEntity() {
        ConfigurationCreateDTO configurationCreateDTO = new ConfigurationCreateDTO();
        configurationCreateDTO.setCriteria(Arrays.asList(
                new NumberingCriteriaDTO("first_name", "Mr.", "", 10, 1),
                new NumberingCriteriaDTO("last_name", "Dr.", "", 12, 2)
        ));

        // Exécution de la conversion
        Configuration configuration = configurationMapper.toEntity(configurationCreateDTO);

        // Vérification des résultats
        assertEquals(2, configuration.getCriteria().size());
        assertEquals("first_name", configuration.getCriteria().get(0).getType());
        assertEquals("Mr.", configuration.getCriteria().get(0).getPrefix());
        assertEquals(10, configuration.getCriteria().get(0).getLength());
        assertEquals(1, configuration.getCriteria().get(0).getOrder());
    }
}
