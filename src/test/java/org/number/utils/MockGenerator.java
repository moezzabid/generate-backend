package org.number.utils;

import org.number.dto.ConfigurationDTO;
import org.number.dto.ConfigurationCreateDTO;
import org.number.dto.GeneratedNumberDTO;
import org.number.dto.NumberingCriteriaDTO;
import org.number.entity.Configuration;
import org.number.entity.GeneratedNumber;
import org.number.entity.NumberingCriteria;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class MockGenerator {

    // Générer un mock de ConfigurationDTO
    public static ConfigurationDTO generateConfigurationDTO() {
        ConfigurationDTO configurationDTO = new ConfigurationDTO();
        configurationDTO.setId(1L);
        configurationDTO.setCriteria(generateNumberingCriteriaDTOList());
        return configurationDTO;
    }

    // Générer un mock de ConfigurationCreateDTO
    public static ConfigurationCreateDTO generateConfigurationCreateDTO() {
        ConfigurationCreateDTO configurationCreateDTO = new ConfigurationCreateDTO();
        configurationCreateDTO.setCriteria(generateNumberingCriteriaDTOList());
        return configurationCreateDTO;
    }

    // Générer un mock de GeneratedNumberDTO
    public static GeneratedNumberDTO generateGeneratedNumberDTO() {
        GeneratedNumberDTO generatedNumberDTO = new GeneratedNumberDTO();
        generatedNumberDTO.setFirstName("Isaac");
        generatedNumberDTO.setLastName("Antoine");
        generatedNumberDTO.setBirthDate("1992-04-24");
        generatedNumberDTO.setCounter(7);
        return generatedNumberDTO;
    }

    // Générer une liste de NumberingCriteriaDTO
    public static List<NumberingCriteriaDTO> generateNumberingCriteriaDTOList() {
        List<NumberingCriteriaDTO> criteriaDTOList = new ArrayList<>();

        NumberingCriteriaDTO criteria1 = new NumberingCriteriaDTO();
        criteria1.setType("first_name");
        criteria1.setPrefix("");
        criteria1.setSuffix("-");
        criteria1.setLength(3);
        criteria1.setOrder(2);
        criteriaDTOList.add(criteria1);

        NumberingCriteriaDTO criteria2 = new NumberingCriteriaDTO();
        criteria2.setType("last_name");
        criteria2.setPrefix("PRE_");
        criteria2.setSuffix("_SUF");
        criteria2.setLength(4);
        criteria2.setOrder(1);
        criteriaDTOList.add(criteria2);

        NumberingCriteriaDTO criteria3 = new NumberingCriteriaDTO();
        criteria3.setType("birth_date");
        criteria3.setPrefix("N");
        criteria3.setSuffix("");
        criteria3.setLength(4);
        criteria3.setOrder(4);
        criteriaDTOList.add(criteria3);

        NumberingCriteriaDTO criteria4 = new NumberingCriteriaDTO();
        criteria4.setType("counter");
        criteria4.setPrefix("C");
        criteria4.setSuffix("");
        criteria4.setLength(5);
        criteria4.setOrder(3);
        criteriaDTOList.add(criteria4);

        return criteriaDTOList;
    }

    // Générer un mock de Configuration
    public static Configuration generateConfiguration() {
        Configuration configuration = new Configuration();
        configuration.setId(1L);
        configuration.setCriteria(generateNumberingCriteriaList());
        return configuration;
    }

    // Générer une liste de NumberingCriteria
    public static List<NumberingCriteria> generateNumberingCriteriaList() {
        List<NumberingCriteria> criteriaList = new ArrayList<>();

        NumberingCriteria criteria1 = new NumberingCriteria();
        criteria1.setType("first_name");
        criteria1.setPrefix("");
        criteria1.setSuffix("-");
        criteria1.setLength(3);
        criteria1.setOrder(2);
        criteriaList.add(criteria1);

        NumberingCriteria criteria2 = new NumberingCriteria();
        criteria2.setType("last_name");
        criteria2.setPrefix("PRE_");
        criteria2.setSuffix("_SUF");
        criteria2.setLength(4);
        criteria2.setOrder(1);
        criteriaList.add(criteria2);

        NumberingCriteria criteria3 = new NumberingCriteria();
        criteria3.setType("birth_date");
        criteria3.setPrefix("N");
        criteria3.setSuffix("");
        criteria3.setLength(4);
        criteria3.setOrder(4);
        criteriaList.add(criteria3);

        NumberingCriteria criteria4 = new NumberingCriteria();
        criteria4.setType("counter");
        criteria4.setPrefix("C");
        criteria4.setSuffix("");
        criteria4.setLength(5);
        criteria4.setOrder(3);
        criteriaList.add(criteria4);

        return criteriaList;
    }

    // Générer un mock de GeneratedNumber
    public static GeneratedNumber generateGeneratedNumber() {
        GeneratedNumber generatedNumber = new GeneratedNumber();
        generatedNumber.setGeneratedNumber("ANTO_ISA-C00008N1992");
        return generatedNumber;
    }

    // Générer un mock de NumberingCriteria
    public static NumberingCriteria generateNumberingCriteria() {
        NumberingCriteria criteria = new NumberingCriteria();
        criteria.setType("first_name");
        criteria.setPrefix("");
        criteria.setSuffix("-");
        criteria.setLength(3);
        criteria.setOrder(2);
        return criteria;
    }
}
