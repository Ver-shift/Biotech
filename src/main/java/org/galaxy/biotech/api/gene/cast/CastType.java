package org.galaxy.biotech.api.gene.cast;

public enum CastType {
    NONE(0),//无
    INSTANT(1),//顺发
    LONG(2),//蓄力释放
    CONTINUOUS(3);//持续的技能

    private final int value;

    CastType(final int newValue) {
        value = newValue;
    }

    public int getValue() {
        return value;
    }

    public boolean immediatelySuppressRightClicks() {
        return this == LONG || this == CONTINUOUS;
    }
}
