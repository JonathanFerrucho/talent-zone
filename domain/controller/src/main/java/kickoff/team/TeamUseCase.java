package kickoff.team;

import kickoff.team.gateway.TeamClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@RequiredArgsConstructor
public class TeamUseCase {

    private final TeamClient teamClient;

    @Value("${team.capacity}")
    private Integer teamCapacity;

    public Team createTeam(Team team){

        if(team.getCode() == null || team.getCode().length()>3){
            throw  new IllegalArgumentException("el codigo es obligatorio y con un tamaño maximo de 3 caracteres");
        }

        if(teamClient.existsTeam(team.getCode())){
            throw  new IllegalArgumentException("el codigo debe ser unico");
        }

        team.setCapacity(teamCapacity);
        return teamClient.createTeam(team);
    }

    public Team modifyTeam(Team team){

        if(team.getCode() == null || team.getCode().length()>3){
            throw  new IllegalArgumentException("el codigo es obligatorio y con un tamaño maximo de 3 caracteres");
        }

        Team teamOld= teamClient.findByCode(team.getCode());

        if(teamOld.getCode() == null ){
            throw  new IllegalArgumentException("No se encontro team para el codigo " + team.getCode());
        }

        return teamClient.createTeam(mergeTeam(teamOld, team));
    }

    public List<Team> getTeam(Team team){
        return teamClient.getTeam(team);
    }

    public Team findByCode(String code ){
        return teamClient.findByCode(code);
    }

    private Team mergeTeam (Team teamOld, Team team){

        if(team.getName() != null){
            teamOld.setName(team.getName());
        }
        if(team.getCountry() != null){
            teamOld.setCountry(team.getCountry());
        }

        return teamOld;
    }
}
