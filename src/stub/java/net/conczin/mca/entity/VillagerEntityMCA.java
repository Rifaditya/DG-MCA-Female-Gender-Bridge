package net.conczin.mca.entity;

import net.conczin.mca.entity.ai.Genetics;
import net.minecraft.world.entity.npc.villager.Villager;
import net.minecraft.world.level.Level;
import java.util.UUID;

public abstract class VillagerEntityMCA extends Villager {
    protected VillagerEntityMCA() { super(null, null); }
    public Genetics getGenetics() { return null; }
    public UUID getUUID() { return null; }
    public Level level() { return null; }
}
