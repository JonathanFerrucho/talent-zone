package kickoff.team.gateway.dummies;

import kickoff.team.gateway.TeamClient;
import lombok.extern.java.Log;
import reactor.core.publisher.Mono;

@Log
public class TokenClientDummy {

    /*
    private static final TeamClient tokenClient = new TeamClient() {
        @Override
        public Mono<String> getToken() {
            log.info("Busqueda en cliente sin implementación");
            return Mono.just("token");
        }
    };

    public static TeamClient tokenClient(){
        return tokenClient;
    }
    */
}
