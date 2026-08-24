// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package com.dasik.mcagenderbridge.mixin;

import net.conczin.mca.client.render.VillagerRenderState;
import net.minecraft.client.model.geom.ModelPart;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// Verified against: VillagerEntityBaseModelMCA.java (26.2+) and VillagerRenderState.java (26.2+)
@Mixin(targets = "net.conczin.mca.client.model.VillagerEntityBaseModelMCA", remap = false)
public abstract class VillagerEntityBaseModelMCAMixin {

    @Shadow
    @Final
    public ModelPart breasts;

    @Inject(method = "setupAnim", at = @At("RETURN"))
    private void mcagenderbridge$suppressMcaVillagerBreasts(VillagerRenderState state, CallbackInfo ci) {
        if (this.breasts != null) {
            this.breasts.visible = false;
        }
    }
}
