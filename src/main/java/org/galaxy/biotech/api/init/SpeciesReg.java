package org.galaxy.biotech.api.init;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.galaxy.biotech.Biotech;
import org.galaxy.biotech.api.gene.SpeciesType;

import java.util.function.Supplier;

public class SpeciesReg {
    //种族



    //初始化
    public static final ResourceKey<Registry<SpeciesType>> SPECIES_REGISTRY_KEY = ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath(Biotech.MODID, "species"));
    private static final DeferredRegister<SpeciesType> SPECIES = DeferredRegister.create(SPECIES_REGISTRY_KEY, Biotech.MODID);
    public static void register(IEventBus eventBus) {
        SPECIES.register(eventBus);
    }

    //根据id获取species实例。

    //注册
    public static final Supplier<SpeciesType> BEASTS;

    static {
        BEASTS = SPECIES.register("beasts",
                () -> new SpeciesType(Component.translatable("species.biotech.beasts").withStyle(ChatFormatting.GOLD)
                        ,"beasts"));

    }
}
