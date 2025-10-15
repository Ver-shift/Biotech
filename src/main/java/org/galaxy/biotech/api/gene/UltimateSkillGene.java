package org.galaxy.biotech.api.gene;

public abstract class UltimateSkillGene extends AbstractGene implements ISkillGene{
    //必定会消耗能量，必定是技能
    protected abstract float getPowerCost();
    protected abstract float getPowerCostPerLevel();

}
