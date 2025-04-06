package org.number.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.number.dto.ConfigurationCreateDTO;
import org.number.dto.GeneratedNumberDTO;
import org.number.dto.ConfigurationDTO;
import org.number.service.NumberingService;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class NumberingControllerTest {

    @InjectMocks
    private NumberingController numberingController;

    @Mock
    private NumberingService numberingService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(numberingController).build();
    }

    // Test pour la génération d'un numéro
    @Test
    public void testGenerateNumber_Success() throws Exception {
        // Création de l'objet GeneratedNumberDTO
        GeneratedNumberDTO generatedNumberDTO = new GeneratedNumberDTO();
        generatedNumberDTO.setConfigurationId(1L);
        when(numberingService.generateAndSaveNumber(1L, generatedNumberDTO, 10)).thenReturn("generatedNumber123");

        mockMvc.perform(post("/api/numbering/generate")
                        .contentType("application/json")
                        .content("{\"configurationId\": 1}"))
                .andExpect(status().isOk())
                .andExpect(content().string("generatedNumber123"));

        verify(numberingService, times(1)).generateAndSaveNumber(1L, generatedNumberDTO, 10);
    }

    // Test pour la sauvegarde de la configuration
    @Test
    public void testSaveConfiguration_Success() throws Exception {
        ConfigurationCreateDTO configurationCreateDTO = new ConfigurationCreateDTO();
        ConfigurationDTO configurationDTO = new ConfigurationDTO();
        configurationDTO.setId(1L);  // Exemple de configuration avec un ID

        when(numberingService.saveConfiguration(configurationCreateDTO)).thenReturn(configurationDTO);

        mockMvc.perform(post("/api/numbering/config")
                        .contentType("application/json")
                        .content("{\"someProperty\": \"someValue\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));

        verify(numberingService, times(1)).saveConfiguration(configurationCreateDTO);
    }
}
