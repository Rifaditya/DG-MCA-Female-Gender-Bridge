package net.conczin.mca.entity.ai;

import net.conczin.mca.entity.ai.relationship.Gender;

public class Genetics {
    public static class GeneType {
        public GeneType(String name) {}
    }

    public static final GeneType BREAST = new GeneType("Breast");

    public Gender getGender() {
        return Gender.FEMALE;
    }

    public float getGene(GeneType type) {
        return 0.5f;
    }
}
