package kickoff.configurationdate.gateway.dummies;

import kickoff.configurationdate.ConfigurationDate;
import kickoff.configurationdate.gateway.ConfigurationDateRepository;
import org.junit.Assert;
import org.junit.Test;

public class ConfigurationDateRepositoryDummyTest {

    @Test
    public void testGetRepository() {

        ConfigurationDateRepository configurationDateRepository = ConfigurationDateRepositoryDummy.getRepository();

        ConfigurationDate configurationDate = ConfigurationDate.builder().build();

        configurationDateRepository.save(configurationDate)
                .subscribe(configurationDate1 -> {
                    Assert.assertEquals(configurationDate, configurationDate1);
                });

        configurationDateRepository.get()
                .subscribe(configurationDate1 -> {
                    Assert.assertEquals(configurationDate1, ConfigurationDate.builder().build());
                });

    }

}