package org.galaxy.biotech.api.gene;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.component.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.Slot;
import net.neoforged.neoforge.common.MutableDataComponentHolder;
import org.galaxy.biotech.Biotech;
import org.jetbrains.annotations.Nullable;

public class Gene implements MutableDataComponentHolder {


    //不变量
    //id，种族，

    //改变量
    //最大等级，稀有度，属性加成（gene内部处理）||主动，被动，

    //基础构造方法
    public Gene(String id, SpeciesType species, DataComponentType<?> component) {
        this.geneId = id;
        this.species = species;
        this.texture = getTexture();
        this.components = new PatchedDataComponentMap(PatchedDataComponentMap.EMPTY);
    }

    //发包用
    public Gene(String id ,SpeciesType species,DataComponentPatch patch){
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




    //基础信息==========================================================
    private String geneId; //基因id，用于标识，以及快捷查找
    private ResourceLocation texture; //由Id决定的图片路径
    private SpeciesType species;
    private String speciesId;

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




    //行为=============================================================

    //主动==
    //释放技能
     public final void onCast(GeneInstance geneInstance){
        //检测玩家身上的主动技能组件，触发对应技能(参数里面填需要触发的技能，伤害由组件决定)
     }
     //被动==
     //事件触发，具体逻辑在注册的组件里面，调用这个方法，用于快速获取被动基因
     public final void passive(GeneInstance geneInstance){

     }

     //常态==
    public final void onEquip(GeneInstance geneInstance){
        //检测玩家身上的常态组件，更改属性，
    }


}
