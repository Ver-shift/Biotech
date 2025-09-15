package org.galaxy.biotech.api.gene;

public enum GeneRaceType {
    VAMPIRE(0),      // 血族
    MECHANICAL(1),   // 机械族
    DRAGON(2),       // 巨龙种
    PHANTOM(3),      // 幻兽种（魔法）
    UNDEAD(4),       // 亡灵异形种
    BEAST(5),        // 野兽
    ORC(6),          // 兽人
    HUMAN(7),        // 智人
    ELEMENTAL(8);     // 元素种

    private final int value;


    GeneRaceType(final int newValue) {
        value = newValue;
    }

    public int getValue() {
        return this.value;
    }
}