package org.galaxy.biotech.api.gene.inventory;

import org.galaxy.biotech.api.gene.Gene;

public enum GeneSlot {
    SPECIES(0, "species", Gene.GeneType.SPECIES_GENE),
    SKILL(1, "skill", Gene.GeneType.SKILL_GENE),
    TALENT(2, "talent", Gene.GeneType.SKILL_GENE),
    EQUIPMENT(3, "equipment", Gene.GeneType.EQUIP_GENE);

    private final int index;
    private final String slotName;
    private final Gene.GeneType geneType;

    GeneSlot(int index , String slotName, Gene.GeneType staticType) {
        this.index= index;
        this.slotName = slotName;
        this.geneType = staticType;
    }

    public int getIndex() {
        return index;
    }

    public String getSlotName() {
        return slotName;
    }

    public Gene.GeneType getGeneType() {
        return geneType;
    }
    //种族基因
    //异能基因
    //威能基因
    //异种基因
}
