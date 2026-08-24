// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package com.dasik.mcagenderbridge.mixin;

import com.dasik.mcagenderbridge.client.render.McaBreastRenderLayer;
import net.conczin.mca.client.model.VillagerEntityModelMCA;
import net.conczin.mca.client.render.VillagerRenderState;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.world.entity.Mob;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// Verified against: VillagerLikeEntityMCARenderer.java (26.2+)
@Mixin(targets = "net.conczin.mca.client.render.VillagerLikeEntityMCARenderer", remap = false)
public abstract class VillagerLikeEntityMCARendererMixin extends HumanoidMobRenderer<Mob, VillagerRenderState, VillagerEntityModelMCA> {

    protected VillagerLikeEntityMCARendererMixin(EntityRendererProvider.Context context, VillagerEntityModelMCA model, float shadowRadius) {
        super(context, model, shadowRadius);
    }

    @Inject(method = "<init>", at = @At("RETURN"))
    private void mcagenderbridge$attachBreastRenderLayer(EntityRendererProvider.Context ctx, VillagerEntityModelMCA model, CallbackInfo ci) {
        this.addLayer(new McaBreastRenderLayer(this));
    }
}
