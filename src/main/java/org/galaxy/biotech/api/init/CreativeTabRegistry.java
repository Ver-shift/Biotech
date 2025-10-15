package org.galaxy.biotech.api.init;



import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.galaxy.biotech.Biotech;

public class CreativeTabRegistry {

    private static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Biotech.MODID);
    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TUBE_TAB = TABS.register("biotech_tube", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + Biotech.MODID + ".biotech_tube"))
            .icon(() -> new ItemStack(ItemRegistry.TUBE.get()))
            .displayItems((enabledFeatures, entries) -> {
                entries.accept(ItemRegistry.TUBE.get());


            })
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .build());
}
