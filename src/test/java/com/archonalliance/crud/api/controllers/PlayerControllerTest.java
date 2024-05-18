package com.archonalliance.crud.api.controllers;

import com.archonalliance.crud.api.entities.Player;
import com.archonalliance.crud.api.services.PlayerService;
import com.archonalliance.crud.api.services.TeamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PlayerControllerTest {

    @Mock
    private PlayerService playerService;

    @Mock
    private TeamService teamService;

    @Mock
    private Model model;

    @InjectMocks
    private PlayerController playerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testShowUsers() {
        // Arrange
        List<Player> players = new ArrayList<>();
        players.add(new Player("123456789", "password1", "oscar", "58", "8",
                "aether.png", "CUANDO SE ACABA GENSHIN"));
        players.add(new Player("987654321", "password2", "javier", "60", "8",
                "lumine.png", "Yelan Step on Me"));

        when(playerService.getAllPlayers()).thenReturn(players); //"when" configures the performance

        // Act
        String viewName = playerController.showUsers(model);

        // Assert
        assertEquals("admin_users", viewName);
        verify(playerService, times(1)).getAllPlayers();
        verify(model, times(1)).addAttribute("players", players);
    }

    @Test
    void testDeleteUser() {
        // Arrange
        String playerId = "123456789";

        // Act
        String viewName = playerController.deleteUser(playerId);

        // Assert
        assertEquals("redirect:/admin/users", viewName);
        verify(teamService, times(1)).deleteTeamByPlayerId(playerId);
        verify(playerService, times(1)).deletePlayerById(playerId);
    }

    @Test
    void testShowUserByIdPage() {
        // Act
        String viewName = playerController.showUserByIdPage();

        // Assert
        assertEquals("admin_user_id", viewName);
    }
}
