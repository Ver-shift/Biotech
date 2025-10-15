package org.galaxy.biotech.api.init;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.item.SpellBook;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.galaxy.biotech.api.item.Tube;

public class ItemRegistry {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, IronsSpellbooks.MODID);
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final DeferredHolder<Item, Item> TUBE = ITEMS.register("tube", Tube::new);


}
