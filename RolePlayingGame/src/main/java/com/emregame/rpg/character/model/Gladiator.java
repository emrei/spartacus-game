package com.emregame.rpg.character.model;

import java.io.Serializable;
import java.util.Objects;

import com.emregame.rpg.character.enums.ShieldType;
import com.emregame.rpg.character.enums.WeaponType;

public class Gladiator extends GameCharacter implements Fighter, Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 7039867584465672852L;
    private int maxHealth;
    private int currentHealth;
    private int attack;
    private int defense;
    private int experience;
    private int agility;
    private WeaponType weapon;
    private ShieldType shield;

    public int getCurrentHealth() {
	return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
	this.currentHealth = currentHealth;
    }

    public int getAttack() {
	return attack;
    }

    public int getDefense() {
	return defense;
    }

    public int getExperience() {
	return experience;
    }

    public void setExperience(int experience) {
	this.experience = experience;
    }

    public int getAgility() {
	return agility;
    }

    public int getMaxHealth() {
	return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
	this.maxHealth = maxHealth;
    }

    public WeaponType getWeapon() {
	return weapon;
    }

    public ShieldType getShield() {
	return shield;
    }

    public void prepareFight(WeaponType weapon, ShieldType shield) {
	this.weapon = weapon;
	this.shield = shield;
	this.agility = weapon.getPositiveAgility() - shield.getNegativeAgility();
	this.attack = weapon.getAttackValue() + agility;
	this.defense = shield.getDefenseValue();

    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + Objects.hash(agility, attack, defense, maxHealth, experience, shield, weapon);
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (!super.equals(obj))
	    return false;
	if (!(obj instanceof Gladiator))
	    return false;
	Gladiator other = (Gladiator) obj;
	return agility == other.agility && attack == other.attack && defense == other.defense
		&& maxHealth == other.maxHealth && experience == other.experience && shield == other.shield && weapon == other.weapon;
    }

    @Override
    public void attack(Fighter fighter) {
	fighter.damage(getAttack());
	if (fighter.isDead()) {
	    gainExperience();
	}

    }

    @Override
    public int damage(int takenDamage) {
	int actualDamage = Math.max(takenDamage - this.getDefense(), 0);
	int actualCurrentHealth = Math.max(this.getCurrentHealth() - actualDamage, 0);
	this.setCurrentHealth(actualCurrentHealth);
	return actualDamage;
    }

    @Override
    public boolean isDead() {
	return this.getCurrentHealth() <= 0;
    }

    @Override
    public void gainExperience() {
	// TODO: max experience
	this.setExperience(this.getExperience() + 1);

    }

}
