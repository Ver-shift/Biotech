package org.galaxy.biotech.gene.beasts.u;

import org.galaxy.biotech.api.gene.Gene;
import org.galaxy.biotech.api.init.GeneComps;
import org.galaxy.biotech.api.init.SpeciesReg;
import org.galaxy.biotech.api.util.RLHelper;
import org.galaxy.biotech.component.passive.ExampleComp;
import org.galaxy.biotech.component.passive.RegenerationComp;


public class BeastsCoreGene extends Gene {

    public BeastsCoreGene() {
        super(new Gene.GeneConfig()
                .ResourceLocation(RLHelper.getGeneID("beasts_core"))
                .speciesType(SpeciesReg.BEASTS)
                .geneLevel(10)
                .geneType(GeneType.SPECIES_GENE)
                .component(GeneComps.BASIC_EXAMPLE, new ExampleComp(1, true))
                .component(GeneComps.REGENERATION, new RegenerationComp(1))
                .build());
    }


}
