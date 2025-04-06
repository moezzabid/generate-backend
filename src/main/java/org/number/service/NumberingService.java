package org.number.service;

import org.number.dto.ConfigurationCreateDTO;
import org.number.dto.ConfigurationDTO;
import org.number.dto.GeneratedNumberDTO;
import org.number.dto.GeneratedNumberResponseDTO;

public interface NumberingService {

  GeneratedNumberResponseDTO generateAndSaveNumber(Long configurationId, GeneratedNumberDTO generatedNumberDTO, int counter);

  ConfigurationDTO saveConfiguration(ConfigurationCreateDTO configurationDTO);
}
