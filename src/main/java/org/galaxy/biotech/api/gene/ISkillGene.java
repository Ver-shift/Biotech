package org.galaxy.biotech.api.gene;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.galaxy.biotech.api.gene.cast.CastSource;

public interface ISkillGene {
    void onCastSkill(Level level, int skillLevel, LivingEntity livingEntity, CastSource castSource);
}
