package com.pokemonapp.demo.service;

import com.pokemonapp.demo.model.Pokemon;
import com.pokemonapp.demo.model.PokemonWithAttacksDTO;

import java.util.List;

public interface PokemonService {

    Pokemon create(Pokemon pokemon);

    List<Pokemon> read();

    List<PokemonWithAttacksDTO> readAllPokemonsWithAttacks();

    Pokemon modify(Long id, Pokemon pokemon);

    String delete(Long id);
}
