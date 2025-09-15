package org.galaxy.biotech.api.event;

import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.event.entity.living.LivingEvent;
import org.galaxy.biotech.api.entityGene.EntityGeneData;


public class ChangeMetabolicRateEvent extends LivingEvent {


    private final EntityGeneData entityGeneData;


    private final float oldMetabolicRate;


    private float newMetabolicRate;


    public ChangeMetabolicRateEvent(LivingEntity entity, EntityGeneData entityGeneData, float oldMetabolicRate, float newMetabolicRate) {
        super(entity);
        this.entityGeneData = entityGeneData;
        this.oldMetabolicRate = oldMetabolicRate;
        this.newMetabolicRate = newMetabolicRate;
    }


    public EntityGeneData getEntityGeneData() {
        return entityGeneData;
    }


    public float getOldMetabolicRate() {
        return oldMetabolicRate;
    }


    public float getNewMetabolicRate() {
        return newMetabolicRate;
    }

    public void setNewMetabolicRate(float newMetabolicRate) {
        this.newMetabolicRate = newMetabolicRate;
    }
}
