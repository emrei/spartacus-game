package com.emregame.rpg.map.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.emregame.rpg.character.model.Gladiator;
import com.emregame.rpg.io.SpartacusGameReader;
import com.emregame.rpg.io.SpartacusGameWriter;
import com.emregame.rpg.map.model.City;
import com.emregame.rpg.map.model.GameMap;
import com.emregame.rpg.map.model.MapPoint;
import com.emregame.rpg.map.model.SpartacusGameMap;
import com.emregame.rpg.map.service.MapService;
import com.emregame.rpg.player.model.Moveable;
import com.emregame.rpg.util.CityGenerator;
import com.emregame.rpg.util.GladiatorGenerator;

public class SpartacusMapService implements MapService, Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -3189904690699204126L;

    @Override
    public GameMap initMap() {
	SpartacusGameMap spartacusGameMap = new SpartacusGameMap();
	List<City>  cities = CityGenerator.generateCityList();
	Map<String, City> cityMap = cities.stream().collect(Collectors.toMap(City::getName, city -> city));

	List<Gladiator> gladiators = GladiatorGenerator.generateGladitorList();
	gladiators.stream().collect(Collectors.toMap(Gladiator::getName, gladiator -> gladiator));
	Map<Integer, List<Gladiator>> gladiatorMap = gladiators.stream()
		.collect(Collectors.groupingBy(Gladiator::getExperience));
	for (City city : cities) {
	    List<Gladiator> gladiatorList = gladiatorMap.get(city.getMinRequiredExperience());
	    city.setGladiatorList(gladiatorList);
	    city.setGladiatorMap(gladiatorList.stream().collect(Collectors.toMap(Gladiator::getName, gladiator -> gladiator)));
	}
	spartacusGameMap.setCities(cities);
	spartacusGameMap.setCityMap(cityMap);
	return spartacusGameMap;
    }

    @Override
    public MapPoint explore(Moveable moveable, GameMap gameMap) {
	City city = selectCity(gameMap);
	if(city == null) {
	    return moveable.getMapPoint();
	}
	moveable.setMapPoint(city);
	return city;

    }

    private City selectCity(GameMap gameMap) {
	SpartacusGameMap spartacusGameMap = (SpartacusGameMap) gameMap;
	City city;
	while (true) {
	    SpartacusGameWriter.printInfo("Type one of the listed cities to explore");
	    SpartacusGameWriter.printCityList(spartacusGameMap.getCities());
	    SpartacusGameWriter.printInfo("back--> to return game menu");
	    String commandString = SpartacusGameReader.readLine();
	    if(commandString.equalsIgnoreCase("back")) {
		return null;
	    }
	    city = spartacusGameMap.getCityMap().get(commandString);
	    if (city != null) {
		break;
	    }
	}
	return city;
    }

}
