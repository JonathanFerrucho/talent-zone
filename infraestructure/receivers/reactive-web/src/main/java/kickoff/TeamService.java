package kickoff;

import kickoff.team.Team;
import kickoff.team.TeamUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log
@RestController
@RequiredArgsConstructor
public class TeamService {

    private final TeamUseCase teamUseCase;

    @Value("${api.version}")
    private String apiVersion;

    @GetMapping(path = "/api/values")
    public ResponseEntity<String> getValue() {
        return ResponseEntity.status(HttpStatus.OK)
                .body("{\n" +
                        "\t\"apiVersion\": " + apiVersion + "\n" +
                        "}");
    }

    @GetMapping(path = "team/findByCode")
    public ResponseEntity<Team> findByCode(@RequestParam (value = "code") String code) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(teamUseCase.findByCode(code));
    }

    @PostMapping(path = "team/createTeam")
    public ResponseEntity<Team> createTeam(@RequestBody(required = true) Team team) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(teamUseCase.createTeam(team));
    }

    @PostMapping(path = "team/modifyTeam")
    public ResponseEntity<Team> modifyTeam(@RequestBody(required = true) Team team) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(teamUseCase.createTeam(team));
    }
}
