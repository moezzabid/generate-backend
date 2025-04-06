package org.number.service.impl;

import org.number.dto.*;
import org.number.entity.Configuration;
import org.number.entity.GeneratedNumber;
import org.number.entity.NumberingCriteria;
import org.number.mapper.ConfigurationMapper;
import org.number.mapper.GeneratedNumberMapper;
import org.number.mapper.NumberingCriteriaMapper;
import org.number.repository.ConfigurationRepository;
import org.number.repository.CriteriaRepository;
import org.number.repository.GeneratedNumberRepository;
import org.number.service.NumberingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NumberingServiceImpl implements NumberingService {

  @Autowired
  private ConfigurationRepository configurationRepository;

  @Autowired
  private GeneratedNumberRepository generatedNumberRepository;

  @Autowired
  private CriteriaRepository numberingCriteriaRepository;

  @Autowired
  private ConfigurationMapper configurationMapper;

  @Autowired
  private GeneratedNumberMapper generatedNumberMapper;

  @Autowired
  private NumberingCriteriaMapper numberingCriteriaMapper;

  @Override
  public GeneratedNumberResponseDTO generateAndSaveNumber(Long configurationId, GeneratedNumberDTO generatedNumberDTO, int counter) {
    // Récupérer la configuration à partir de la base de données
    Configuration configurationEntity = configurationRepository.findById(configurationId)
      .orElseThrow(() -> new RuntimeException("Configuration not found"));

    // Trier les critères par ordre
    configurationEntity.getCriteria().sort((c1, c2) -> Integer.compare(c1.getOrder(), c2.getOrder()));

    // Générer le numéro
    StringBuilder generatedNumber = new StringBuilder();
    for (NumberingCriteria criteria : configurationEntity.getCriteria()) {
      switch (criteria.getType()) {
        case "first_name":
          generatedNumber.append(formatString(generatedNumberDTO.getFirstName(), criteria));  // Exemple prénom
          break;
        case "last_name":
          generatedNumber.append(formatString(generatedNumberDTO.getLastName(), criteria));   // Exemple nom
          break;
        case "birth_date":
          generatedNumber.append(formatDate(generatedNumberDTO.getBirthDate(), criteria)); // Exemple date de naissance
          break;
        case "counter":
          generatedNumber.append(formatCounter(counter, criteria)); // Format du compteur
          break;
        default:
          throw new IllegalArgumentException("Invalid field type in criteria: " + criteria.getType());
      }
    }

    // Sauvegarder le numéro généré dans la base de données
    GeneratedNumber generatedNumberEntity = new GeneratedNumber();
    generatedNumberEntity.setGeneratedNumber(generatedNumber.toString());
    generatedNumberEntity.setConfiguration(configurationEntity);
    generatedNumberRepository.save(generatedNumberEntity);

    // Retourner le DTO avec le numéro généré
    return new GeneratedNumberResponseDTO(generatedNumber.toString());
  }

  private String formatString(String input, NumberingCriteria criteria) {
    String result = input.length() > criteria.getLength() ? input.substring(0, criteria.getLength()) : input;
    return criteria.getPrefix() + result + criteria.getSuffix().toUpperCase();
  }

  private String formatDate(String birthDate, NumberingCriteria criteria) {
    return birthDate.substring(0, 4); // Exemple : YYYY
  }

  private String formatCounter(Integer counter, NumberingCriteria criteria) {
    if (counter == null) {
      counter = 1; // Si aucun compteur n'est fourni, on démarre à 1
    }
    return String.format("%s%0" + criteria.getLength() + "d%s", criteria.getPrefix(), counter+1, criteria.getSuffix());
  }


  @Override
  public ConfigurationDTO saveConfiguration(ConfigurationCreateDTO configurationCreateDTO) {
    //Convertir le DTO en entité Configuration
    Configuration configurationEntity = configurationMapper.toEntity(configurationCreateDTO);

    //Sauvegarder la configuration dans la base de données
    Configuration savedConfiguration = configurationRepository.save(configurationEntity);

    //Sauvegarder les critères de numérotation associés à cette configuration
    for (NumberingCriteriaDTO criteriaDTO : configurationCreateDTO.getCriteria()) {
      if (criteriaDTO == null) {
        throw new IllegalArgumentException("NumberingCriteriaDTO cannot be null");
      }

      NumberingCriteria criteriaEntity = numberingCriteriaMapper.toEntity(criteriaDTO);

      if (criteriaEntity == null) {
        throw new IllegalArgumentException("Failed to convert NumberingCriteriaDTO to NumberingCriteria");
      }

      // Lier la configuration à ce critère
      criteriaEntity.setConfiguration(savedConfiguration);
      numberingCriteriaRepository.save(criteriaEntity);
    }


    //Convertir l'entité Configuration sauvegardée en ConfigurationDTO pour la réponse
    ConfigurationDTO configurationDTO = configurationMapper.toDTO(savedConfiguration);

    // Retourner la ConfigurationDTO avec l'id
    return configurationDTO;
  }


}
