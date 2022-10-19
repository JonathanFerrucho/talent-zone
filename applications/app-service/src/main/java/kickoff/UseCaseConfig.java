package kickoff;

import kickoff.cyclist.CyclistUseCase;
import kickoff.cyclist.gateway.CyclistClient;
import kickoff.team.TeamUseCase;
import kickoff.team.gateway.TeamClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public TeamUseCase teamUseCase(TeamClient teamClient) {
        return new TeamUseCase(teamClient);
    }

    @Bean
    public CyclistUseCase cyclistUseCase(CyclistClient cyclistClient, TeamClient teamClient) {
        return new CyclistUseCase(cyclistClient, teamClient);
    }
}
