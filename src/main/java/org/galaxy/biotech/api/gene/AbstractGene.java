package org.galaxy.biotech.api.gene;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

import java.util.List;
import java.util.Objects;

public abstract class AbstractGene {
    private String geneName;
    private String geneId;

    protected int baseComplexityCost;
    protected int baseMetabolicRateCost;

    public AbstractGene() {
    }

    public final String getGeneName() {
        if (geneName == null) {
            var resourceLocation = Objects.requireNonNull(getGeneResource());
            geneName = resourceLocation.getPath().intern();
        }

        return geneName;
    }

    public final String getGeneId() {
        if (geneId == null) {
            var resourceLocation = Objects.requireNonNull(getGeneResource());
            geneId = resourceLocation.toString().intern();
        }

        return geneId;
    }

    public final ResourceLocation getGeneIconResource(){
        return ResourceLocation.fromNamespaceAndPath(getGeneResource().getNamespace(),"textures/gui/gene_icons/"+ getGeneName() + ".png");
    }
    //确定法术命名空间
    public MutableComponent getDisplayName() {return Component.translatable(getComponentId());}

    public String getComponentId(){ return String.format("gene.%s.%s", getGeneResource().getNamespace(), getGeneName()); }




    public abstract GeneType getGeneType();
    public abstract ResourceLocation getGeneResource();

    public List<MutableComponent> getUniqueInfo(LivingEntity livingEntity) {
        return List.of();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof AbstractGene other) {
            return this.getGeneResource().equals(other.getGeneResource());
        }

        return false;
    }
    @Override
    public int hashCode() {
        return this.getGeneResource().hashCode();
    }





}
