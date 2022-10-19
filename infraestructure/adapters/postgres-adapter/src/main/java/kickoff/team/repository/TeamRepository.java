package kickoff.team.repository;

import kickoff.team.data.TeamData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<TeamData, String> {
}
