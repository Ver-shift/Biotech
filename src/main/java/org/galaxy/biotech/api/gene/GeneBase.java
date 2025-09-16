package org.galaxy.biotech.api.gene;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.util.StringRepresentable;

import java.io.Serializable;

/**
 * dna的a t g c片段类型
 * @author baka4n
 * @code @Date 2025/9/16 12:01:29
 */
@MethodsReturnNonnullByDefault
public enum GeneBase implements StringRepresentable {
    EMPTY(' '),//缺失片段空格表示，缺失越多对身体影响越大
    ADENINE('A'),
    THYMINE('T'),
    GUANINE('G'),
    CYTOSINE('C');

    private final char symbol;
    GeneBase(char symbol) {
        this.symbol = symbol;
    }

    public static GeneBase from(char c) {
        for (GeneBase value : values()) {
            if (value.symbol == c) {
                return value;
            }
        }
        return EMPTY;
    }

    @Override
    public String getSerializedName() {
        return String.valueOf(symbol);
    }
}
