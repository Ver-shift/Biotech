package org.galaxy.biotech.api.util;

import net.minecraft.resources.ResourceLocation;
import org.galaxy.biotech.Biotech;

public class RLHelper {
    //用于确定游戏资源和路径
    public static final String MOD_ID = Biotech.MODID;


    //基因路径("biotech:texture/gene/icon/+ 基因名")
    public static ResourceLocation getGeneID(String geneID){
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, "texture/gene/icon/" + geneID);
    }
    //组件路径("biotech:texture/gene/component/ + 组件名")
    public static ResourceLocation getSpeciesID(String speciesID){
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, "texture/gene/component/" + speciesID);

    }
    //种族路径("biotech:texture/gene/species_type/ + 种族名")
    public static ResourceLocation getGeneTypeID(String geneTypeID){
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, "texture/gene/species_type/" + geneTypeID);
    }
}
