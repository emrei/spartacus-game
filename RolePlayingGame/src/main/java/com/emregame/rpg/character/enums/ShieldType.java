package com.emregame.rpg.character.enums;

public enum ShieldType {
    HELMET("helmet", "Potect head", 5, 2),
    SCUTUM("scutum", "A rectangular shield protects body", 8, 4),
    KITE("kite", "A kite shield protects mostly upper body", 7, 3),
    ARMOR ("armor", "Full armor protects whole body", 10, 5),
    CHAINMAIL("chainmail", "An thin armor protects upper body", 7, 2);
    
    String name;
    String description;
    int defenseValue;
    int negativeAgility;
    private ShieldType(String name, String description, int defenseValue, int agility) {
	this.name = name;
	this.description = description;
	this.defenseValue = defenseValue;
	this.negativeAgility = agility;
    }
    
    public String getName() {
	return name;
    }
    
    public String getDescription() {
	return description;
    }
    
    public int getDefenseValue() {
	return defenseValue;
    }
    
    public int getNegativeAgility() {
	return negativeAgility;
    }
    
}
