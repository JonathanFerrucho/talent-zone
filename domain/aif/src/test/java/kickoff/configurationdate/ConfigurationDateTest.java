package kickoff.configurationdate;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConfigurationDateTest {

    ConfigurationDate configurationDate = ConfigurationDate.builder()
            .nameOperation("operation")
            .field1("field")
            .field2("field")
            .field3("field")
            .field4("field")
            .field5("field")
            .field6("field")
            .description("description")
            .build();

    @Test
    public void testGetters() {
        assertEquals("operation", configurationDate.getNameOperation());
        assertEquals("field", configurationDate.getField1());
        assertEquals("field", configurationDate.getField2());
        assertEquals("field", configurationDate.getField3());
        assertEquals("field", configurationDate.getField4());
        assertEquals("field", configurationDate.getField5());
        assertEquals("field", configurationDate.getField6());
        assertEquals("description", configurationDate.getDescription());
    }

    @Test
    public void testEquals() {
        ConfigurationDate configurationDate1 = ConfigurationDate.builder()
                .nameOperation("operation")
                .field1("field")
                .field2("field")
                .field3("field")
                .field4("field")
                .field5("field")
                .field6("field")
                .description("description")
                .build();

        assertEquals(configurationDate, configurationDate1);
    }
}