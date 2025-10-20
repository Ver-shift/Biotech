package org.galaxy.biotech.api.init;

import com.mojang.serialization.Codec;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.galaxy.biotech.Biotech;
import org.galaxy.biotech.api.gene.data.GeneData;
import org.galaxy.biotech.api.power.PowerData;

public class DataAttachmentRegistry {
    private static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, Biotech.MODID);
    public static void register(IEventBus eventBus) {
        ATTACHMENT_TYPES.register(eventBus);
    }




    public static final DeferredHolder<AttachmentType<?>, AttachmentType<PowerData>> POWER_DATA = ATTACHMENT_TYPES.register("power_data",
            () -> AttachmentType.builder((holder) -> holder instanceof ServerPlayer serverPlayer ? new PowerData(serverPlayer) : new PowerData())
                    .serialize(PowerData.RECORD_CODEC)
                    .build());

    public static final DeferredHolder<AttachmentType<?>, AttachmentType<GeneData>> GENE_DATA = ATTACHMENT_TYPES.register("gene_data",
            () -> AttachmentType.builder((holder) -> holder instanceof LivingEntity entity ? new GeneData(entity) : null)
                    .serialize(GeneData.RECORD_CODEC)
                    .build());
}
