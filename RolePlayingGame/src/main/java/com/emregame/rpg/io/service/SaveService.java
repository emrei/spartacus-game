package com.emregame.rpg.io.service;

import com.emregame.rpg.game.model.Game;

public interface SaveService {
    public void save(String name, Game game);
}
