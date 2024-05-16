package com.archonalliance.crud.api.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "characters")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Character {

    @Id
    @Column(name = "name", length = 40)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "element", length = 20)
    private Element element;

    @Column(name = "img", length = 200)
    private String img;

    @NotNull
    @Column(name = "img_Banner", length = 200)
    private String imgBanner;

    @Enumerated(EnumType.STRING)
    @Column(name = "weapon", length = 20)
    private Weapon weapon;

    @Column(name = "rareza", length = 1)
    private String rarity;

    public enum Element {
        Anemo, Geo, Pyro, Cryo, Hydro, Electro, Dendro
    }

    public enum Weapon {
        Espada_ligera, Mandoble, Arco, Catalizador, Lanza
    }
}
