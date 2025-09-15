package org.galaxy.biotech.api.init;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.galaxy.biotech.Biotech;


public class ItemInit {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Biotech.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
    // 基础物品（无属性修饰符）





