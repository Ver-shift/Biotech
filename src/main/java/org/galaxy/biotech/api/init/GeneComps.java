package org.galaxy.biotech.api.init;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.galaxy.biotech.Biotech;
import org.galaxy.biotech.component.passive.ExampleComp;
import org.galaxy.biotech.component.passive.RegenerationComp;


public class GeneComps {
    //Component注册表

    private static DeferredRegister.DataComponents DATA_COMPONENTS = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, Biotech.MODID);
    public static void register(IEventBus eventBus){
        DATA_COMPONENTS.register(eventBus);
    }





    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ExampleComp>> BASIC_EXAMPLE;
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<RegenerationComp>> REGENERATION;

    static {
        BASIC_EXAMPLE = DATA_COMPONENTS.registerComponentType(
                "basic",
                builder -> builder
                        .persistent(ExampleComp.BASIC_CODEC)
                        .networkSynchronized(ExampleComp.BASIC_STREAM_CODEC)
        );

        REGENERATION = DATA_COMPONENTS.registerComponentType(
                "regeneration",
                builder -> builder
                        .persistent(RegenerationComp.CODEC)
                        .networkSynchronized(RegenerationComp.STREAM_CODEC)
        );
    }


}
