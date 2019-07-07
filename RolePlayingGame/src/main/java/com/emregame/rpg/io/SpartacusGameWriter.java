package com.emregame.rpg.io;

import java.util.List;

import com.emregame.rpg.character.model.Gladiator;
import com.emregame.rpg.map.model.City;

/**
 * 
 * @author YunusEmre
 *
 */
public class SpartacusGameWriter{

    public static void printInfo(String info) {
	System.out.println(info);
    }

    public static void printIntroduction() {
	printInfo("");
	printInfo("--------------------------------------------");
	printInfo("Welcome to the Gladiotor's World in Ancient times!");
	printInfo("In this game, you will create your own gladiator to fight with other gladiators.");
	printInfo("You will explore Roman Empire cities and you can challenge other gladiatores to an arena combat.");
	printInfo(
		"You can select a target (gladiator) and attack to gain experience. Some targets are difficult to fight and some are easier.");
	printInfo(
		"You can exit from game anytime that you want. But if you don't save the game you will lose your data and have to start from beginning.");
	printInfo("--------------------------------------------");
	printInfo("");
	printToContinueInfo();
    }

    public static void printGladiatorInfo(Gladiator gladiator) {
	printInfo(gladiator.getName() + " --  Exp: " + gladiator.getExperience());
	printInfo("Health: " + gladiator.getCurrentHealth() + "/" + gladiator.getMaxHealth() + "--  Agility: "
		+ gladiator.getAgility());
	printInfo("Attack: " + gladiator.getAttack() + " --  Defense: " + gladiator.getDefense());
	printInfo("Weapon: " + gladiator.getWeapon().getName() + " --  Shield: " + gladiator.getShield().getName());
    }

    public static void printToContinueInfo() {
	printInfo("");
	printInfo("-> Please enter to continue");
	SpartacusGameReader.readLine();
    }

    public static void printGameMenu() {
	printInfo("-> What do you want to do with your character now?");
	printInfo("");
	printInfo("view -> to view your gladiator");
	printInfo("heal -> to heal your gladiator");
	printInfo("fight -> to attack a target in the current city");
	printInfo("explore -> to explore Roman Empire");
	printInfo("save -> to save your game");
	printInfo("exit -> to exit game");
    }

    public static void printMainMenu() {
	printInfo("SPARTACUS: GODS OF ARENA");
	printInfo("-> What do you want to do now?");
	printInfo("to load a game -> Type 'load'");
	printInfo("to start a new game -> Type 'new'");
    }
    
    public static void printFightMenu(City city) {
	printGladiatorsofCity(city);
	printInfo("back--> to return game menu");
    }

    public static void printCityList(List<City> cities) {
	for (City city : cities) {
	    printInfo(city.getName() + "--> to move there");
	}
    }

    public static void printGladiatorsofCity(City city) {
	for (Gladiator gladiator : city.getGladiatorList()) {
	    printInfo(gladiator.getName() + " --> " + gladiator.getCurrentHealth() + "/" + gladiator.getMaxHealth());
	}

    }

}
