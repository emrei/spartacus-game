package com.emregame.rpg.player.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.emregame.rpg.map.model.City;

public class MoveableTest {

    private SpartacusPlayer player;
    private City city;

    @BeforeEach
    public void init() {
	city = new City();
	city.setName("Rome");
	player = new SpartacusPlayer();
    }

    @Test
    public void testMapPoint() {
	player.setMapPoint(city);
	assertEquals(city, player.getMapPoint());
	
    }

}
