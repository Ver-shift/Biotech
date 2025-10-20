package org.galaxy.biotech.api.init;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.galaxy.biotech.Biotech;
import org.galaxy.biotech.component.passive.ExampleComp;
import org.galaxy.biotech.component.passive.RegenerationComp;


public class GeneDataComponentRegistry {


    public static class ComponentReg{
        //Component注册表
        private static DeferredRegister.DataComponents DATA_COMPONENTS = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, Biotech.MODID);

        public static void register(IEventBus eventBus){
            DATA_COMPONENTS.register(eventBus);
        }

        public static final DeferredHolder<DataComponentType<?>, DataComponentType<ExampleComp>> BASIC_EXAMPLE = DATA_COMPONENTS.registerComponentType(
                "basic",
                builder -> builder
                        .persistent(ExampleComp.BASIC_CODEC)
                        .networkSynchronized(ExampleComp.BASIC_STREAM_CODEC)
        );

        // 注册再生能力 Component
        public static final DeferredHolder<DataComponentType<?>, DataComponentType<RegenerationComp>> REGENERATION = DATA_COMPONENTS.registerComponentType(
                "regeneration",
                builder -> builder
                        .persistent(RegenerationComp.CODEC)
                        .networkSynchronized(RegenerationComp.STREAM_CODEC)
        );
    }



}
