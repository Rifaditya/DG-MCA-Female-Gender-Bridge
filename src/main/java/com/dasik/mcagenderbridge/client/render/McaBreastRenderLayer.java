// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package com.dasik.mcagenderbridge.client.render;

import com.dasik.mcagenderbridge.render.McaBreastModelBox;
import com.mojang.blaze3d.vertex.PoseStack;
import net.conczin.mca.MCA;
import net.conczin.mca.client.model.VillagerEntityModelMCA;
import net.conczin.mca.client.render.VillagerRenderState;
import net.conczin.mca.client.render.VillagerVisuals;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;

// Verified against: RenderLayer.java (26.2+), VillagerRenderState.java (26.2+), and RenderTypes.java (26.2+)
@Environment(EnvType.CLIENT)
public class McaBreastRenderLayer extends RenderLayer<VillagerRenderState, VillagerEntityModelMCA> {

    private final McaBreastModelBox modelBox;

    public McaBreastRenderLayer(RenderLayerParent<VillagerRenderState, VillagerEntityModelMCA> renderer) {
        super(renderer);
        this.modelBox = new McaBreastModelBox(McaBreastModelBox.createLayerDefinition().bakeRoot());
    }

    @Override
    public void submit(PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int packedLight, VillagerRenderState renderState, float yRot, float xRot) {
        if (renderState == null) {
            return;
        }

        VillagerVisuals visuals = VillagerVisuals.require(renderState);
        if (visuals == null) {
            return;
        }

        if (visuals.baby() || !visuals.female()) {
            return;
        }

        float breastSize = visuals.breastSize();
        if (breastSize <= 0.02f) {
            return;
        }

        // Get skin texture
        Identifier skinTexture;
        if (!MCA.isBlankString(visuals.skin())) {
            skinTexture = Identifier.parse(visuals.skin());
        } else {
            int skinIndex = (int) Math.clamp(visuals.skinGene() * 5, 0, 4);
            skinTexture = MCA.locate("skins/skin/" + visuals.genderDataName() + "/" + skinIndex + ".png");
        }

        RenderType renderType = RenderTypes.entityCutout(skinTexture, false);

        VillagerEntityModelMCA parentModel = getParentModel();
        ModelPart body = parentModel.body;

        poseStack.pushPose();
        try {
            parentModel.root().translateAndRotate(poseStack);
            body.translateAndRotate(poseStack);

            // Shift to chest position (y = 0.12F down, z = -0.10F forward)
            poseStack.translate(0.0F, 0.12F, -0.10F);

            // Scale breast size based on MCA genetics
            float scale = 0.7f + (breastSize * 0.5f);
            poseStack.scale(scale, scale, scale);

            submitNodeCollector.order(1).submitModel(this.modelBox, renderState, poseStack, renderType, packedLight, OverlayTexture.NO_OVERLAY, renderState.outlineColor, null);
        } finally {
            poseStack.popPose();
        }
    }
}
