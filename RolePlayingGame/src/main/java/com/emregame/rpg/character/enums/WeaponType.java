package com.emregame.rpg.character.enums;

public enum WeaponType {
    SWORD("sword", "For attacking closely", 20, 10), 
    BOW("bow", "For attacking at a distance", 12, 14),
    SPEAR("spear", "A long weapon with a sharp point at the end", 16, 8),
    TRIDENT("tredient", "A long weapon with three sharp metal points", 19, 8),
    HAMMER("hammer", "Big hammer with highly damage", 25, 6), 
    NET("net", "Threads of rope to catch enemy", 14, 9),
    LANCEA("lancea", "A Short spear to stick enemy", 14, 12);

    String name;
    String description;
    int attackValue;
    int positiveAgility;

    private WeaponType(String name, String description, int attackValue, int positiveAgility) {
	this.name = name;
	this.description = description;
	this.attackValue = attackValue;
	this.positiveAgility = positiveAgility;
    }

    public String getName() {
	return name;
    }

    public String getDescription() {
	return description;
    }

    public int getAttackValue() {
	return attackValue;
    }

    public int getPositiveAgility() {
	return positiveAgility;
    }

}
