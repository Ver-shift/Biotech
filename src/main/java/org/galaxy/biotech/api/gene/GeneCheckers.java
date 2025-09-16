package org.galaxy.biotech.api.gene;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import org.galaxy.biotech.Biotech;

import java.util.Locale;
import java.util.function.Supplier;

/**
 * @author baka4n
 * @code @Date 2025/9/16 13:33:18
 */
public enum GeneCheckers implements Supplier<ResourceKey<GeneSequenceChecker>> {
    TEST;

    private final ResourceKey<GeneSequenceChecker> key;

    GeneCheckers(ResourceLocation location) {
        this.key = ResourceKey.create(GeneSequenceChecker.GENE_CHECKER, location);
    }

    GeneCheckers(String path) {
        this(Biotech.id(path));
    }

    GeneCheckers() {
        this.key = ResourceKey.create(GeneSequenceChecker.GENE_CHECKER, Biotech.id(name().toLowerCase()));
    }

    @Override
    public ResourceKey<GeneSequenceChecker> get() {
        return key;
    }
}
