// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package com.dasik.mcagenderbridge.mixin;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// Verified against: PlayerEntityExtendedModel.java (26.2+)
@Mixin(targets = "net.conczin.mca.client.model.PlayerEntityExtendedModel", remap = false)
public abstract class PlayerEntityExtendedModelMixin {

    @Shadow
    public ModelPart breasts;

    @Shadow
    public ModelPart breastsWear;

    @Inject(method = "setupAnim", at = @At("RETURN"))
    private void mcagenderbridge$suppressMcaPlayerBreastsSetupAnim(AvatarRenderState state, CallbackInfo ci) {
        if (this.breasts != null) {
            this.breasts.visible = false;
        }
        if (this.breastsWear != null) {
            this.breastsWear.visible = false;
        }
    }

    @Inject(method = "copyVisibility", at = @At("RETURN"))
    private void mcagenderbridge$suppressMcaPlayerBreastsCopyVisibility(HumanoidModel<?> model, CallbackInfo ci) {
        if (this.breasts != null) {
            this.breasts.visible = false;
        }
        if (this.breastsWear != null) {
            this.breastsWear.visible = false;
        }
    }

    @Inject(method = "setAllVisible", at = @At("RETURN"))
    private void mcagenderbridge$suppressMcaPlayerBreastsSetAllVisible(boolean visible, CallbackInfo ci) {
        if (this.breasts != null) {
            this.breasts.visible = false;
        }
        if (this.breastsWear != null) {
            this.breastsWear.visible = false;
        }
    }
}
