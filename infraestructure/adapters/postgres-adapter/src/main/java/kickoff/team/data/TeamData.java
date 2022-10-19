package kickoff.team.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Team")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamData {

    @Id
    private String code;
    private String name;
    private String country;
    private Integer capacity;
}
