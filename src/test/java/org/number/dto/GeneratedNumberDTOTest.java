package org.number.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GeneratedNumberDTOTest {

    // Test du constructeur @AllArgsConstructor et @Getter
    @Test
    public void testConstructorAndGetters() {
        GeneratedNumberDTO generatedNumber = new GeneratedNumberDTO(1L, "John", "Doe", "1990-01-01", 100);
        assertEquals(1L, generatedNumber.getConfigurationId());
        assertEquals("John", generatedNumber.getFirstName());
        assertEquals("Doe", generatedNumber.getLastName());
        assertEquals("1990-01-01", generatedNumber.getBirthDate());
        assertEquals(100, generatedNumber.getCounter());
    }

    // Test des setters générés par @Setter
    @Test
    public void testSetters() {
        GeneratedNumberDTO generatedNumber = new GeneratedNumberDTO();

        // Utilisation des setters générés par Lombok
        generatedNumber.setConfigurationId(1L);
        generatedNumber.setFirstName("John");
        generatedNumber.setLastName("Doe");
        generatedNumber.setBirthDate("1990-01-01");
        generatedNumber.setCounter(100);

        assertEquals(1L, generatedNumber.getConfigurationId());
        assertEquals("John", generatedNumber.getFirstName());
        assertEquals("Doe", generatedNumber.getLastName());
        assertEquals("1990-01-01", generatedNumber.getBirthDate());
        assertEquals(100, generatedNumber.getCounter());
    }

}
