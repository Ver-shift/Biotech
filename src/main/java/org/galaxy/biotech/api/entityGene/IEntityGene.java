package org.galaxy.biotech.api.entityGene;

import net.minecraft.nbt.CompoundTag;
import net.neoforged.neoforge.common.util.INBTSerializable;

public interface IEntityGene extends INBTSerializable<CompoundTag> {

    float getComplexity();
    float getMetabolicRate();

}
