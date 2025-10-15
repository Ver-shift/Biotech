package org.galaxy.biotech.api.gene;

import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;

public abstract class AbstractGene {

    protected ResourceLocation textureId;
    protected Component geneDisplayerName = null;
    protected String skillId= null;

    protected SpeciesType speciesType = null;
    protected GeneRarity geneRarity = null;



    //id
    //数值(最大等级，冷却，派系)
    //技能通用描述
    //构造方法（能量花费每一个等级，基础能量花费，释放时间，基础技能强度，技能强度加成()）


}
