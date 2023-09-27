package com.pokemonapp.demo.controller;

import com.pokemonapp.demo.model.Attack;
import com.pokemonapp.demo.service.AttackService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attack")
@AllArgsConstructor
public class AttackController {

    private final AttackService attackService;

    @PostMapping("/create")
    public Attack create(@RequestBody Attack attack) {
        return attackService.create(attack);
    }

    @GetMapping("/read")
    public List<Attack> read() {
        return attackService.read();
    }

    @PutMapping("/update/{id}")
    public Attack update(@PathVariable Long id, @RequestBody Attack attack) {
        return attackService.modify(id, attack);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return attackService.delete(id);
    }
}

