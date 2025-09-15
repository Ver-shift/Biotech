package org.galaxy.biotech.api.gene;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;

public class GeneData {

//类似于铁魔法的技能
    public static final String Gene_ID = "id";
    public static final String Gene_LOCKED = "locked";

//    public static final Codec< GeneData> CODEC = RecordCodecBuilder.create(builder -> builder.group(
//            ResourceLocation.CODEC.fieldOf(Gene_ID).forGetter(data -> data),
//            Codec.BOOL.optionalFieldOf(Gene_LOCKED, false).forGetter( GeneData)
//    ).apply(builder,  GeneData::new));

    protected final AbstractGene gene;

    private GeneData() throws Exception {
        throw new Exception("Cannot create empty spell slots.");
    }
    public GeneData(AbstractGene gene) {
        this.gene = gene;
    }
}
