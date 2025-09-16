package org.galaxy.biotech.api.gene;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.DataPackRegistryEvent;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import net.neoforged.neoforge.registries.RegistryBuilder;
import org.checkerframework.checker.units.qual.C;
import org.galaxy.biotech.Biotech;

import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

/**
 * 基因序列检查器
 * 上基因检查后对下基因也进行检查，A <->T   G<->C
 * @author baka4n
 * @code @Date 2025/9/16 12:29:55
 */
@EventBusSubscriber(modid = Biotech.MODID)
public record GeneSequenceChecker(
        String sequence,
        Holder<Attribute> attributeS,
        double level,
        AttributeModifier.Operation mode) {
    /**
     * 检查并添加attribute
     */
    public void check(ResourceLocation location, LivingEntity entity) {
        //授予living entity属性效果
        AttributeInstance instance = entity.getAttributes().getInstance(attributeS);
        if (instance != null) {
            instance.removeModifier(location);
            instance.addTransientModifier(new AttributeModifier(
                    location,
                    level,
                    mode
            ));
        }
    }

    /**
     * dna被销毁时清理buff
     */
    public void clean(ResourceLocation location, LivingEntity entity) {
        //授予living entity属性效果
        AttributeInstance instance = entity.getAttributes().getInstance(attributeS);
        if (instance != null) {
            instance.removeModifier(location);
        }
    }


    public static Codec<GeneSequenceChecker> CODEC =
            RecordCodecBuilder.create(instance ->
                    instance.group(
                            Codec.STRING.fieldOf("sequence").forGetter(checker -> checker.sequence),
                            Attribute.CODEC.fieldOf("attributeS").forGetter(checker -> checker.attributeS),
                            Codec.DOUBLE.fieldOf("level").forGetter(checker -> checker.level),
                            AttributeModifier.Operation.CODEC.fieldOf("mode").forGetter(checker -> checker.mode)
                    )
                            .apply(instance, GeneSequenceChecker::new)
            );


    public static final ResourceKey<Registry<GeneSequenceChecker>> GENE_CHECKED =
            ResourceKey.createRegistryKey(Biotech.id("gene_checker"));
    public static void neoRegistry(DataPackRegistryEvent.NewRegistry event) {
        event.dataPackRegistry(
                GENE_CHECKED,
                CODEC,
                CODEC,
                b -> b.sync(true)
        );
    }
}
