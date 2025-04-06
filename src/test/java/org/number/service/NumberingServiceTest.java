package org.number.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.number.dto.ConfigurationCreateDTO;
import org.number.dto.ConfigurationDTO;
import org.number.dto.GeneratedNumberDTO;
import org.number.entity.*;
import org.number.repository.*;
import org.number.mapper.*;
import org.number.service.impl.NumberingServiceImpl;
import org.number.utils.MockGenerator;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Optional;

class NumberingServiceTest {

  @InjectMocks
  private NumberingServiceImpl numberingService;

  @Mock
  private ConfigurationRepository configurationRepository;

  @Mock
  private GeneratedNumberRepository generatedNumberRepository;

  @Mock
  private CriteriaRepository numberingCriteriaRepository;

  @Mock
  private ConfigurationMapper configurationMapper;

  @Mock
  private GeneratedNumberMapper generatedNumberMapper;

  @Mock
  private NumberingCriteriaMapper numberingCriteriaMapper;

  private Configuration configuration;
  private GeneratedNumberDTO generatedNumberDTO;


  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);  // Initialisation des mocks avant chaque test
  }


  @Test
  void testGenerateAndSaveNumber_ConfigurationNotFound() {
    // Simuler le cas où la configuration n'est pas trouvée
    when(configurationRepository.findById(1L)).thenReturn(Optional.empty());

    // Appel de la méthode et vérification de l'exception
    RuntimeException exception = assertThrows(RuntimeException.class, () -> {
      numberingService.generateAndSaveNumber(1L, MockGenerator.generateGeneratedNumberDTO(), 1);
    });

    assertEquals("Configuration not found", exception.getMessage());
  }

  @Test
  void testSaveConfiguration_Success() {
    // Utilisation du TestMockGenerator pour créer des objets
    ConfigurationCreateDTO configurationCreateDTO = MockGenerator.generateConfigurationCreateDTO();
    Configuration configurationEntity = MockGenerator.generateConfiguration();

    // Simuler les appels aux mappers et repositories
    when(configurationMapper.toEntity(configurationCreateDTO)).thenReturn(configurationEntity);
    when(configurationRepository.save(configurationEntity)).thenReturn(configurationEntity);
    when(configurationMapper.toDTO(configurationEntity)).thenReturn(new ConfigurationDTO());

    // Appel de la méthode
    ConfigurationDTO result = numberingService.saveConfiguration(configurationCreateDTO);

    // Vérification
    assertNotNull(result);
    assertEquals(1L, result.getId());
    verify(configurationRepository, times(1)).save(configurationEntity);
  }

  @Test
  void testSaveConfiguration_Error() {
    // Test pour une situation où il y aurait une erreur (par exemple une exception de mappage)
    RuntimeException exception = assertThrows(RuntimeException.class, () -> {
      numberingService.saveConfiguration(null);
    });

    assertNotNull(exception);
  }
}
