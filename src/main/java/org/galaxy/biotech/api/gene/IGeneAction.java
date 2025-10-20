package org.galaxy.biotech.api.gene;

import net.neoforged.bus.api.Event;

public interface IGeneAction {
    void onEquip(Contexts contexts);
    void onUnequip(Contexts contexts);
    void onEquipCast(Contexts contexts);
    void onEquipTick(Contexts contexts, int realTick);

}
