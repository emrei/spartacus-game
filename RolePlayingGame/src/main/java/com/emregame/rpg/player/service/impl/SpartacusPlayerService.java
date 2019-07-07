package com.emregame.rpg.player.service.impl;

import com.emregame.rpg.character.enums.ShieldType;
import com.emregame.rpg.character.enums.WeaponType;
import com.emregame.rpg.character.model.Gladiator;
import com.emregame.rpg.interpreter.service.impl.SpartacusInterpreter;
import com.emregame.rpg.io.SpartacusGameReader;
import com.emregame.rpg.io.SpartacusGameWriter;
import com.emregame.rpg.player.model.Player;
import com.emregame.rpg.player.model.SpartacusPlayer;
import com.emregame.rpg.player.service.PlayerService;
import com.emregame.rpg.util.RandomGenerator;

public class SpartacusPlayerService implements PlayerService{

    @Override
    public Player initPlayer() {
	SpartacusGameWriter.printInfo("-> Before begin, please type your name:");
	String playerName = SpartacusGameReader.readLine();
	SpartacusGameWriter.printIntroduction();
	Gladiator gladiator = createGladiator(playerName);
	return createPlayer(playerName, gladiator);
    }
    
    public Gladiator createGladiator(String playerName) {
	Gladiator gladiator = new Gladiator();
	WeaponType weapon = selectWeapon();
	ShieldType shield = selectShield();
	gladiator.setName(playerName);
	gladiator.setExperience(0);
	int maxHealth = RandomGenerator.generateNumberInRange(70, 90);
	gladiator.setMaxHealth(maxHealth);
	gladiator.setCurrentHealth(maxHealth);
	gladiator.prepareFight(weapon, shield);
	return gladiator;
    }
    
    private ShieldType selectShield() {
	ShieldType shield;
	while (true) {
	    SpartacusGameWriter.printInfo("");
	    SpartacusGameWriter.printInfo("-> Select your shield, type shield name");
	    SpartacusGameWriter.printInfo("");
	    printShields();
	    String commandString = SpartacusGameReader.readLine();
	    shield = SpartacusInterpreter.getInstance().getShield(commandString);
	    if (shield != null) {
		break;
	    }
	}
	return shield;

    }

    private WeaponType selectWeapon() {
	WeaponType weapon;
	while (true) {
	    SpartacusGameWriter.printInfo("Now begin game by creating a character:");
	    SpartacusGameWriter.printInfo("");
	    SpartacusGameWriter.printInfo("-> Select your weapon, type weapon name:");
	    SpartacusGameWriter.printInfo("");
	    printWeapons();
	    String commandString = SpartacusGameReader.readLine();
	    weapon = SpartacusInterpreter.getInstance().getWeapon(commandString);
	    if (weapon != null) {
		break;
	    }
	}

	return weapon;

    }
    
    private void printShields() {
	for (ShieldType shield : ShieldType.values()) {
	    SpartacusGameWriter.printInfo(shield.getName() + "--> " + shield.getDescription() + " / Defense: "
		    + shield.getDefenseValue() + " / Agility Defect: " + shield.getNegativeAgility());
	}

    }

    private void printWeapons() {
	for (WeaponType weapon : WeaponType.values()) {
	    SpartacusGameWriter.printInfo(weapon.getName() + "--> " + weapon.getDescription() + " / Attack: "
		    + weapon.getAttackValue() + " / Agility Affect: " + weapon.getPositiveAgility());
	}

    }
    
    public Player createPlayer(String name, Gladiator gladiator) {
	SpartacusPlayer player = new SpartacusPlayer();
	player.setName(name);
	//player.setMapPoint(spartacusMapService.getStartingPoint());
	player.setGladiator(gladiator);
	return player;
    }

}
