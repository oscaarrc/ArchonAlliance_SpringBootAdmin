package com.archonalliance.crud.api.services;

import java.util.List;
import java.util.Optional;

import com.archonalliance.crud.api.entities.Player;
import com.archonalliance.crud.api.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> findById(String id) {
        return playerRepository.findById(id);
    }


    public void deletePlayerById(String playerId) {
        playerRepository.deletePlayerById(playerId);
    }
}

