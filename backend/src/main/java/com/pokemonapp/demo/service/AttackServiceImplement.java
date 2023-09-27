package com.pokemonapp.demo.service;

import com.pokemonapp.demo.model.Attack;
import com.pokemonapp.demo.repository.AttackRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class AttackServiceImplement implements AttackService {

    private final AttackRepository attackRepository;
    @Override
    public Attack create(Attack attack) {
        return attackRepository.save(attack);
    }

    @Override
    public List<Attack> read() {
        return attackRepository.findAll();
    }

    // @Override
    // public Attack modify(Long id, Attack attack) {
    //     return attackRepository.findById(id)
    //             .map(p -> {
    //                 p.setName(attack.getName());
    //                 p.setPower(attack.getPower());
    //                 return attackRepository.save(p);
    //             }).orElseThrow(() -> new RuntimeException("Attack not find"));
    // }

    @Override
    @Transactional
    public Attack modify(Long id, Attack attack) {
        // Vérifiez d'abord si l'attaque existe
        Attack existingAttack = attackRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attack not found"));
    
        // Mettez à jour les propriétés de l'attaque existante avec les valeurs de l'attaque passée en paramètre
        existingAttack.setName(attack.getName());
        existingAttack.setPower(attack.getPower());
    
        // Enregistrez la mise à jour dans la base de données
        return attackRepository.save(existingAttack);
    }
    


    @Override
    public String delete(Long id) {
        attackRepository.deleteById(id);
        return "Attack deleted";
    }
}
