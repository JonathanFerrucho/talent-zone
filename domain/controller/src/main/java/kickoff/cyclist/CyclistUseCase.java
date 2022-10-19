package kickoff.cyclist;

import kickoff.cyclist.gateway.CyclistClient;
import kickoff.team.Team;
import kickoff.team.gateway.TeamClient;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CyclistUseCase {

    private final CyclistClient cyclistClient;
    private final TeamClient teamClient;


    public Cyclist createCyclist(Cyclist cyclist){

        if(cyclist.getCode() == null || cyclist.getCode().length()>3){
            throw  new IllegalArgumentException("el codigo es obligatorio y con un tamaño maximo de 3 caracteres");
        }

        if(cyclistClient.existsCyclist(cyclist.getCode())){
            throw  new IllegalArgumentException("el codigo debe ser unico");
        }

        if(cyclist.getTeam() == null || !teamClient.existsTeam(cyclist.getTeam().getCode())){
            throw  new IllegalArgumentException("el cilcista debe tener un equipo asociado existente");
        }

        Team team = teamClient.findByCode(cyclist.getTeam().getCode());

        if(team.getCapacity()<= 0){
            throw  new IllegalArgumentException("El equipo esta lleno");
        }
        team.setCapacity(team.getCapacity()-1);
        teamClient.createTeam(team);
        return cyclistClient.createCyclist(cyclist);
    }

    public Cyclist modifyCyclist(Cyclist cyclist){

        if(cyclist.getCode() == null || cyclist.getCode().length()>3){
            throw  new IllegalArgumentException("el codigo es obligatorio y con un tamaño maximo de 3 caracteres");
        }

        Cyclist cyclistOld= cyclistClient.findByCode(cyclist.getCode());

        if(cyclistOld.getCode() == null ){
            throw  new IllegalArgumentException("No se encontro ciclista para el codigo " + cyclist.getCode());
        }

        return cyclistClient.createCyclist(mergeCyclist(cyclistOld, cyclist));
    }

    public List<Cyclist> getCyclist(Cyclist cyclist){
        return cyclistClient.getCyclist(cyclist);
    }

    public Cyclist findByCode(String code ){
        return cyclistClient.findByCode(code);
    }

    private Cyclist mergeCyclist (Cyclist cyclistOld, Cyclist cyclist){

        if(cyclist.getFullName() != null){
            cyclistOld.setFullName(cyclist.getFullName());
        }
        if(cyclist.getCountry() != null){
            cyclistOld.setCountry(cyclist.getCountry());
        }

        if(cyclist.getTeam() != null && cyclist.getTeam().getCode() != null){
            cyclistOld.setTeam(Team.builder()
                    .code(cyclist.getTeam().getCode())
                    .build());
        }

        return cyclistOld;
    }
}
