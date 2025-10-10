package org.galaxy.biotech.api.gene;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public enum GeneRarity {
    COMMON(0),
    UNCOMMON(1),
    RARE(2),
    EPIC(3),
    LEGENDARY(4);

    private final int value;

    GeneRarity(final int newValue) {
        value = newValue;
    }
    public int getValue() {
        return this.value;
    }
    public int compareRarity(GeneRarity other) {
        return Integer.compare(this.getValue(), other.getValue());
    }


    public MutableComponent getDisplayName() {
        return DISPLAYS[getValue()];
    }
    private final MutableComponent[] DISPLAYS = {
            Component.translatable("rarity.biotech.common").withStyle(ChatFormatting.GRAY),
            Component.translatable("rarity.biotech.uncommon").withStyle(ChatFormatting.GREEN),
            Component.translatable("rarity.biotech.rare").withStyle(ChatFormatting.AQUA),
            Component.translatable("rarity.biotech.epic").withStyle(ChatFormatting.LIGHT_PURPLE),
            Component.translatable("rarity.biotech.legendary").withStyle(ChatFormatting.GOLD),

    };


    public ChatFormatting getChatFormatting() {
        return switch (this) {
            case COMMON -> ChatFormatting.GRAY;
            case UNCOMMON -> ChatFormatting.GREEN;
            case RARE -> ChatFormatting.AQUA;
            case EPIC -> ChatFormatting.LIGHT_PURPLE;
            case LEGENDARY -> ChatFormatting.GOLD;
        };
    }
}
