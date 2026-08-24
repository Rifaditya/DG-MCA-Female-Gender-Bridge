package net.conczin.mca.client.render;

public record VillagerVisuals(
        String genderDataName,
        boolean female,
        boolean baby,
        float breastSize,
        float skinGene,
        String skin
) {
    public static VillagerVisuals require(Object state) {
        return new VillagerVisuals("female", true, false, 0.5f, 0.5f, "");
    }
}
