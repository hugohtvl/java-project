package com.pokemonapp.demo.repository;

import com.pokemonapp.demo.model.Attack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AttackRepository extends JpaRepository<Attack, Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE attack SET name = ?, power = ? WHERE id = ?", nativeQuery = true)
    int updateAttack(Long id, String name, int power);
}