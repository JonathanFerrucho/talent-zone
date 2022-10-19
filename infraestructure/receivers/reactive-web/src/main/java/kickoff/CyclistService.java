package kickoff;

import kickoff.cyclist.Cyclist;
import kickoff.cyclist.CyclistUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@RestController
@RequiredArgsConstructor
public class CyclistService {

    private final CyclistUseCase cyclistUseCase;

    @GetMapping(path = "cyclist/findByCode")
    public ResponseEntity<Cyclist> findByCode(@RequestParam (value = "code") String code) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(cyclistUseCase.findByCode(code));
    }

    @PostMapping(path = "cyclist/createCyclist")
    public ResponseEntity<Cyclist> createCyclist(@RequestBody(required = true) Cyclist cyclist) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(cyclistUseCase.createCyclist(cyclist));
    }

    @PostMapping(path = "cyclist/modifyTeam")
    public ResponseEntity<Cyclist> modifyTeam(@RequestBody(required = true) Cyclist cyclist) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(cyclistUseCase.modifyCyclist(cyclist));
    }

    @PostMapping(path = "cyclist/getCyclist")
    public ResponseEntity<List<Cyclist>> getCyclist(@RequestBody(required = true) Cyclist cyclist) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(cyclistUseCase.getCyclist(cyclist));
    }
}
