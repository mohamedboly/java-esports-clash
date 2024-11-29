package fr.ancyracademy.esportsclash.player;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class PlayerRepository {
    Map<String, Player> players = new HashMap<>();
    public Player find(String id){
    return  players.get(id);
    }
    public void save(Player player){
        players.put(player.getId(), player);
    }
}
