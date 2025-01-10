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
        var sqlPlayerQuery = sqlPlayerDataAccessor.findById(id);
        if (sqlPlayerQuery.isEmpty()){
            return null;
        }
        var sqlPlayer = sqlPlayerQuery.get();
        var player = new Player(sqlPlayer.getId(), sqlPlayer.getName());
        return player;

    }

    @Override
    public void save(Player player) {
        var sqlPlayer = new SQLPlayer(player.getId(), player.getName());
        sqlPlayerDataAccessor.save(sqlPlayer);
    }
}
