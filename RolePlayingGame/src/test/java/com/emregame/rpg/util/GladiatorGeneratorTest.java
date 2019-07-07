package com.emregame.rpg.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.emregame.rpg.character.enums.ShieldType;
import com.emregame.rpg.character.enums.WeaponType;
import com.emregame.rpg.character.model.Gladiator;
import com.emregame.rpg.util.GladiatorGenerator;

public class GladiatorGeneratorTest {
    @Test
    public void testGenerateGladitorList() {
	List<Gladiator> gladiatorList = GladiatorGenerator.generateGladitorList();
	assertEquals("spartacus", gladiatorList.get(0).getName());
	assertEquals("agron", gladiatorList.get(4).getName());
	assertEquals(75, gladiatorList.get(7).getMaxHealth());
	assertEquals(WeaponType.SPEAR, gladiatorList.get(5).getWeapon());
	assertEquals(ShieldType.CHAINMAIL, gladiatorList.get(0).getShield());
	assertEquals(11, gladiatorList.size());
    }
    
    @Test
    public void testCreateGladiator() {
	Gladiator expectedGladiator = new Gladiator();
	String name = "crixus";
	int maxHealth = 95;
	int experience = 10;
	WeaponType weapon = WeaponType.SWORD;
	ShieldType shield = ShieldType.HELMET;
	expectedGladiator.setName(name);
	expectedGladiator.setExperience(experience);
	expectedGladiator.setMaxHealth(maxHealth);
	expectedGladiator.prepareFight(weapon, shield);
	
	Gladiator actualGladiator = GladiatorGenerator.createGladiator("crixus", maxHealth, experience, weapon, shield);
	assertEquals(expectedGladiator, actualGladiator);
	
    }
}
