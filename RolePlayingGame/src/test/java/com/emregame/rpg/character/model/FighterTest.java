package com.emregame.rpg.character.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.emregame.rpg.character.enums.ShieldType;
import com.emregame.rpg.character.enums.WeaponType;
import com.emregame.rpg.util.GladiatorGenerator;

public class FighterTest {

    private Gladiator gladiator1, gladiator2;

    @BeforeEach
    public void init() {
	gladiator1 = GladiatorGenerator.createGladiator("Spartacus", 100, 2, WeaponType.SWORD, ShieldType.CHAINMAIL);
	gladiator2 = GladiatorGenerator.createGladiator("Crixus", 95, 1, WeaponType.HAMMER, ShieldType.HELMET);
    }

    @Test
    public void testAttack() {
	gladiator1.attack(gladiator2);
	gladiator2.attack(gladiator1);
	assertEquals(72, gladiator2.getCurrentHealth());
	assertEquals(78, gladiator1.getCurrentHealth());
	
    }

    @Test
    public void testDamage() {
	int actualDamage = gladiator1.damage(15);
	assertEquals(8, actualDamage);
    }

    @Test
    public void testIsDead() {
	assertEquals(false, gladiator1.isDead());
	gladiator2.setCurrentHealth(0);
	assertEquals(true, gladiator2.isDead());
    }

    @Test
    public void testGainExperience() {
	gladiator1.gainExperience();
	assertEquals(3, gladiator1.getExperience());
    }

}
