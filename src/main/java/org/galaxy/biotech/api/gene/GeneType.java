package org.galaxy.biotech.api.gene;

import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.item.Item;

public enum GeneType {
    APPEARANCE(0), //外观基因
    PASSIVE_CAPABILITY(1),//被动特殊能力基因
    ACTIVE_CAPABILITY(2),//主动特殊能力基因
    ATTRIBUTE(3);//属性基因



    private final int value;

    GeneType(final int newValue) {
        value = newValue;
    }
    public int getValue() {
        return value;
    }

    public boolean providerAttribute() {
        return this == PASSIVE_CAPABILITY || this == ATTRIBUTE || this == ACTIVE_CAPABILITY;
    }






}
