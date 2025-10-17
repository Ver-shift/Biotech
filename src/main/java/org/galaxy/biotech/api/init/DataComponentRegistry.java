package org.galaxy.biotech.api.init;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.galaxy.biotech.Biotech;

public class DataComponentRegistry {
    private static DeferredRegister.DataComponents DATA_COMPONENTS = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, Biotech.MODID);

    public static void register(IEventBus eventBus){
        DATA_COMPONENTS.register(eventBus);
    }
}
