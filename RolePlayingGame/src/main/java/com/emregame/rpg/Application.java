package com.emregame.rpg;

import com.emregame.rpg.character.service.FightService;
import com.emregame.rpg.character.service.HealService;
import com.emregame.rpg.character.service.ViewService;
import com.emregame.rpg.character.service.impl.GladiatorFightService;
import com.emregame.rpg.character.service.impl.GladiatorHealService;
import com.emregame.rpg.character.service.impl.GladiatorViewService;
import com.emregame.rpg.engine.impl.SpartacusGameEngine;
import com.emregame.rpg.game.service.GameService;
import com.emregame.rpg.game.service.impl.SpartacusGameService;
import com.emregame.rpg.io.service.LoadService;
import com.emregame.rpg.io.service.SaveService;
import com.emregame.rpg.io.service.impl.GameLoadService;
import com.emregame.rpg.io.service.impl.GameSaveService;
import com.emregame.rpg.map.service.MapService;
import com.emregame.rpg.map.service.impl.SpartacusMapService;
import com.emregame.rpg.player.service.PlayerService;
import com.emregame.rpg.player.service.impl.SpartacusPlayerService;

public class Application {

    public static void main(String[] args) {

	SpartacusGameEngine gameEngine = new SpartacusGameEngine();
	MapService spartacusMapService = new SpartacusMapService();
	SaveService gameSaveService = new GameSaveService();
	LoadService gameLoadService = new GameLoadService();
	ViewService gladiatorViewService = new GladiatorViewService();
	HealService gladiatorHealService = new GladiatorHealService();
	FightService gladiatorFightService = new GladiatorFightService();
	PlayerService gladiatorPlayerService = new SpartacusPlayerService();
	GameService spartacusGameService = new SpartacusGameService(spartacusMapService, gameSaveService, gameLoadService,
		gladiatorViewService, gladiatorHealService, gladiatorFightService, gladiatorPlayerService);
	gameEngine.run(spartacusGameService);
    }

}
