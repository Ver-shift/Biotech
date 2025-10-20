package org.galaxy.biotech.api.gene;

import net.neoforged.bus.api.Event;

public interface IGeneEventHandle<T extends Event> {
    void death(T event);
    void jump(T event);
}
