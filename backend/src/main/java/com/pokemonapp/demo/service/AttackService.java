package com.pokemonapp.demo.service;

import com.pokemonapp.demo.model.Attack;

import java.util.List;

public interface AttackService {

    Attack create(Attack attack);

    List<Attack> read();

    Attack modify(Long id, Attack attack);

    String delete(Long id);
}