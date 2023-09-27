package com.pokemonapp.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name ="pokemon")
@Getter
@Setter
@NoArgsConstructor

public class Pokemon {

    // @ManyToMany
    // @JoinTable(
    //     name = "pokemon_has_attack",
    //     joinColumns = @JoinColumn(name = "pokemon_id"),
    //     inverseJoinColumns = @JoinColumn(name = "attack_id")
    // )

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150)
    private String name;

    @Column()
    private Short hp;

    @Column(length = 50)
    private String favourite_attack;

    @Column(length = 150)
    private String img_url;
}
