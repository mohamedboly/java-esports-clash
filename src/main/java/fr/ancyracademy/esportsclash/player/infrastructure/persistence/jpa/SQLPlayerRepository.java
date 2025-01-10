package fr.ancyracademy.esportsclash.player.infrastructure.persistence.jpa;

import fr.ancyracademy.esportsclash.player.application.port.PlayerRepository;
import fr.ancyracademy.esportsclash.player.domain.model.Player;

public class SQLPlayerRepository implements PlayerRepository {
    private final SQLPlayerDataAccessor sqlPlayerDataAccessor;

    public SQLPlayerRepository(SQLPlayerDataAccessor sqlPlayerDataAccessor){
        this.sqlPlayerDataAccessor = sqlPlayerDataAccessor;
    }
    @Override
    public Player findById(String id) {
        return sqlPlayerDataAccessor.findById(id).get();

    }

    @Override
    public void save(Player player) {

        sqlPlayerDataAccessor.save(player);
    }
}
