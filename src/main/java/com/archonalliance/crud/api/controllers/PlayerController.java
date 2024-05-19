package com.archonalliance.crud.api.controllers;

import com.archonalliance.crud.api.entities.Player;
import com.archonalliance.crud.api.exceptions.PlayerNotFoundException;
import com.archonalliance.crud.api.services.PlayerService;
import com.archonalliance.crud.api.services.TeamService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class PlayerController {

    private final PlayerService playerService;
    private final TeamService teamService;


    public PlayerController(PlayerService playerService, TeamService teamService) {
        this.playerService = playerService;
        this.teamService = teamService;
    }

    @GetMapping("/admin/users")
    public String showUsers(Model model) {
        List<Player> players = playerService.getAllPlayers();
        model.addAttribute("players", players); // Add the list of players to the model
        return "admin_users";
    }

    @PostMapping("/admin/users/delete/{playerId}")
    @Transactional
    public String deleteUser(@PathVariable String playerId) {
        teamService.deleteTeamByPlayerId(playerId);
        playerService.deletePlayerById(playerId);
        return "redirect:/admin/users";
    }

    @PostMapping("/admin/userId/deletePlayer/{playerId}")
    @Transactional
    public String deleteUserFindingId(@PathVariable String playerId){
        Optional<Player> player = playerService.findById(playerId);
        if (player.isPresent()){
            teamService.deleteTeamByPlayerId(playerId);
            playerService.deletePlayerById(playerId);
            return "redirect:/admin/users";
        }
        else
            throw new PlayerNotFoundException();
    }

    @GetMapping("/admin/userById")
    public String showUserByIdPage() {
        return "admin_user_id";
    }
}

