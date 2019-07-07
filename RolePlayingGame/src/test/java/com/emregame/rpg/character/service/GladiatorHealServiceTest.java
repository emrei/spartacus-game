package com.emregame.rpg.character.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.emregame.rpg.character.enums.ShieldType;
import com.emregame.rpg.character.enums.WeaponType;
import com.emregame.rpg.character.model.Gladiator;
import com.emregame.rpg.character.service.impl.GladiatorHealService;
import com.emregame.rpg.util.GladiatorGenerator;

public class GladiatorHealServiceTest {
    HealService gladiatorHealService = new GladiatorHealService();
    
    @Test
    public void testHeal() {
	Gladiator gladiator = GladiatorGenerator.createGladiator("spartacus", 80, 0, WeaponType.SWORD, ShieldType.HELMET);
	gladiator.setCurrentHealth(60);
	int healPack = 30;
	int remainingHealPack = gladiatorHealService.heal(gladiator, healPack);
	assertEquals(10, remainingHealPack);
    }
    
}
