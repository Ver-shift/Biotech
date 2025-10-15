package org.galaxy.biotech.api.gene;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

import java.util.List;

public class SpeciesType {
    //种族，附着在基因上面，不同种族颜色不同。用于分类，需要根据种族获取所有Gene
    final Component displayName;
    final ResourceLocation textureId;
    final Style style;

    public SpeciesType(Component displayName,ResourceLocation textureId) {
        this.displayName = displayName;
        this.textureId = textureId;
        this.style = displayName.getStyle();
    }

    public List<AbstractGene> getSpeciesGene(LivingEntity livingEntity){
        return null;
    }

    public Component getDisplayName() {
        return displayName;
    }

    public Style getStyle() {
        return style;
    }

    public ResourceLocation getTextureId() {
        return textureId;
    }
}
