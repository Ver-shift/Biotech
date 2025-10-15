package org.galaxy.biotech.gene.beasts.u;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.galaxy.biotech.api.gene.UltimateSkillGene;
import org.galaxy.biotech.api.gene.cast.CastSource;

public class BeastsCoreGene extends UltimateSkillGene {
    //id
    //数值(最大等级，冷却，派系)
    //技能通用描述
    //构造方法（能量花费每一个等级，基础能量花费，释放时间，基础技能强度，技能强度加成()）
    public BeastsCoreGene() {}

    @Override
    protected float getPowerCost() {
        return 0;
    }

    @Override
    protected float getPowerCostPerLevel() {
        return 0;
    }

    @Override
    public void onCastSkill(Level level, int skillLevel, LivingEntity livingEntity, CastSource castSource) {

    }

    //get释放种类

    //get技能图片
    //get伤害来源

    /*（服务于技能描述）
    get伤害
    get数量*/

    //释放具体方法
}
