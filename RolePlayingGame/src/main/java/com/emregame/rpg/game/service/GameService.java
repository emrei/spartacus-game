package com.emregame.rpg.game.service;

public interface GameService {
    /**
     * start to play game
     */
    public void play();
    /**
     * exit game
     */
    public void exit();
    /**
     * save game data
     */
    public void save();
    /**
     * load a game, return true if it succeeds
     * @return
     */
    public boolean load();
    
}
