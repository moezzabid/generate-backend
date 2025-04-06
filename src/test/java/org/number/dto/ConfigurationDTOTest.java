package org.number.dto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ConfigurationDTOTest {

    // Test du constructeur avec tous les arguments
    @Test
    public void testConstructorWithArguments() {
        // Création d'un objet NumberingCriteriaDTO pour la liste
        NumberingCriteriaDTO criteria1 = new NumberingCriteriaDTO("first_name", "Mr.", "", 10, 1);
        NumberingCriteriaDTO criteria2 = new NumberingCriteriaDTO("last_name", "Dr.", "", 12, 2);

        // Création de la liste de critères
        List<NumberingCriteriaDTO> criteriaList = Arrays.asList(criteria1, criteria2);

        // Création de l'objet ConfigurationDTO avec le constructeur @AllArgsConstructor
        ConfigurationDTO configurationDTO = new ConfigurationDTO(1L, criteriaList);

        // Vérification de l'ID
        assertEquals(1L, configurationDTO.getId());

        // Vérification de la liste de critères
        assertNotNull(configurationDTO.getCriteria());
        assertEquals(2, configurationDTO.getCriteria().size());
        assertEquals(criteria1, configurationDTO.getCriteria().get(0));
        assertEquals(criteria2, configurationDTO.getCriteria().get(1));
    }

    // Test du constructeur par défaut @NoArgsConstructor et des setters
    @Test
    public void testNoArgsConstructorAndSetters() {
        // Création d'un objet ConfigurationDTO avec le constructeur par défaut
        ConfigurationDTO configurationDTO = new ConfigurationDTO();

        // Initialisation de la liste de critères
        NumberingCriteriaDTO criteria1 = new NumberingCriteriaDTO("first_name", "Mr.", "", 10, 1);
        NumberingCriteriaDTO criteria2 = new NumberingCriteriaDTO("last_name", "Dr.", "", 12, 2);
        List<NumberingCriteriaDTO> criteriaList = Arrays.asList(criteria1, criteria2);

        // Utilisation du setter pour l'ID
        configurationDTO.setId(2L);
        // Utilisation du setter pour les critères
        configurationDTO.setCriteria(criteriaList);

        // Vérification de l'ID après le setter
        assertEquals(2L, configurationDTO.getId());

        // Vérification de la liste de critères après le setter
        assertNotNull(configurationDTO.getCriteria());
        assertEquals(2, configurationDTO.getCriteria().size());
        assertEquals(criteria1, configurationDTO.getCriteria().get(0));
        assertEquals(criteria2, configurationDTO.getCriteria().get(1));
    }

    // Test de l'ajout d'un critère dans la liste
    @Test
    public void testAddCriteria() {
        // Création d'un objet ConfigurationDTO avec le constructeur par défaut
        ConfigurationDTO configurationDTO = new ConfigurationDTO();

        // Initialisation de la liste de critères
        NumberingCriteriaDTO criteria1 = new NumberingCriteriaDTO("first_name", "Mr.", "", 10, 1);
        NumberingCriteriaDTO criteria2 = new NumberingCriteriaDTO("last_name", "Dr.", "", 12, 2);

        // Ajout des critères via le setter
        configurationDTO.setCriteria(Arrays.asList(criteria1, criteria2));

        // Vérification que la liste contient les critères
        List<NumberingCriteriaDTO> criteriaList = configurationDTO.getCriteria();
        assertNotNull(criteriaList);
        assertEquals(2, criteriaList.size());

        // Vérification des éléments spécifiques
        assertTrue(criteriaList.contains(criteria1));
        assertTrue(criteriaList.contains(criteria2));
    }
}
