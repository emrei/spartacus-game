package com.emregame.rpg.game.service.impl;

import com.emregame.rpg.character.model.Gladiator;
import com.emregame.rpg.character.service.FightService;
import com.emregame.rpg.character.service.HealService;
import com.emregame.rpg.character.service.ViewService;
import com.emregame.rpg.game.model.SpartacusGame;
import com.emregame.rpg.game.service.GameService;
import com.emregame.rpg.interpreter.enums.SpartacusCommandEnum;
import com.emregame.rpg.interpreter.service.impl.SpartacusInterpreter;
import com.emregame.rpg.io.SpartacusGameReader;
import com.emregame.rpg.io.SpartacusGameWriter;
import com.emregame.rpg.io.service.LoadService;
import com.emregame.rpg.io.service.SaveService;
import com.emregame.rpg.map.model.City;
import com.emregame.rpg.map.model.MapPoint;
import com.emregame.rpg.map.model.SpartacusGameMap;
import com.emregame.rpg.map.service.MapService;
import com.emregame.rpg.player.model.SpartacusPlayer;
import com.emregame.rpg.player.service.PlayerService;

public class SpartacusGameService implements GameService {

    MapService spartacusMapService;
    SpartacusGame spartacusGame;
    SaveService gameSaveService;
    LoadService gameLoadService;
    ViewService gladiatorViewService;
    HealService gladiatorHealService;
    FightService gladiatorFightService;
    PlayerService gladiatorPlayerService;
    
    

    public SpartacusGameService(MapService spartacusMapService, SaveService gameSaveService,
	    LoadService gameLoadService, ViewService gladiatorViewService, HealService gladiatorHealService,
	    FightService gladiatorFightService, PlayerService gladiatorPlayerService) {
	this.spartacusMapService = spartacusMapService;
	this.gameSaveService = gameSaveService;
	this.gameLoadService = gameLoadService;
	this.gladiatorViewService = gladiatorViewService;
	this.gladiatorHealService = gladiatorHealService;
	this.gladiatorFightService = gladiatorFightService;
	this.gladiatorPlayerService = gladiatorPlayerService;
    }

    @Override
    public void play() {

	runMainMenu();
	runGameMenu();

    }

    private void runMainMenu() {
	while (true) {
	    SpartacusCommandEnum beginCommand = getBeginCommand();
	    if (doMainMenuCommand(beginCommand)) {
		break;
	    }
	}

    }

    private void runGameMenu() {
	while (true) {
	    SpartacusGameWriter.printGameMenu();
	    String commandString = SpartacusGameReader.readLine();
	    SpartacusCommandEnum command = SpartacusInterpreter.getInstance().getGameMenuCommand(commandString);
	    doGameMenuCommand(command);
	    if (command == SpartacusCommandEnum.EXIT) {
		break;
	    }
	}

    }

    private SpartacusCommandEnum getBeginCommand() {
	SpartacusCommandEnum command;
	while (true) {
	    SpartacusGameWriter.printMainMenu();
	    String commandString = SpartacusGameReader.readLine();
	    command = SpartacusInterpreter.getInstance().getMainMenuCommand(commandString);
	    if (command != null) {
		break;
	    }
	}
	return command;
    }

    private boolean doMainMenuCommand(SpartacusCommandEnum beginCommand) {
	if (beginCommand == SpartacusCommandEnum.NEW) {
	    return startNewGame();
	} else {
	    return load();
	}

    }

    private void doGameMenuCommand(SpartacusCommandEnum command) {
	if (command == null) {
	    return;
	}
	switch (command) {
	case VIEW:
	    viewCharacter();
	    break;
	case HEAL:
	    heal();
	    break;
	case FIGHT:
	    beginFight();
	    break;
	case EXPLORE:
	    exploreMap();
	    break;
	case SAVE:
	    save();
	    break;
	case EXIT:

	    break;
	default:
	    break;
	}
    }

    private void heal() {
	City city = (City) spartacusGame.getPlayer().getMapPoint();
	int remainingHeal = gladiatorHealService.heal(spartacusGame.getPlayer().getGladiator(), city.getHealPack());
	city.setHealPack(remainingHeal);
	SpartacusGameWriter.printToContinueInfo();
    }

    private void beginFight() {
	SpartacusGameWriter.printInfo(
		"Gladiators in current city are listed below. Type name that you want to challenge and start a fight");
	Gladiator opponentGladiator = getOpponentGladiator();
	if (opponentGladiator == null) {
	    return;
	}
	Gladiator playerGladiator = spartacusGame.getPlayer().getGladiator();
	gladiatorFightService.fight(playerGladiator, opponentGladiator);
	SpartacusGameWriter.printInfo("You can heal your wounds by using a health package, even if your health is ZERO");
	SpartacusGameWriter.printToContinueInfo();

    }

    private Gladiator getOpponentGladiator() {
	return (Gladiator) gladiatorFightService.selectTarget(spartacusGame.getPlayer().getMapPoint());
    }

    private void exploreMap() {
	SpartacusGameWriter.printInfo("You are here now: " + ((City) spartacusGame.getPlayer().getMapPoint()).getName());
	MapPoint newCity = spartacusMapService.explore(spartacusGame.getPlayer(), spartacusGame.getGameMap());
	SpartacusGameWriter.printInfo("You moved to " + ((City) newCity).getName());
	SpartacusGameWriter.printToContinueInfo();

    }

    private void viewCharacter() {
	gladiatorViewService.view(spartacusGame.getPlayer().getGladiator());
	SpartacusGameWriter.printToContinueInfo();

    }

    private boolean loadFromFile(String fileName) {
	spartacusGame = (SpartacusGame) gameLoadService.loadGame(fileName);
	if (spartacusGame == null) {
	    return false;
	}
	return true;

    }

    private boolean startNewGame() {
	SpartacusGameMap gameMap = (SpartacusGameMap) spartacusMapService.initMap();
	SpartacusPlayer player = (SpartacusPlayer) gladiatorPlayerService.initPlayer();
	player.setMapPoint(gameMap.getStartingPoint());
	spartacusGame = new SpartacusGame();
	spartacusGame.setGameMap(gameMap);
	spartacusGame.setPlayer(player);
	SpartacusGameWriter.printInfo("Now Begin your adventure");
	SpartacusGameWriter.printInfo("");
	return true;

    }

    @Override
    public void save() {
	SpartacusGameWriter.printInfo("-> Please type a name to save");
	String name = SpartacusGameReader.readLine();
	gameSaveService.save(name, spartacusGame);
	SpartacusGameWriter.printInfo("Your game is saved.");
	SpartacusGameWriter.printToContinueInfo();

    }

    @Override
    public boolean load() {
	SpartacusGameWriter.printInfo("Type name of saved game:");
	String fileName = SpartacusGameReader.readLine();
	if (loadFromFile(fileName)) {
	    SpartacusGameWriter.printInfo(fileName + " is loaded. You can resume your name");
	    return true;
	} else {
	    return false;
	}

    }

    @Override
    public void exit() {
	SpartacusGameWriter.printInfo("Bye Bye");
	SpartacusGameReader.close();

    }

}
