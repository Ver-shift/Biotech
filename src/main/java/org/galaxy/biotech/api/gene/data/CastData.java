package org.galaxy.biotech.api.gene.data;

import io.redspace.ironsspellbooks.api.spells.CastSource;
import io.redspace.ironsspellbooks.api.spells.CastType;
import io.redspace.ironsspellbooks.api.spells.ICastData;
import net.minecraft.world.item.ItemStack;
import org.galaxy.biotech.api.gene.AbstractGene;
import org.jetbrains.annotations.Nullable;

public class CastData {

    private int castSkillLevel = 0;
    private int castDuration =0;
    private int castDurationRemaining =0;



    private CastSource castSource;
    private CastType castType;
    private @Nullable ICastData additionalCastData;
    private AbstractGene castingGene;

    public CastData(AbstractGene gene,int castSkillLevel,int castDuration,int castDurationRemaining,CastSource castSource,CastType castType) {
        this.castSkillLevel = castSkillLevel;
        this.castDuration = castDuration;
        this.castDurationRemaining = castDurationRemaining;
        this.castSource = castSource;
        this.castType = castType;
        this.additionalCastData = null;

        this.castingGene = gene;
    }

    public void resetCastingState(){
        this.castSkillLevel = 0;
        this.castDuration = 0;
        this.castDurationRemaining = 0;
        this.castSource = CastSource.NONE;
        this.castType = CastType.NONE;
    }

    public boolean isCasting(){
        return false;
    }

    //Additional data
    public ICastData getAdditionalCastData() {
        return additionalCastData;
    }
    public void setAdditionalCastData(ICastData newCastData) {
        additionalCastData = newCastData;
    }
    public void resetAdditionalCastData() {
        if (additionalCastData != null) {
            additionalCastData.reset();
            additionalCastData = null;
        }
    }

    //get set
    public CastSource getCastSource() {
        return castSource;
    }
    public CastType getCastType() {
        return castType;
    }
    public int getCastDurationRemaining() {
        return castDurationRemaining;
    }

    public float getCastCompletionPercent() {
        if (castDuration == 0) {
            return 1;
        }
        return 1 - (castDurationRemaining / (float) castDuration);
    }
    public void handleCastDuration() {
        castDurationRemaining--;

        if (castDurationRemaining <= 0) {
            castDurationRemaining = 0;
        }
    }
}
