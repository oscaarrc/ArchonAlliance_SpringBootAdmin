package com.archonalliance.crud.api.repositories;

import com.archonalliance.crud.api.entities.Player;
import io.micrometer.common.lang.NonNullApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@NonNullApi
public interface PlayerRepository extends JpaRepository<Player, String> {

    @Modifying
    @Query("delete from Player p where p.id = :id")
    void deletePlayerById(@Param("id") String id);
}
