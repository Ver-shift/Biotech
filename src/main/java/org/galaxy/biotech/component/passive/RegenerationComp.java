package org.galaxy.biotech.component.passive;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import org.galaxy.biotech.api.gene.IGeneEventHandle;
import org.galaxy.biotech.util.DeBug;

import java.util.Objects;

/**
 * 再生能力 Component 示例
 * 演示如何实现 IGeneEventHandle 接口来处理事件
 */
public class RegenerationComp implements IGeneEventHandle {

    private final float damageReduction; // 伤害减免百分比

    public RegenerationComp(float damageReduction) {
        this.damageReduction = damageReduction;
    }

    public float getDamageReduction() {
        return damageReduction;
    }

    // 实现受伤事件：减少伤害
    @Override
    public void hurt(LivingDamageEvent.Pre event) {
        // 使用新的 API 获取和设置伤害
        float originalDamage = event.getNewDamage();
        float reducedDamage = originalDamage * (1 - damageReduction);
        event.setNewDamage(reducedDamage);

        DeBug.LOGGER.info("fuck oj8k");
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.damageReduction);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else {
            return obj instanceof RegenerationComp regen
                    && Float.compare(this.damageReduction, regen.damageReduction) == 0;
        }
    }

    // Codec 用于序列化/反序列化
    public static final Codec<RegenerationComp> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.FLOAT.fieldOf("damage_reduction").forGetter(RegenerationComp::getDamageReduction)
            ).apply(instance, RegenerationComp::new)
    );

    // StreamCodec 用于网络同步
    public static final StreamCodec<ByteBuf, RegenerationComp> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.FLOAT, RegenerationComp::getDamageReduction,
            RegenerationComp::new
    );
}
