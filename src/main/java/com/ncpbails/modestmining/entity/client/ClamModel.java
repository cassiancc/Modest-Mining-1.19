package com.ncpbails.modestmining.entity.client;

import com.ncpbails.modestmining.ModestMining;
import com.ncpbails.modestmining.entity.custom.ClamEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ClamModel extends GeoModel<ClamEntity> {
    @Override
    public ResourceLocation getModelResource(ClamEntity object) {
        return new ResourceLocation(ModestMining.MOD_ID, "geo/clam.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ClamEntity object) {
        return new ResourceLocation(ModestMining.MOD_ID, "textures/entity/clam/clam.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ClamEntity animatable) {
        return new ResourceLocation(ModestMining.MOD_ID, "animations/clam.animation.json");
    }
}
