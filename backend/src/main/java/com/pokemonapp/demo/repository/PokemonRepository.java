package com.pokemonapp.demo.repository;

import com.pokemonapp.demo.model.Pokemon;
// import com.pokemonapp.demo.model.PokemonWithAttacksDTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    @Query(value = "SELECT p.id, p.name, a.name as attackName, a.power as attackPower, p.img_url as imgUrl\n" +
    "FROM pokemon as p\n" +
    "JOIN pokemon_has_attack as pha\n" +
    "ON pha.pokemon_id = p.id\n" +
    "JOIN attack as a\n" +
    "ON pha.attack_id = a.id", nativeQuery = true)

    List<Object[]> readAllPokemonsWithAttacks();
}
