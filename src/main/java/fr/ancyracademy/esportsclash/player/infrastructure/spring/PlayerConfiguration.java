package fr.ancyracademy.esportsclash.player.infrastructure.spring;

import fr.ancyracademy.esportsclash.player.application.port.PlayerRepository;
import fr.ancyracademy.esportsclash.player.infrastructure.persistence.jpa.SQLPlayerDataAccessor;
import fr.ancyracademy.esportsclash.player.infrastructure.persistence.jpa.SQLPlayerRepository;
import fr.ancyracademy.esportsclash.player.infrastructure.persistence.ram.InMemoryPlayerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlayerConfiguration {
    @Bean
    public PlayerRepository playerRepository(SQLPlayerDataAccessor sqlPlayerDataAccessor){
        return new SQLPlayerRepository(sqlPlayerDataAccessor);
    }
}
