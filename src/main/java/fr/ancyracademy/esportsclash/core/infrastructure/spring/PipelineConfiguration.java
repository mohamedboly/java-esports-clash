package fr.ancyracademy.esportsclash.core.infrastructure.spring;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Notification;
import an.awesome.pipelinr.Pipelinr;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import an.awesome.pipelinr.Pipeline;

@Configuration
public class PipelineConfiguration {

    @Bean
    Pipeline pipeline(
            ObjectProvider<Command.Handler> commandHandlers,    // Gestionnaires de commandes
            ObjectProvider<Command.Middleware> middlewares,     // Middlewares
            ObjectProvider<Notification.Handler> notificationHandlers // Gestionnaires de notifications
    ) {
        // Création du pipeline avec les éléments injectés
        return new Pipelinr()
                .with(commandHandlers::orderedStream)      // Ajouter les gestionnaires de commandes
                .with(middlewares::orderedStream)          // Ajouter les middlewares
                .with(notificationHandlers::orderedStream);// Ajouter les gestionnaires de notifications
    }
}

