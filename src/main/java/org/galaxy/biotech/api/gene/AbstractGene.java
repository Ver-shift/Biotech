package org.galaxy.biotech.api.gene;

import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.galaxy.biotech.api.gene.cast.CastType;

import java.util.Map;

public abstract class AbstractGene {


    //基础
    protected ResourceLocation textureId;                   //图片还有标识符
    protected Component geneDisplayerName = null;           //名字
    protected SpeciesType speciesType = null;               //种族
    protected Component description = null;                 //描述
    protected AbstractGene prerequisiteGene = null;
    private boolean locked = true; //前置基因


    public ResourceLocation getTextureId() {
        return textureId;
    }

    //数值
    protected int maxLevel = 3;                             //最大基因能够升级的等级
    final int minLevel = 0;                                 //初始基因等级(0级锁定)
    private GeneRarity geneRarity = null;                   //受技能最大等级影响

    //技能
    protected int coolDownTick = 0;                         //冷却时间
    protected int startUpTick = 0;                          //前摇时间
    protected int durationTick =0;                          //持续时间
    protected CastType castType = null;

    protected int basePowerCost = 0;                        //基础能量消耗
    protected int powerCostPerLevel = 0;                    //每级增加的能量消耗


    //属性===================================================
    private final Map<Holder<Attribute>, MobEffect.AttributeTemplate> attributeModifiers = new Object2ObjectOpenHashMap();

    public void attributeModifier(Holder<Attribute> attribute, ResourceLocation id, double amount, AttributeModifier.Operation operation){
        this.attributeModifiers.put(attribute, new MobEffect.AttributeTemplate(id, amount, operation));
    }

    //装备时触发
    public void addAttributeModifiers(AttributeMap attributeMap, int amplifier) {
        for(Map.Entry<Holder<Attribute>, MobEffect.AttributeTemplate> entry : this.attributeModifiers.entrySet()) {
            AttributeInstance attributeinstance = attributeMap.getInstance((Holder)entry.getKey());
            if (attributeinstance != null) {
                attributeinstance.removeModifier(((MobEffect.AttributeTemplate)entry.getValue()).id());
                attributeinstance.addPermanentModifier(((MobEffect.AttributeTemplate)entry.getValue()).create(amplifier));
            }
        }
    }
    //脱下时移除
    public void removeAttributeModifiers(AttributeMap attributeMap) {
        for(Map.Entry<Holder<Attribute>, MobEffect.AttributeTemplate> entry : this.attributeModifiers.entrySet()) {
            AttributeInstance attributeinstance = attributeMap.getInstance((Holder)entry.getKey());
            if (attributeinstance != null) {
                attributeinstance.removeModifier(((MobEffect.AttributeTemplate)entry.getValue()).id());
            }
        }
    }

    //id
    //数值(最大等级，冷却，派系)
    //技能通用描述
    //构造方法（能量花费每一个等级，基础能量花费，释放时间，基础技能强度，技能强度加成()）


}
