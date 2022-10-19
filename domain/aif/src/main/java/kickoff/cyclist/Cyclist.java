package kickoff.cyclist;

import kickoff.team.Team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cyclist {

    private String code;
    private String fullName;
    private Team team;
    private String country;

}
