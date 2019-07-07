package com.emregame.rpg.player.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.emregame.rpg.character.enums.ShieldType;
import com.emregame.rpg.character.enums.WeaponType;
import com.emregame.rpg.character.model.Gladiator;
import com.emregame.rpg.player.model.Player;
import com.emregame.rpg.player.model.SpartacusPlayer;
import com.emregame.rpg.player.service.impl.SpartacusPlayerService;
import com.emregame.rpg.util.GladiatorGenerator;

public class SpartacusPlayerServiceTest {
    SpartacusPlayerService spartacusPlayerService = new SpartacusPlayerService();
    Gladiator gladiator;
    
    @BeforeEach
    public void init() {
	gladiator = GladiatorGenerator.createGladiator("Spartacus", 100, 2, WeaponType.SWORD, ShieldType.CHAINMAIL);
    }
    
    @Test
    public void testCreatePlayer() {
	Player actualPlayer = spartacusPlayerService.createPlayer("Yunus", gladiator);
	SpartacusPlayer expectedPlayer = new SpartacusPlayer();
	expectedPlayer.setGladiator(gladiator);
	expectedPlayer.setName("Yunus");
	assertEquals(expectedPlayer, actualPlayer);
    }
}
