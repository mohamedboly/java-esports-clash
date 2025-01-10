package fr.ancyracademy.esportsclash.player.application.port.usecases;

import an.awesome.pipelinr.Command;
import fr.ancyracademy.esportsclash.player.domain.viewmodel.IdResponse;

// Classe de commande pour créer un joueur
public  class CreatePlayerCommand implements Command<IdResponse> {
    private  String name;

    public CreatePlayerCommand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
}
