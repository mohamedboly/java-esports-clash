package fr.ancyracademy.esportsclash.player;

import fr.ancyracademy.esportsclash.PostgreSQLTestConfiguration;
import fr.ancyracademy.esportsclash.player.domain.viewmodel.IdResponse;
import fr.ancyracademy.esportsclash.player.infrastructure.persistence.ram.InMemoryPlayerRepository;
import fr.ancyracademy.esportsclash.player.infrastructure.spring.CreatePlayerDTO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
@Import(PostgreSQLTestConfiguration.class)
public class CreatePlayerE2ETests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private InMemoryPlayerRepository inMemoryPlayerRepository;

    @Test
    public void shoudCreateCreatePlayer() throws Exception {
        var createPlayerDTO = new CreatePlayerDTO("boly");
        var result = mockMvc.perform(MockMvcRequestBuilders.post("/players")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createPlayerDTO)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn();

        var idResponse = objectMapper.readValue(
                result.getResponse().getContentAsString(),
                IdResponse.class
        );

        var player = inMemoryPlayerRepository.findById(idResponse.getId());
        Assert.assertNotNull(player);
        Assert.assertEquals(createPlayerDTO.getName(), player.getName());
    }
}
