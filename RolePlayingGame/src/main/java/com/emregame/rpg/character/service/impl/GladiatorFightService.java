package com.emregame.rpg.character.service.impl;

import java.util.concurrent.TimeUnit;

import com.emregame.rpg.character.model.GameCharacter;
import com.emregame.rpg.character.model.Gladiator;
import com.emregame.rpg.character.service.FightService;
import com.emregame.rpg.io.SpartacusGameReader;
import com.emregame.rpg.io.SpartacusGameWriter;
import com.emregame.rpg.map.model.City;
import com.emregame.rpg.map.model.MapPoint;

public class GladiatorFightService implements FightService {

    @Override
    public GameCharacter fight(GameCharacter first, GameCharacter second) {
	Gladiator gladiator1 = (Gladiator) first;
	Gladiator gladiator2 = (Gladiator) second;
	
	SpartacusGameWriter.printInfo("Combat between " + gladiator1.getName() + " and " + gladiator2.getName() + " is starting");
	while (true) {
	    try {
		gladiator1.attack(gladiator2);
		SpartacusGameWriter.printInfo(gladiator1.getName() +  " is attacking...");
		TimeUnit.SECONDS.sleep(1);
		SpartacusGameWriter.printInfo(gladiator2.getName() + " got hurt." + gladiator2.getName()  + "'s remaining health: "
			+ gladiator2.getCurrentHealth());
		TimeUnit.SECONDS.sleep(1);
		if (gladiator2.isDead()) {
		    SpartacusGameWriter.printInfo(gladiator2.getName() + " is dead." + gladiator1.getName() + " WON!!!");
		    TimeUnit.SECONDS.sleep(1);
		    return gladiator1;
		}
		SpartacusGameWriter.printInfo(gladiator2.getName() + " is attacking...");
		TimeUnit.SECONDS.sleep(1);
		gladiator2.attack(gladiator1);
		SpartacusGameWriter.printInfo(gladiator1.getName() + " got hurt." + gladiator1.getName() + "'s remaining health: " + gladiator1.getCurrentHealth());
		TimeUnit.SECONDS.sleep(1);
		if (gladiator1.isDead()) {
		    SpartacusGameWriter.printInfo(gladiator1.getName() + " is dead."+ gladiator1.getName() +" LOST!!!");
		    TimeUnit.SECONDS.sleep(1);
		    return gladiator2;
		}
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }

	}
	
    }

    @Override
    public GameCharacter selectTarget(MapPoint mapPoint) {
	Gladiator opponentGladiator;
	City city = (City) mapPoint;
	while (true) {
	    SpartacusGameWriter.printFightMenu(city);
	    String commandString = SpartacusGameReader.readLine();
	    if (commandString.equalsIgnoreCase("back")) {
		return null;
	    }
	    opponentGladiator = city.getGladiatorMap().get(commandString);
	    if (opponentGladiator != null && opponentGladiator.isDead()) {
		SpartacusGameWriter.printInfo(opponentGladiator.getName()
			+ " is already dead. Select another gladiator or explore other cities");
	    }
	    if (opponentGladiator != null) {
		break;
	    }
	}

	return opponentGladiator;
    }

}
