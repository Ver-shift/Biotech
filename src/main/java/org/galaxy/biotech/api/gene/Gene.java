package org.galaxy.biotech.api.gene;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.component.*;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.MutableDataComponentHolder;
import org.galaxy.biotech.Biotech;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class Gene implements MutableDataComponentHolder{


    //不变量
    //id，种族，

    //改变量
    //最大等级，稀有度，属性加成（gene内部处理）power消耗值,消耗值每个等级||主动，被动，

    //基础构造方法
    public Gene(GeneConfig config) {
        this.geneId = config.geneId;
        this.species = config.species;
        this.texture = getTexture();
        this.components = new PatchedDataComponentMap(PatchedDataComponentMap.EMPTY);
    }

    //发包用
    public Gene(String id , SpeciesType species, DataComponentPatch patch){
        this.geneId = id;
        this.species = species;
        this.texture = getTexture();
        this.components = PatchedDataComponentMap.fromPatch(DataComponentMap.EMPTY, patch);

    }



    //组件初始化======================================================
    private PatchedDataComponentMap components;

    public Gene(ResourceLocation resourceLocation, DataComponentPatch patch, String s, String s1) {

    }

    @Override
    public PatchedDataComponentMap getComponents() {
        return this.components;
    }
    @Override
    public <T> @Nullable T set(DataComponentType<? super T> dataComponentType, @Nullable T t) {
        return this.components.set(dataComponentType, t);
    }
    @Override
    public <T> @Nullable T remove(DataComponentType<? extends T> dataComponentType) {
        return this.components.remove(dataComponentType);
    }
    @Override
    public void applyComponents(DataComponentMap dataComponentMap) {
        this.components.setAll(dataComponentMap);
    }
    @Override
    public void applyComponents(DataComponentPatch dataComponentPatch) {
        this.components.applyPatch(dataComponentPatch);
    }

    public static final Codec<Gene> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    ResourceLocation.CODEC.fieldOf("geneTexture").forGetter(Gene::getTexture),
                    DataComponentPatch.CODEC.optionalFieldOf("components",DataComponentPatch.EMPTY).forGetter(holder -> holder.components.asPatch()),
                    Codec.STRING.fieldOf("geneId").forGetter(Gene::getGeneId),
                    Codec.STRING.fieldOf("speciesId").forGetter(Gene::getSpeciesId)
            ).apply(instance, Gene::new)
    );

//    public static final StreamCodec STREAM_CODEC;


    //基础信息==========================================================
    private String geneId; //基因id，用于标识，以及快捷查找,还有翻译键
    private ResourceLocation texture; //由Id决定的图片路径
    private SpeciesType species;
    private String speciesId;
    private GeneType geneType;


    public ResourceLocation getTexture() {
        return ResourceLocation.fromNamespaceAndPath(Biotech.MODID, "textures/gene/"+ getSpecies().getSpeciesId() + getGeneId() + ".png");
    }

    public String getGeneId() {
        return geneId;
    }

    public SpeciesType getSpecies() {
        return species;
    }


    public String getSpeciesId() {
        return species.getSpeciesId();
    }

    public GeneType getGeneType() {
        return geneType;
    }

    //行为=============================================================
    //装备时触发

//    void onEquip(Contexts contexts){}
//    void onUnequip(Contexts contexts){}
//    void onEquipCast(Contexts contexts){
//
//    }
//    void onEquipTick(Contexts contexts,int realTick){
//    }





    public static class GeneConfig{

        private String geneId;
        private SpeciesType species;
        private GeneType geneType;
        private DataComponentMap.Builder components;

        public GeneConfig(Consumer<GeneConfig> intialize) throws RuntimeException {
            intialize.accept(this);
            build();
        }
        public GeneConfig(){
            components = DataComponentMap.builder();
        }

        public GeneConfig geneId (String geneId){
            this.geneId = geneId;
            return this;
        }

        public GeneConfig speciesType(SpeciesType species){
            this.species = species;
            return this;
        }

        public GeneConfig geneType(GeneType geneType){
            this.geneType = geneType;
            return this;
        }
        public <T> GeneConfig component(DataComponentType<T> dataComponentType){
            components.set(dataComponentType,value);
            return this;
        }

        public GeneConfig build() throws RuntimeException {
            if (!this.validate())
                throw new RuntimeException("You didn't define all config attributes!");
            return this;
        }

        private boolean validate() {
            return this.geneId != null && this.species != null && this.geneType != null;
        }
    }

    public enum GeneType {
        SPECIES_GENE("species", "种族基因"),
        SKILL_GENE("skill", "技能基因"),
        TALENT_GENE("talent", "天赋基因"),
        EQUIP_GENE("equip", "装备基因");

        private final String id;
        private final String description;

        GeneType(String id, String description) {
            this.id = id;
            this.description = description;
        }

        public String getId() {
            return id;
        }

        public String getDescription() {
            return description;
        }

        public static GeneType fromId(String id) {
            for (GeneType type : values()) {
                if (type.id.equals(id)) {
                    return type;
                }
            }
            return null;
        }
    }
}
