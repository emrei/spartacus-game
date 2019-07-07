package com.emregame.rpg.util;

import java.util.ArrayList;
import java.util.List;

import com.emregame.rpg.map.model.City;


public class CityGenerator {
    
    static final String[] cityNames = { "pompei", "naepolis", "sinuessa", "capua", "rome"};
    static final int[] healPacks = { 25, 25, 40, 65, 75};
    static final int[] minExperiences = { 0, 1, 2, 3, 4};
    
    public static List<City> generateCityList(){
	List<City> cityList = new ArrayList<City>();
	for(int i=0; i<cityNames.length; i++) {
	    cityList.add(createCity(cityNames[i], healPacks[i], minExperiences[i]));
	}
	return cityList;
    }
    
    public static City createCity(String name, int healPack, int minRequiredExperience) {
	City city = new City();
	city.setName(name);
	city.setHealPack(healPack);
	city.setMinRequiredExperience(minRequiredExperience);
	return city;
    }
}
