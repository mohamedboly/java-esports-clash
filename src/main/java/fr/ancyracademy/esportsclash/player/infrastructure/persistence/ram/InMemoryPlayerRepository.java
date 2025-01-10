package fr.ancyracademy.esportsclash.player.infrastructure.persistence.ram;

import fr.ancyracademy.esportsclash.player.domain.model.Player;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import fr.ancyracademy.esportsclash.player.application.port.PlayerRepository;

@Data
public class InMemoryPlayerRepository implements PlayerRepository {
    Map<String, Player> players = new HashMap<>();
    @Override
    public Player findById(String id){
    return  players.get(id);
    }
    @Override
    public void save(Player player){
        players.put(player.getId(), player);
    }
}
