package com.baisylia.modestmining.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.baisylia.modestmining.ModestMining;
import com.baisylia.modestmining.entity.custom.ClamEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ClamRenderer extends GeoEntityRenderer<ClamEntity> {
    public ClamRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ClamModel());
        this.shadowRadius = 0.8f;
    }

    @Override
    public ResourceLocation getTextureLocation(ClamEntity instance) {
        return new ResourceLocation(ModestMining.MOD_ID, "textures/entity/clam/clam.png");
    }
}