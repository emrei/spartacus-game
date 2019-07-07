package com.emregame.rpg.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.emregame.rpg.util.RandomGenerator;

public class RandomGeneratorTest {
    @Test
    public void testGenerateNumberInRange() {
	int randomNumber = RandomGenerator.generateNumberInRange(65, 85);
	assertTrue(randomNumber>=65 && randomNumber <=85);
    }
    
    
}
