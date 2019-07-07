package com.emregame.rpg.character.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.emregame.rpg.character.enums.ShieldType;
import com.emregame.rpg.character.enums.WeaponType;
import com.emregame.rpg.character.model.GameCharacter;
import com.emregame.rpg.character.model.Gladiator;
import com.emregame.rpg.character.service.FightService;
import com.emregame.rpg.character.service.impl.GladiatorFightService;
import com.emregame.rpg.util.GladiatorGenerator;

public class GladiatorFightServiceTest {
    FightService gladiatorFightService = new GladiatorFightService();
    
    @Test
    public void testFight() {
	Gladiator gladiator1 = GladiatorGenerator.createGladiator("yunus", 100, 0, WeaponType.SPEAR, ShieldType.CHAINMAIL);
	Gladiator gladiator2 = GladiatorGenerator.createGladiator("spartacus", 80, 0, WeaponType.SWORD, ShieldType.HELMET);
	GameCharacter winner = gladiatorFightService.fight(gladiator1, gladiator2);
	assertEquals(gladiator1, winner);
    }
    
}
