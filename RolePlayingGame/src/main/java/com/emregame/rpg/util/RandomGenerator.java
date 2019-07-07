package com.emregame.rpg.util;

import java.util.Random;

public class RandomGenerator {
    public static int generateNumberInRange(int min, int max) {
	if (min >= max) {
	    throw new IllegalArgumentException("minimum value cannot be grater than maximum value");
	}
	Random random = new Random();
	return random.nextInt((max - min) + 1) + min;
    }
}
