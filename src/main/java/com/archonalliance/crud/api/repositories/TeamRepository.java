package com.archonalliance.crud.api.repositories;

import com.archonalliance.crud.api.entities.Team;
import io.micrometer.common.lang.NonNullApi;
import lombok.ToString;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@NonNullApi
public interface TeamRepository extends JpaRepository<Team, String> {


    List<Team> findAllByPlayerUid(String playerUid);

    @Modifying
    @Query("delete from Team t where t.playerUid = :playerUid")
    void deleteTeamByPlayerUid(@Param("playerUid") String playerUid);
}
