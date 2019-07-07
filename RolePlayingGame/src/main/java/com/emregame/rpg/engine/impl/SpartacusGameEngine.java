package com.emregame.rpg.engine.impl;

import com.emregame.rpg.engine.GameEngine;
import com.emregame.rpg.game.service.GameService;

public class SpartacusGameEngine implements GameEngine {

    public void run(GameService gameService) {
	gameService.play();
	gameService.exit();

    }

}
