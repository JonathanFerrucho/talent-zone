package kickoff.common.dummies;

import kickoff.common.DomainGateway;
import kickoff.common.DomainGatewayDummy;
import kickoff.common.DomainProcess;
import kickoff.common.DomainProcessImplementation;
import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class EventsGatewayDummyTest {

    @Test
    public void testGetEventsGateway() {

        DomainGateway domainGateway= DomainGatewayDummy.getDomainGateway();

        Date date = Date.from(Instant.now());
        DomainProcess<String> gatheringCenterBusinessProcess = new DomainProcessImplementation<>("process", "data", date);
        Throwable throwable = new Throwable("error");

        domainGateway.emitIn(gatheringCenterBusinessProcess)
                .subscribe(message -> {
                    Assert.assertEquals("data", message);
                });

        domainGateway.emitOut(gatheringCenterBusinessProcess)
                .subscribe(message -> {
                    Assert.assertEquals("data", message);
                });

        domainGateway.emitError(gatheringCenterBusinessProcess, throwable)
                .subscribe(message -> {
                    assertEquals("data", message);
                });
    }
}