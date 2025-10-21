package org.galaxy.biotech.component.passive;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import org.galaxy.biotech.api.component.BaseGeneComponent;
import org.galaxy.biotech.api.util.DeBug;

import java.util.Objects;


public class ExampleComp extends BaseGeneComponent {

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

    @Override
    public void onDeath(LivingDeathEvent event) {
        DeBug.LOGGER.info("hahahah");
        super.onDeath(event);
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
