package fr.ancyracademy.esportsclash.player;

import java.util.UUID;

public class CreatePlayerUseCase {
    private PlayerRepository playerRepository;
     CreatePlayerUseCase(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }
    public IdResponse execute(String name){
     Player player = new Player(UUID.randomUUID().toString(), name);
     playerRepository.save(player);
     return new IdResponse(player.getId());
    }
}
