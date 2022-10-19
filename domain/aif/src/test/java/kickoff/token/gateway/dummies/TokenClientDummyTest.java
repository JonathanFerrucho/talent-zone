package kickoff.token.gateway.dummies;

import kickoff.token.gateway.TokenClient;
import org.junit.Assert;
import org.junit.Test;

public class TokenClientDummyTest {

    @Test
    public void tokenClient() {

        TokenClient tokenClient = TokenClientDummy.tokenClient();

        tokenClient.getToken()
                .subscribe(message -> {
                    Assert.assertEquals("token", message);
                });

    }
}