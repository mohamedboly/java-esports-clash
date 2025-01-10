package fr.ancyracademy.esportsclash.player;

import fr.ancyracademy.esportsclash.player.application.port.usecases.CreatePlayerCommand;
import fr.ancyracademy.esportsclash.player.application.port.usecases.CreatePlayerCommandHandler;
import fr.ancyracademy.esportsclash.player.application.port.usecases.CreatePlayerCommandHandler;
import fr.ancyracademy.esportsclash.player.domain.model.Player;
import fr.ancyracademy.esportsclash.player.infrastructure.persistence.ram.InMemoryPlayerRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class CreatePlayerTests {
    @Test
    void shoudCreatePlayer(){
        var playerRepository = new InMemoryPlayerRepository();
        var useCase = new CreatePlayerCommandHandler(playerRepository);
        var command = new CreatePlayerCommand("boly");
        var  idResponse = useCase.handle(command);
        Player expectecPlayer = new Player(idResponse.getId(), "boly");
        Player actualPlayer = playerRepository.findById(expectecPlayer.getId());
        Assert.assertEquals(expectecPlayer.getId(), actualPlayer.getId());

    }
}
