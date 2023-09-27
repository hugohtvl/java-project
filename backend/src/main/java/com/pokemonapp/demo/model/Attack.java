package com.pokemonapp.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name ="attack")
@Getter
@Setter
@NoArgsConstructor

public class Attack {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 99)
    private String name;

    @Column(length = 99)
    private Short power;
}
