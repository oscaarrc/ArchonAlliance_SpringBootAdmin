package com.archonalliance.crud.api.entities;

import lombok.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "player")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Player {

    @Id
    @Column(name = "ID", length = 9)
    private String id;

    @Column(name = "passw", length = 64)
    private String password;

    @Column(name = "usrName", length = 30)
    private String userName;

    @Column(name = "lvl", length = 2)
    private String level;

    @Column(name = "WorldLevel", length = 1)
    private String worldLevel;

    @Column(name = "PFP", length = 200)
    private String profilePicture;

    @Column(name = "usrDescription", length = 100)
    private String userDescription;
}
