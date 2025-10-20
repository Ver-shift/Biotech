package org.galaxy.biotech.api.gene.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.event.entity.living.LivingEvent;
import org.galaxy.biotech.api.gene.Gene;
import org.galaxy.biotech.api.init.GeneRegistry;
import org.galaxy.biotech.api.power.PowerData;

public class GeneData {
    private Gene gene;
    private LivingEntity entity;

    private static final String GENE_ID = "gene_id";
    private static final String GENE = "gene";

    public GeneData(Gene gene) {
        this.gene = gene;
    }

    public GeneData(LivingEntity entity) {
        this.entity = entity;
    }
    public GeneData(String geneId){

    }

    public Gene getGene() {
        return gene;
    }

    public LivingEntity getEntity() {
        return entity;
    }

    public static final Codec<GeneData> RECORD_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.STRING.fieldOf(GENE_ID).forGetter(geneData -> geneData.gene.getGeneId())
            ).apply(instance, GeneData::new)
    );
}
