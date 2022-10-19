package kickoff.team.gateway;

import kickoff.team.Team;

import java.util.List;

public interface TeamClient {

     Team createTeam(Team team);
     List<Team> getTeam(Team team);
     Team findByCode(String code);
     Boolean existsTeam(String code);

}
