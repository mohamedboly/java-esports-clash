package fr.ancyracademy.esportsclash.player;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerRepository playerRepository;
    public PlayerController(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    @PostMapping(path = "")
    public ResponseEntity<IdResponse> createPlayer(@RequestBody CreatePlayerDTO dto){
        var useCase = new  CreatePlayerUseCase(playerRepository);
        var result = useCase.execute(dto.getName());

        return  new ResponseEntity<>(new IdResponse(result.getId()), HttpStatus.CREATED);
    }
}
