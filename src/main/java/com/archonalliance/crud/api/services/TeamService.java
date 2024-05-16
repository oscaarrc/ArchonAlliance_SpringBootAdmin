package com.archonalliance.crud.api.services;

import com.archonalliance.crud.api.entities.Team;
import com.archonalliance.crud.api.repositories.TeamRepository;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Service
@ToString
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public void deleteTeamByPlayerId(String id){
        teamRepository.deleteTeamByPlayerUid(id);
    }

    public String getAllByIdPlayerId(String id){
        return teamRepository.findAllByPlayerUid(id).toString();
    }


}
