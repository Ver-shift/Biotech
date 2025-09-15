package org.galaxy.biotech.api.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.galaxy.biotech.Biotech;

@EventBusSubscriber(modid = Biotech.MODID)
public class AttributeInit {
    //初始化
    private static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(Registries.ATTRIBUTE, Biotech.MODID);

    public static void register(IEventBus eventBus) {
        ATTRIBUTES.register(eventBus);
    }

    @SubscribeEvent
    public static void modifyEntityAttributes(EntityAttributeModificationEvent e) {
        e.getTypes().forEach(entity -> ATTRIBUTES.getEntries().forEach(attribute -> e.add(entity, attribute)));
    }


    //正式版本







    public static final DeferredHolder<Attribute, Attribute> MAX_COMPLEXITY;
//    public static final DeferredHolder<Attribute, Attribute> MAX_METABOLIC_RATE;

    static {
        MAX_COMPLEXITY = ATTRIBUTES.register("max_complexity",() -> new RangedAttribute(
                "attribute.biotech.max_complexity",0,0,10000).setSyncable(true));

//        MAX_METABOLIC_RATE = ATTRIBUTES.register("max_metabolic_rate",()->new RangedAttribute(
//                "attribute.biotech.max_metabolic_rate",0,-10000,10000).setSyncable(true));
}


}
