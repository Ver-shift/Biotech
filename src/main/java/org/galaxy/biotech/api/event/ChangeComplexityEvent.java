package org.galaxy.biotech.api.event;

import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.event.entity.living.LivingEvent;
import org.galaxy.biotech.api.entityGene.EntityGeneData;


public class ChangeComplexityEvent extends LivingEvent {


    private final EntityGeneData entityGeneData;

    private final float oldComplexity;

    private float newComplexity;

    public ChangeComplexityEvent(LivingEntity entity, EntityGeneData entityGeneData, float oldComplexity, float newComplexity) {
        super(entity);
        this.entityGeneData = entityGeneData;
        this.oldComplexity = oldComplexity;
        this.newComplexity = newComplexity;
    }

    public EntityGeneData getEntityGeneData() {
        return entityGeneData;
    }

    public float getOldComplexity() {
        return oldComplexity;
    }

    public float getNewComplexity() {
        return newComplexity;
    }

    public void setNewComplexity(float newComplexity) {
        this.newComplexity = newComplexity;
    }
}
