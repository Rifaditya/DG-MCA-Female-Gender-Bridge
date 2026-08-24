// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package com.dasik.mcagenderbridge.genetics;

import net.minecraft.util.RandomSource;

// Verified against: Genetics.java (26.2+)
public class GeneticsBridge {

    private static final RandomSource RANDOM = RandomSource.create();

    public static float calculateInheritedBreastGene(float motherGene) {
        float mutation = (RANDOM.nextFloat() - 0.5f) * 0.15f;
        float daughterGene = motherGene + mutation;
        return Math.max(0.0f, Math.min(1.0f, daughterGene));
    }
}
