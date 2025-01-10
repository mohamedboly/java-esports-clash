package fr.ancyracademy.esportsclash.player.application.port.usecases;

import an.awesome.pipelinr.Command;

import fr.ancyracademy.esportsclash.player.infrastructure.persistence.ram.InMemoryPlayerRepository;
import fr.ancyracademy.esportsclash.player.domain.model.Player;
import fr.ancyracademy.esportsclash.player.domain.viewmodel.IdResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

// Commande pour gérer "CreatePlayerUseCase"
@Component
public class CreatePlayerCommandHandler implements Command.Handler<CreatePlayerCommand, IdResponse> {
    private InMemoryPlayerRepository inMemoryPlayerRepository;
     public CreatePlayerCommandHandler(InMemoryPlayerRepository inMemoryPlayerRepository){
        this.inMemoryPlayerRepository = inMemoryPlayerRepository;
    }


    @Override
    public IdResponse handle(CreatePlayerCommand command) {
        // Récupérer le nom du joueur depuis la commande
        String name = command.getName();

        // Créer un nouvel objet Player
        Player player = new Player(UUID.randomUUID().toString(), name);

        // Sauvegarder dans le repository
        inMemoryPlayerRepository.save(player);

        // Retourner une réponse contenant l'ID
        return new IdResponse(player.getId());
    }


}
