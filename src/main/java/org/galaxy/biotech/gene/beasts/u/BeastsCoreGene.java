package org.galaxy.biotech.gene.beasts.u;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import org.galaxy.biotech.api.gene.Gene;
import org.galaxy.biotech.api.gene.SpeciesType;
import org.galaxy.biotech.api.init.SpeciesTypeRegistry;


public class BeastsCoreGene extends Gene {


    public BeastsCoreGene() {
        super(new Gene.GeneConfig()
                .geneId("aa")
                .speciesType(SpeciesTypeRegistry.BEASTS.get())
                .geneType(GeneType.SPECIES_GENE)
                .build());
    }
    Item item =  new Item.Properties().component(DataComponents.ATTRIBUTE_MODIFIERS, modifiers);


    ItemAttributeModifiers modifiers = Item;

}
