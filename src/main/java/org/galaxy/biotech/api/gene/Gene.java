package org.galaxy.biotech.api.gene;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.component.*;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.MutableDataComponentHolder;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.galaxy.biotech.Biotech;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;
import java.util.function.Supplier;
public class Gene implements MutableDataComponentHolder{

    //基础信息==========================================================
    //不可变信息
    private  ResourceLocation Id;                 //路径，标识符
    private  SpeciesType species;                 //种族类型
    private  GeneType geneType;                   //基因类型

    //可变信息
    private int maxGeneLevel;                            //基因等级
    private GeneRarity rarity;                    //基因稀有度
    private PatchedDataComponentMap components;   //组件：实现所有功能的核心

    //不变信息初始化===================================================
    public Gene(GeneConfig config){
        // 从 config 中读取不可变信息
        this.Id = config.id;
        this.species = config.species;
        this.geneType = config.geneType;

        // 从 config 中读取可变信息
        this.maxGeneLevel = config.maxGeneLevel;

        // 从 config 的 Builder 中构建组件映射
        DataComponentMap builtComponents = config.components.build();
        this.components = new PatchedDataComponentMap(builtComponents);

        // 初始化稀有度（可以后续通过其他方法设置）
        this.rarity = null;
    }

    //等级与稀有度控制=================================================





    //组件初始化======================================================

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















    //辅助类==========================================================

    public static class GeneConfig{

        private ResourceLocation id;
        private SpeciesType species;
        private GeneType geneType;
        private int maxGeneLevel;

        private DataComponentMap.Builder components;

        // 默认构造函数
        public GeneConfig(){
            components = DataComponentMap.builder();
            this.maxGeneLevel = 3; // 默认最大等级为3
        }

        // 接受Consumer的构造函数，参考DefaultConfig模式
        public GeneConfig(Consumer<GeneConfig> initialize) throws RuntimeException {
            components = DataComponentMap.builder();
            this.maxGeneLevel = 3; // 默认最大等级为3
            initialize.accept(this);
            build();
        }

        public GeneConfig ResourceLocation (ResourceLocation id){
            this.id = id;
            return this;
        }

        public GeneConfig speciesType(SpeciesType species){
            this.species = species;
            return this;
        }

        // 修复bug：应该设置传入的参数值而不是固定的1
        public GeneConfig geneLevel(int maxGeneLevel){
            this.maxGeneLevel = maxGeneLevel;
            return this;
        }

        public GeneConfig speciesType(Supplier<SpeciesType> supplier){
            this.species = supplier.get();
            return this;
        }


        public GeneConfig geneType(GeneType geneType){
            this.geneType = geneType;
            return this;
        }

        public <T> GeneConfig component(DataComponentType<T> dataComponentType, T value){
            components.set(dataComponentType, value);
            return this;
        }

        public <T> GeneConfig component(DeferredHolder<DataComponentType<?>, DataComponentType<T>> holder, T value){
            components.set(holder.get(), value);
            return this;
        }

        public GeneConfig build() throws RuntimeException {
            if (!this.validate())
                throw new RuntimeException("You didn't define all required gene config attributes! Missing: " +
                        (id == null ? "id " : "") +
                        (species == null ? "species " : "") +
                        (geneType == null ? "geneType " : ""));
            return this;
        }

        private boolean validate() {
            return this.id != null && this.species != null && this.geneType != null;
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
