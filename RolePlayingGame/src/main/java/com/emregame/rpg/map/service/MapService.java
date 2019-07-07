package com.emregame.rpg.map.service;

import com.emregame.rpg.map.model.GameMap;
import com.emregame.rpg.map.model.MapPoint;
import com.emregame.rpg.player.model.Moveable;

public interface MapService {
    /**
     * initialize a map and return
     * @return
     */
    public GameMap initMap();
    /**
     * move moveable character on the given map and return destination point
     * @param moveable
     * @param gameMap
     * @return
     */
    public MapPoint explore(Moveable moveable, GameMap gameMap);
    
}
