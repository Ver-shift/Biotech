package org.galaxy.biotech.gene.beasts.u;

import org.galaxy.biotech.api.gene.Gene;
import org.galaxy.biotech.api.init.GeneDataComponentRegistry;
import org.galaxy.biotech.api.init.SpeciesTypeRegistry;


public class BeastsCoreGene extends Gene {

    public BeastsCoreGene() {
        super(new Gene.GeneConfig()
                .geneId("aa")
                .speciesType(SpeciesTypeRegistry.BEASTS.get())
                .geneType(GeneType.SPECIES_GENE)
                .component(GeneDataComponentRegistry.ComponentReg.REGENERATION.get())
                .build());
    }




}
