package kickoff.cyclist;

import kickoff.cyclist.data.CyclistData;
import kickoff.cyclist.gateway.CyclistClient;
import kickoff.cyclist.repository.CyclistRepository;
import kickoff.team.Team;
import kickoff.team.data.TeamData;
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
public class CyclistAdapter implements CyclistClient {

    @Autowired
    private final CyclistRepository cyclistRepository;

    @Override
    public Cyclist createCyclist(Cyclist cyclist) {
        return this.toCyclist(cyclistRepository.save(this.toCyclistData(cyclist)));
    }

    @Override
    public Cyclist modifyCyclist(Cyclist cyclist) {
        return null;
    }

    @Override
    public List<Cyclist> getCyclist(Cyclist cyclist) {
        Example<CyclistData> example= Example.of(this.toCyclistData(cyclist));
        return this.toCyclist(cyclistRepository.findAll(example));
    }

    @Override
    public Cyclist findByCode(String code) {

        Optional<CyclistData>  optTeam= cyclistRepository.findById(code);

        if (optTeam.isPresent()){
            return this.toCyclist(optTeam.get());
        }else {
            return Cyclist.builder().build();
        }
    }

    @Override
    public Boolean existsCyclist(String code) {
        return cyclistRepository.existsById(code);
    }

    private CyclistData toCyclistData(Cyclist cyclist) {
        CyclistData cyclistData= new CyclistData();

        if(cyclist.getCode() != null){
            cyclistData.setCode(cyclist.getCode());
        }
        if(cyclist.getFullName() != null){
            cyclistData.setFullName(cyclist.getFullName());
        }
        if(cyclist.getCountry() != null){
            cyclistData.setCountry(cyclist.getCountry());
        }
        if(cyclist.getTeam() != null && cyclist.getTeam().getCode() != null){
            cyclistData.setTeamData(TeamData.builder()
                    .code(cyclist.getTeam().getCode())
                    .build());
        }

        return cyclistData;
    }

    private List<Cyclist> toCyclist(List<CyclistData> cyclistDatas) {
        List<Cyclist> cyclists= new ArrayList<>();

        for (CyclistData cyclistData: cyclistDatas){
            cyclists.add(this.toCyclist(cyclistData));
        }

        return cyclists;
    }

    private Cyclist toCyclist(CyclistData cyclistData) {
        Cyclist cyclist= new Cyclist();

        if(cyclistData.getCode() != null){
            cyclist.setCode(cyclistData.getCode());
        }
        if(cyclistData.getFullName() != null){
            cyclist.setFullName(cyclistData.getFullName());
        }
        if(cyclistData.getCountry() != null){
            cyclist.setCountry(cyclistData.getCountry());
        }
        if(cyclistData.getTeamData() != null && cyclistData.getTeamData().getCode()!= null){
            cyclist.setTeam(Team.builder()
                    .code(cyclistData.getTeamData().getCode())
                    .build());
        }

        return cyclist;
    }
}