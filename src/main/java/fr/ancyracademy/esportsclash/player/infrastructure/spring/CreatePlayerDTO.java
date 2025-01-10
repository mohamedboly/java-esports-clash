package fr.ancyracademy.esportsclash.player.infrastructure.spring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePlayerDTO {
    private String name;
}
