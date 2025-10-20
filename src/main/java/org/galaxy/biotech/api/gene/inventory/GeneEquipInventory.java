package org.galaxy.biotech.api.gene.inventory;

import net.minecraft.world.entity.EquipmentSlotGroup;

public enum GeneEquipInventory {
    SPECIES_GROUP(0, "species_group",1),
    SKILL_GROUP(1, "skill_group",3),
    TALENT_GROUP(2, "talent_group",2),
    EQUIPMENT_GROUP(3, "equipment_group",6);

    private final int id;
    private final String key;
    private final int slotCount;

    GeneEquipInventory(int id , String key, int slotCount) {
        this.id = id;
        this.key = key;
        this.slotCount = slotCount;
    }

    public int getId() {
        return id;
    }

    public int getSlotCount() {
        return slotCount;
    }

    public String getKey() {
        return key;
    }
//    EquipmentSlotGroup
//    EquipmentSlot;
}
