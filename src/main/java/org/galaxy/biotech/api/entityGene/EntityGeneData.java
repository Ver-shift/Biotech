package org.galaxy.biotech.api.entityGene;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import org.galaxy.biotech.api.event.ChangeComplexityEvent;
import org.galaxy.biotech.api.event.ChangeMetabolicRateEvent;
import org.galaxy.biotech.api.init.AttributeInit;
import org.jetbrains.annotations.UnknownNullability;

public class EntityGeneData implements IEntityGene {
    //初始化
    private LivingEntity livingEntity = null;
    public static final String COMPLEXITY = "complexity";
    public static final String METABOLIC_RATE = "metabolicRate";

    public EntityGeneData() {

    }
    public EntityGeneData(LivingEntity livingEntity) {
        this.livingEntity = livingEntity;
    }

    //复杂度和代谢率
    private float complexity = 0;
    private float metabolicRate = 0;



    public float getComplexity() {
        return complexity;
    }
    public float getMetabolicRate() {
        return metabolicRate;
    }
    public void setComplexity(float complexity) {
        ChangeComplexityEvent event = new ChangeComplexityEvent(livingEntity, this,this.complexity, complexity);
        if (this.livingEntity == null) {
            this.complexity = event.getNewComplexity();
        }
        if (this.livingEntity != null) {
            float maxComplexity = (float) livingEntity.getAttributeValue(AttributeInit.MAX_COMPLEXITY);
            if(this.complexity > maxComplexity) {
                this.complexity = maxComplexity;
            }
        }
    }
    public void setMetabolicRate(float metabolicRate) {
        ChangeMetabolicRateEvent event = new ChangeMetabolicRateEvent(livingEntity, this, this.metabolicRate, metabolicRate);
        this.metabolicRate = event.getNewMetabolicRate();

    }
    public void addComplexity(float complexity) {
        setComplexity(this.complexity + complexity);
    }
    public void addMetabolicRate(float metabolicRate) {
        setMetabolicRate(this.metabolicRate + metabolicRate);
    }
    public void subComplexity(float complexity) {
        setComplexity(this.complexity - complexity);
    }
    public void subMetabolicRate(float metabolicRate) {
        setMetabolicRate(this.metabolicRate - metabolicRate);
    }
    public void copyFrom(EntityGeneData source) {
        this.complexity = source.complexity;
        this.metabolicRate = source.metabolicRate;
    }

    @Override
    public @UnknownNullability CompoundTag serializeNBT(HolderLookup.Provider provider) {
        CompoundTag tag = new CompoundTag();
        tag.putFloat("complexity", this.complexity);
        tag.putFloat("metabolicRate", this.metabolicRate);
        return tag;
    }

    @Override
    public void deserializeNBT(HolderLookup.Provider provider, CompoundTag compoundTag) {
        this.complexity = compoundTag.getFloat("complexity");
        this.metabolicRate = compoundTag.getFloat("metabolicRate");
    }
}
