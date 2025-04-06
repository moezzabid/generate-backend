package org.number.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberingCriteriaDTOTest {

    // Test du constructeur par défaut
    @Test
    public void testDefaultConstructor() {
        NumberingCriteriaDTO criteria = new NumberingCriteriaDTO();
        assertNull(criteria.getType(), "Type should be null");
        assertNull(criteria.getPrefix(), "Prefix should be null");
        assertNull(criteria.getSuffix(), "Suffix should be null");
        assertNull(criteria.getLength(), "Length should be null");
        assertNull(criteria.getOrder(), "Order should be null");
    }

    // Test du constructeur avec arguments
    @Test
    public void testAllArgsConstructor() {
        NumberingCriteriaDTO criteria = new NumberingCriteriaDTO("first_name", "Mr.", "Smith", 10, 1);

        assertEquals("first_name", criteria.getType(), "Type should be 'first_name'");
        assertEquals("Mr.", criteria.getPrefix(), "Prefix should be 'Mr.'");
        assertEquals("Smith", criteria.getSuffix(), "Suffix should be 'Smith'");
        assertEquals(10, criteria.getLength(), "Length should be 10");
        assertEquals(1, criteria.getOrder(), "Order should be 1");
    }

    // Test des setters et getters
    @Test
    public void testSettersAndGetters() {
        NumberingCriteriaDTO criteria = new NumberingCriteriaDTO();

        criteria.setType("birth_date");
        criteria.setPrefix("Mr.");
        criteria.setSuffix("Doe");
        criteria.setLength(15);
        criteria.setOrder(2);

        assertEquals("birth_date", criteria.getType(), "Type should be 'birth_date'");
        assertEquals("Mr.", criteria.getPrefix(), "Prefix should be 'Mr.'");
        assertEquals("Doe", criteria.getSuffix(), "Suffix should be 'Doe'");
        assertEquals(15, criteria.getLength(), "Length should be 15");
        assertEquals(2, criteria.getOrder(), "Order should be 2");
    }

}
