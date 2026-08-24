package net.conczin.mca.client.model;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;

public class PlayerEntityExtendedModel extends HumanoidModel<AvatarRenderState> {
    public ModelPart breasts;
    public ModelPart breastsWear;

    public PlayerEntityExtendedModel(ModelPart root) {
        super(root);
    }
}
