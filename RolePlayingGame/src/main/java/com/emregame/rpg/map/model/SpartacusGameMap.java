package com.emregame.rpg.map.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpartacusGameMap implements GameMap, Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 3709260807948705288L;
    List<City> cities = new ArrayList<City>();
    Map<String, City> cityMap = new HashMap<String, City>();

    public List<City> getCities() {
	return cities;
    }

    public void setCities(List<City> cities) {
	this.cities = cities;
    }

    public Map<String, City> getCityMap() {
	return cityMap;
    }

    public void setCityMap(Map<String, City> cityMap) {
	this.cityMap = cityMap;
    }

    @Override
    public MapPoint getStartingPoint() {
	return cities.get(0);
    }
}
