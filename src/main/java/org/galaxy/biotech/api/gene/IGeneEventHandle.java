package org.galaxy.biotech.api.gene;

import net.neoforged.bus.api.Event;

public interface IGeneEventHandle<T extends Event> {
    default void death(T event){

    };
    default void jump(T event){

    };
}
