package org.galaxy.biotech.gene.beasts.u;

import net.minecraft.core.component.DataComponentType;
import net.neoforged.fml.common.EventBusSubscriber;
import org.galaxy.biotech.Biotech;
import org.galaxy.biotech.api.gene.Gene;
import org.galaxy.biotech.api.gene.SpeciesType;

@EventBusSubscriber(modid = Biotech.MODID)
public class BeastsCoreGene extends Gene {


    public BeastsCoreGene(String id, SpeciesType species, DataComponentType<?> component) {
        super(id, species, component);
    }



}
