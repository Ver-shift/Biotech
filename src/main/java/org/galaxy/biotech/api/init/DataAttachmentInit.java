package org.galaxy.biotech.api.init;

import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.galaxy.biotech.Biotech;
import org.galaxy.biotech.api.entityGene.EntityGeneData;
import org.galaxy.biotech.capabilities.EntityGeneDataProvider;

public class DataAttachmentInit  {
    private static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, Biotech.MODID);

    public static void register(IEventBus eventBus) {
        ATTACHMENT_TYPES.register(eventBus);
    }

    public static final DeferredHolder<AttachmentType<?>, AttachmentType<EntityGeneData>> ENTITY_GENE_DATA = ATTACHMENT_TYPES.register("entity_gene_data",
            () -> AttachmentType.builder((holder) -> holder instanceof LivingEntity livingEntity ? new EntityGeneData(livingEntity):null).serialize(new EntityGeneDataProvider()).build());
}
