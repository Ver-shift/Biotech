package org.galaxy.biotech.component.passive;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.living.LivingEvent;
import org.galaxy.biotech.api.gene.IGeneEventHandle;

import java.util.Objects;

// 移除 @EventBusSubscriber，因为现在通过 GeneEvent 统一触发
public class ExampleComp implements IGeneEventHandle {

    private final int value1;
    private final boolean value2;

    public ExampleComp(int value1, boolean value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public int getValue1() {
        return value1;
    }

    public boolean getValue2() {
        return value2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value1, this.value2);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else {
            return obj instanceof ExampleComp ex
                    && this.value1 == ex.value1
                    && this.value2 == ex.value2;
        }
    }

    // 实现跳跃事件处理
    @Override
    public void jump(LivingEvent.LivingJumpEvent event) {
        // 当装载了这个 component 的 gene 的玩家跳跃时触发
        System.out.println("玩家跳跃了！value1=" + value1 + ", value2=" + value2);
        // 这里可以添加你的逻辑，例如给玩家额外的跳跃高度
        event.getEntity().setDeltaMovement(
                event.getEntity().getDeltaMovement().add(0, 0.2 * value1, 0)
        );
    }

    // 实现死亡事件处理
    @Override
    public void death(LivingDeathEvent event) {
        // 当装载了这个 component 的 gene 的玩家死亡时触发
        System.out.println("玩家死亡了！value1=" + value1);
        // 这里可以添加你的逻辑，例如死亡时掉落特殊物品
    }

    public static final Codec<ExampleComp> BASIC_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.INT.fieldOf("value1").forGetter(ExampleComp::getValue1),
                    Codec.BOOL.fieldOf("value2").forGetter(ExampleComp::getValue2)
            ).apply(instance, ExampleComp::new)
    );

    public static final StreamCodec<ByteBuf, ExampleComp> BASIC_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT, ExampleComp::getValue1,
            ByteBufCodecs.BOOL, ExampleComp::getValue2,
            ExampleComp::new
    );
}
