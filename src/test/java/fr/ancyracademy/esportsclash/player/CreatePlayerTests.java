package fr.ancyracademy.esportsclash.player;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class CreatePlayerTests {
    @Test
    void shoudCreatePlayer(){
        var playerRepository = new PlayerRepository();
        var useCase = new CreatePlayerUseCase(playerRepository);
        var  idResponse = useCase.execute("boly");
        Player expectecPlayer = new Player(idResponse.getId(), "boly");
        Player actualPlayer = playerRepository.find(expectecPlayer.getId());
        Assert.assertEquals(expectecPlayer.getId(), actualPlayer.getId());

    }
}
