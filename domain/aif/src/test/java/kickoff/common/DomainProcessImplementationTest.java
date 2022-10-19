package kickoff.common;

import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;
import java.util.Date;

public class DomainProcessImplementationTest {

    Date date = Date.from(Instant.now());
    DomainProcessImplementation<String> businessProcessImplementation = new DomainProcessImplementation<>("name", "data", date);

    @Test
    public void name() {
        Assert.assertEquals("name", businessProcessImplementation.name());
    }

    @Test
    public void data() {
        Assert.assertEquals("data", businessProcessImplementation.data());
    }

    @Test
    public void date() {
        Assert.assertEquals(date, businessProcessImplementation.date());
    }
}