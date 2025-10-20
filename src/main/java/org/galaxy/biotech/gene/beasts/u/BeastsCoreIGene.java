package org.galaxy.biotech.gene.beasts.u;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import org.galaxy.biotech.api.gene.Gene;
import org.galaxy.biotech.api.init.SpeciesTypeRegistry;


public class BeastsCoreIGene extends Gene {


    public BeastsCoreIGene() {
        super(new Gene.GeneConfig()
                .geneId("aa")
                .speciesType(SpeciesTypeRegistry.BEASTS.get())
                .geneType(GeneType.SPECIES_GENE)
                .build());
    }




}
