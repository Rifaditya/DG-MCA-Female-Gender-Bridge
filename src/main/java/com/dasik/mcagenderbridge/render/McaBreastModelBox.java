// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package com.dasik.mcagenderbridge.render;

import net.conczin.mca.client.render.VillagerRenderState;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.rendertype.RenderTypes;

// Verified against: Model.java (26.2+)
public class McaBreastModelBox extends Model<VillagerRenderState> {

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();

        root.addOrReplaceChild("breasts", CubeListBuilder.create()
                .texOffs(18, 20)
                .addBox(-4.0F, 0.0F, -2.0F, 8, 4, 3, new CubeDeformation(0.0F)), PartPose.ZERO);

        return LayerDefinition.create(mesh, 64, 64);
    }

    public McaBreastModelBox(ModelPart root) {
        super(root, RenderTypes::entityCutout);
    }
}
