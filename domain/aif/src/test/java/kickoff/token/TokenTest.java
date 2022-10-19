package kickoff.token;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class TokenTest {

    Token token = Token.builder()
            .accessToken("token")
            .expireTime("1")
            .build();

    @Test
    public void getAccess_token() {
        assertEquals("token", token.getAccessToken());
    }

    @Test
    public void getExpires_in() {
        assertEquals(Optional.of("1"), Optional.of(token.getExpireTime()));
    }

    @Test
    public void testEquals() {
        Token token1 = Token.builder()
                .accessToken("token")
                .expireTime("1")
                .build();

        assertEquals(token1, token);
    }
}