package org.number.controller;

import org.number.dto.ConfigurationCreateDTO;
import org.number.dto.GeneratedNumberDTO;
import org.number.dto.ConfigurationDTO;
import org.number.dto.GeneratedNumberResponseDTO;
import org.number.entity.GeneratedNumber;
import org.number.service.NumberingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/numbering")
@CrossOrigin("*")
public class NumberingController {

    @Autowired
    private NumberingService numberingService;

  @PostMapping("/generate")
  public GeneratedNumberResponseDTO generateNumber(@RequestBody GeneratedNumberDTO generatedNumberDTO) {
    GeneratedNumberResponseDTO generatedNumber = numberingService.generateAndSaveNumber(
      generatedNumberDTO.getConfigurationId(),
      generatedNumberDTO,
      generatedNumberDTO.getCounter()
    );
    return  generatedNumber;
  }

    //Api pour energistrer et générer la configuration
    @PostMapping("/config")
    public ConfigurationDTO saveConfiguration(@RequestBody ConfigurationCreateDTO configurationDTO) {
        return numberingService.saveConfiguration(configurationDTO);
    }
}
