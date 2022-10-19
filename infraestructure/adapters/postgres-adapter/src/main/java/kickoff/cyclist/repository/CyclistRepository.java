package kickoff.cyclist.repository;

import kickoff.cyclist.data.CyclistData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CyclistRepository extends JpaRepository<CyclistData, String> {
}
