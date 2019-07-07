package com.emregame.rpg.game.model;

import java.io.Serializable;

import com.emregame.rpg.map.model.SpartacusGameMap;
import com.emregame.rpg.player.model.SpartacusPlayer;

public class SpartacusGame implements Game, Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 4479634741782229097L;
    private SpartacusGameMap gameMap;
    private SpartacusPlayer player;

    public SpartacusGameMap getGameMap() {
	return gameMap;
    }
    
    public void setGameMap(SpartacusGameMap gameMap) {
	this.gameMap = gameMap;
    }

    public SpartacusPlayer getPlayer() {
	return player;
    }

    public void setPlayer(SpartacusPlayer player) {
	this.player = player;
    }
}
