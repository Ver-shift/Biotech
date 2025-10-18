package org.galaxy.biotech.api.gene;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import org.galaxy.biotech.Biotech;

import java.util.List;

public class SpeciesType {
    final String speciesId;
    //种族，附着在基因上面，不同种族颜色不同。用于分类，需要根据种族获取所有Gene
    final Component displayName;
    final ResourceLocation texture;
    final Style style;

    public SpeciesType(Component displayName,String speciesId) {
        this.displayName = displayName;
        this.style = displayName.getStyle();
        this.speciesId = speciesId;
        this.texture = getTexture();
    }

    public ResourceLocation getTexture() {
        return ResourceLocation.fromNamespaceAndPath(Biotech.MODID,"textures/gene/species/"+ getSpeciesId() + ".png");
    }

    public String getSpeciesId() {
        return speciesId;
    }

    public List<Gene> getSpeciesGene(LivingEntity livingEntity){
        return null;
    }

    public Component getDisplayName() {
        return displayName;
    }

    public Style getStyle() {
        return style;
    }

}
