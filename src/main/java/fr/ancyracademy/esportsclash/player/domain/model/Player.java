package fr.ancyracademy.esportsclash.player.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private String id;
    private  String name;
    public Player(String name){
        this.name = name;
    }
}
