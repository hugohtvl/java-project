package com.pokemonapp.demo.service;

import com.pokemonapp.demo.model.Pokemon;
import com.pokemonapp.demo.model.PokemonWithAttacksDTO;
import com.pokemonapp.demo.repository.PokemonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PokemonServiceImplement implements PokemonService {

    private final PokemonRepository pokemonRepository;
    @Override
    public Pokemon create(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    @Override
    public List<Pokemon> read() {
        return pokemonRepository.findAll();
    }

   @Override
    public List<PokemonWithAttacksDTO> readAllPokemonsWithAttacks() {
    List<Object[]> results = pokemonRepository.readAllPokemonsWithAttacks();
    List<PokemonWithAttacksDTO> dtos = new ArrayList<>();

    for (Object[] row : results) {
        PokemonWithAttacksDTO dto = new PokemonWithAttacksDTO();
        dto.setId((Long) row[0]);
        dto.setName((String) row[1]);
        dto.setAttackName((String) row[2]);
        dto.setAttackPower((Short) row[3]);
        dto.setImgurl((String) row[4]);
        dtos.add(dto);
    }

    return dtos;
    }
//    @Override
//     public List<PokemonWithAttacksDTO> readAllPokemonsWithAttacks() {
//     List<PokemonWithAttacksDTO> results = pokemonRepository.findAll();
//     }



    @Override
    public Pokemon modify(Long id, Pokemon pokemon) {
        return pokemonRepository.findById(id)
                .map(p -> {
                    p.setName(pokemon.getName());
                    p.setHp(pokemon.getHp());
                    p.setFavourite_attack(pokemon.getFavourite_attack());
                    return pokemonRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Pokemon not find"));
    }

    @Override
    public String delete(Long id) {
        pokemonRepository.deleteById(id);
        return "Pokemon deleted";
    }
}
