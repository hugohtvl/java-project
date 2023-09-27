package com.pokemonapp.demo.model;

public class PokemonWithAttacksDTO {
    
    private Long id;
    private String name;
    private String attackName;
    private Short attackPower;
    private String imgUrl;

    // Ajoutez des getters et des setters ici

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttackName() {
        return attackName;
    }

    public void setAttackName(String attackName) {
        this.attackName = attackName;
    }

    public Short getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(Short attackPower) {
        this.attackPower = attackPower;
    }

    public void setImgurl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgurl() {
        return imgUrl;
    }
}

