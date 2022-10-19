package kickoff.cyclist.gateway;

import kickoff.cyclist.Cyclist;

import java.util.List;
import java.util.Optional;

public interface CyclistClient {

     Cyclist createCyclist(Cyclist cyclist);
     Cyclist modifyCyclist(Cyclist cyclist);
     List<Cyclist> getCyclist(Cyclist cyclist);
     Cyclist findByCode(String code);
     Boolean existsCyclist(String code);

}
