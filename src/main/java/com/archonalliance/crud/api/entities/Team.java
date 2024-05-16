package com.archonalliance.crud.api.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "teams")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_team")
    private Integer teamId;

    @Column(name = "player_uid", length = 9)
    private String playerUid;

    @Column(name = "character1", length = 30)
    private String character1;

    @Column(name = "character2", length = 30)
    private String character2;

    @Column(name = "character3", length = 30)
    private String character3;

    @Column(name = "character4", length = 30)
    private String character4;

    @Column(name = "teamPFP", length = 50)
    private String teamPFP;
}
