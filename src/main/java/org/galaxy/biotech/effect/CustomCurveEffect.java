package org.galaxy.biotech.effect;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import org.galaxy.biotech.Biotech;

/**
 * 自定义曲线效果 - 使用非线性增长的属性加成
 * 演示如何使用自定义曲线函数
 */
public class CustomCurveEffect extends MobEffect {

    public CustomCurveEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x00FFFF);

        // ✅ 使用自定义曲线：平方增长
        // I级(0)   → 1 点攻击
        // II级(1)  → 4 点攻击
        // III级(2) → 9 点攻击
        // IV级(3)  → 16 点攻击
        this.addAttributeModifier(
            Attributes.ATTACK_DAMAGE,
            ResourceLocation.fromNamespaceAndPath(Biotech.MODID, "curve_damage"),
            AttributeModifier.Operation.ADD_VALUE,
            level -> Math.pow(level + 1, 2) // (level+1)²
        );

        // ✅ 对数增长曲线：高等级收益递减
        // I级(0)   → 1.0
        // II级(1)  → 1.69
        // III级(2) → 2.1
        // IV级(3)  → 2.39
        this.addAttributeModifier(
            Attributes.MOVEMENT_SPEED,
            ResourceLocation.fromNamespaceAndPath(Biotech.MODID, "curve_speed"),
            AttributeModifier.Operation.ADD_MULTIPLIED_BASE,
            level -> Math.log(level + 2) / 10 // 对数曲线
        );

        // ✅ 分段函数：不同等级不同效果
        this.addAttributeModifier(
            Attributes.ARMOR,
            ResourceLocation.fromNamespaceAndPath(Biotech.MODID, "curve_armor"),
            AttributeModifier.Operation.ADD_VALUE,
            level -> {
                if (level < 2) {
                    return 2.0 * (level + 1);  // I-II级：线性增长
                } else {
                    return 4.0 + 5.0 * (level - 1); // III级+：快速增长
                }
            }
        );
    }
}
package org.galaxy.biotech.effect;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import org.galaxy.biotech.Biotech;
import org.galaxy.biotech.api.init.AttributeRegistry;

/**
 * 力量强化效果 - 增加攻击力和最大生命值
 * 演示如何使用 addAttributeModifier
 */
public class StrengthEnhancementEffect extends MobEffect {

    public StrengthEnhancementEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xFF5555); // 红色粒子

        // ✅ 方式1：固定数值增加
        // 每级增加 3 点攻击力
        // I级 = 3, II级 = 6, III级 = 9
        this.addAttributeModifier(
            Attributes.ATTACK_DAMAGE,
            ResourceLocation.fromNamespaceAndPath(Biotech.MODID, "strength_damage"),
            3.0,  // 基础数值
            AttributeModifier.Operation.ADD_VALUE
        );

        // ✅ 方式2：百分比增加
        // 每级增加 10% 最大生命值
        // I级 = 10%, II级 = 20%, III级 = 30%
        this.addAttributeModifier(
            Attributes.MAX_HEALTH,
            ResourceLocation.fromNamespaceAndPath(Biotech.MODID, "strength_health"),
            0.1,  // 10%
            AttributeModifier.Operation.ADD_MULTIPLIED_BASE
        );

        // ✅ 方式3：修改你的自定义属性
        // 每级增加 2 点最大能量
        this.addAttributeModifier(
            AttributeRegistry.MAX_POWER,
            ResourceLocation.fromNamespaceAndPath(Biotech.MODID, "strength_power"),
            2.0,
            AttributeModifier.Operation.ADD_VALUE
        );
    }
}

