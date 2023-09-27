package com.pokemonapp.demo.controller;

import com.pokemonapp.demo.model.Pokemon;
import com.pokemonapp.demo.model.PokemonWithAttacksDTO;
import com.pokemonapp.demo.service.PokemonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
@AllArgsConstructor
@CrossOrigin(origins = "*") // Remplacez "http://localhost:3000" par l'URL de votre front-end
public class PokemonController {

    private final PokemonService pokemonService;

    @PostMapping("/create")
    public Pokemon create(@RequestBody Pokemon pokemon) {
        return pokemonService.create(pokemon);
    }

    @GetMapping("/read")
    public List<Pokemon> read() {
        return pokemonService.read();
    }

    @GetMapping("/readallwithattack")
    public List<PokemonWithAttacksDTO> readAllPokemonsWithAttacks() {
        return pokemonService.readAllPokemonsWithAttacks();
    }

    @PutMapping("/update/{id}")
    public Pokemon update(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        return pokemonService.modify(id, pokemon);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return pokemonService.delete(id);
    }
}
