package kickoff.cyclist.data;

import kickoff.team.data.TeamData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cyclist")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CyclistData {

    @Id
    private String code;
    @Column(name = "fullname")
    private String fullName;
    @ManyToOne
    @JoinColumn(name="team_code", nullable=false)
    private TeamData teamData;
    private String country;
}
