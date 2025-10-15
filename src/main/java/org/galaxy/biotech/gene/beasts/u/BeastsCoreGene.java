package org.galaxy.biotech.gene.beasts.u;

import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.galaxy.biotech.Biotech;
import org.galaxy.biotech.api.gene.UltimateSkillGene;
import org.galaxy.biotech.api.gene.cast.CastSource;
import org.galaxy.biotech.api.gene.cast.CastType;
import org.galaxy.biotech.api.init.SpeciesTypeRegistry;

import java.util.function.Supplier;

public class BeastsCoreGene extends UltimateSkillGene {




    public BeastsCoreGene() {
        this.geneDisplayerName = Component.translatable("gene.biotech.beasts.beasts_core.displayer_name");
        this.textureId = ResourceLocation.fromNamespaceAndPath(Biotech.MODID, "beasts_core");
        this.speciesType = SpeciesTypeRegistry.BEASTS.get();
        this.description = Component.translatable("gene.biotech.beasts.beasts_core.description");

        this.maxLevel = 10;

        this.coolDownTick = 20*20;
        this.durationTick = 20*2;
        this.castType = CastType.CONTINUOUS;

        this.attributeModifier(Attributes.ARMOR,ResourceLocation.fromNamespaceAndPath(Biotech.MODID,"armor"),2, AttributeModifier.Operation.ADD_VALUE);
    }

















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
