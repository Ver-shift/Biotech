package org.galaxy.biotech.capabilities;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.attachment.IAttachmentHolder;
import net.neoforged.neoforge.attachment.IAttachmentSerializer;
import org.galaxy.biotech.api.entityGene.EntityGeneData;
import org.jetbrains.annotations.Nullable;

public class EntityGeneDataProvider implements IAttachmentSerializer<CompoundTag, EntityGeneData> {

    @Override
    public EntityGeneData read(IAttachmentHolder iAttachmentHolder, CompoundTag compoundTag, HolderLookup.Provider provider) {
        var entityGeneData =  iAttachmentHolder instanceof LivingEntity livingEntity ? new EntityGeneData(livingEntity) : null;
        entityGeneData.deserializeNBT(provider,compoundTag);
        return entityGeneData;
    }

    @Override
    public @Nullable CompoundTag write(EntityGeneData entityGeneData, HolderLookup.Provider provider) {
        return entityGeneData.serializeNBT(provider);
    }
}
