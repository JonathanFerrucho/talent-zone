package kickoff.team;

import kickoff.team.data.TeamData;
import kickoff.team.gateway.TeamClient;
import kickoff.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log
@Component
@RequiredArgsConstructor
public class TeamAdapter implements TeamClient {

    @Autowired
    private final TeamRepository teamRepository;

    @Override
    public Team createTeam(Team team) {
        return this.toTeam(teamRepository.save(this.toTeamData(team)));
    }

    @Override
    public List<Team> getTeam(Team team) {

        Example<TeamData> example= Example.of(this.toTeamData(team));
        return this.toTeam(teamRepository.findAll(example));
    }

    @Override
    public Team findByCode(String code) {

        Optional<TeamData>  optTeam= teamRepository.findById(code);

        if (optTeam.isPresent()){
            return this.toTeam(optTeam.get());
        }else {
            return Team.builder().build();
        }
    }

    @Override
    public Boolean existsTeam(String code) {
        return teamRepository.existsById(code);
    }


    private TeamData toTeamData(Team team) {
        TeamData teamData= new TeamData();

        if(team.getCode() != null){
            teamData.setCode(team.getCode());
        }
        if(team.getName() != null){
            teamData.setName(team.getName());
        }
        if(team.getCountry() != null){
            teamData.setCountry(team.getCountry());
        }
        if(team.getCapacity() != null){
            teamData.setCapacity(team.getCapacity());
        }

        return teamData;
    }

    private List<Team> toTeam(List<TeamData> teamDatas) {
        List<Team> teams= new ArrayList<>();

        for (TeamData teamData: teamDatas){
            teams.add(this.toTeam(teamData));
        }

        return teams;
    }

    private Team toTeam(TeamData teamData) {
        Team team= new Team();

        if(teamData.getCode() != null){
            team.setCode(teamData.getCode());
        }
        if(teamData.getName() != null){
            team.setName(teamData.getName());
        }
        if(teamData.getCountry() != null){
            team.setCountry(teamData.getCountry());
        }
        if(teamData.getCapacity() != null){
            team.setCapacity(teamData.getCapacity());
        }

        return team;
    }
}