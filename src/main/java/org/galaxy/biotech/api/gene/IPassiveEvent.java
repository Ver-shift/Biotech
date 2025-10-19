package org.galaxy.biotech.api.gene;

import net.neoforged.neoforge.event.entity.living.LivingEvent;

public interface IPassiveEvent<T extends LivingEvent> {
    void eventHandle(T event);
    Class<T> getEventType();
}
