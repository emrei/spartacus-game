package com.emregame.rpg.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.emregame.rpg.map.model.City;
import com.emregame.rpg.util.CityGenerator;

public class CityGeneratorTest {
    private static City cityRome, cityCapua;
    
    @BeforeAll
    public static void init() {
	cityRome = new City();
	cityRome.setName("rome");
	cityRome.setHealPack(75);
	cityRome.setMinRequiredExperience(4);
	
	cityCapua = new City();
	cityCapua.setName("capua");
	cityCapua.setHealPack(65);
	cityCapua.setMinRequiredExperience(3);
    }
    
    @Test
    public void testGenerateCityList() {
	List<City> cityList = CityGenerator.generateCityList();
	assertEquals(cityCapua, cityList.get(3));
	assertEquals(cityRome, cityList.get(4));
    }
    
    @Test
    public void testCreateCity() {
	City actualCity = CityGenerator.createCity("rome", 75, 4);
	assertEquals(cityRome, actualCity);
	
	
    }
}
