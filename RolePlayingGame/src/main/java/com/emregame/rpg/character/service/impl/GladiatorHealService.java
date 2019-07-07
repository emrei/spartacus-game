package com.emregame.rpg.character.service.impl;

import java.util.concurrent.TimeUnit;

import com.emregame.rpg.character.model.GameCharacter;
import com.emregame.rpg.character.model.Gladiator;
import com.emregame.rpg.character.service.HealService;
import com.emregame.rpg.io.SpartacusGameWriter;

public class GladiatorHealService implements HealService {

    @Override
    public int heal(GameCharacter gameCharacter, int healPack) {
	if(healPack <= 0) {
	    SpartacusGameWriter.printInfo("There is no health package in this city..");
	    return 0;
	}
	Gladiator gladiator = (Gladiator) gameCharacter;
	int previous = gladiator.getCurrentHealth();
	gladiator.setCurrentHealth(
		Math.min(gladiator.getCurrentHealth() + healPack, gladiator.getMaxHealth()));
	SpartacusGameWriter.printInfo("Your gladiator got a health pack...");
	try {
	    TimeUnit.SECONDS.sleep(2);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	SpartacusGameWriter.printInfo("Now current health is " + gladiator.getCurrentHealth());
	return healPack - (gladiator.getCurrentHealth() - previous);
	
    }
    

}
