package org.galaxy.biotech;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.galaxy.biotech.api.init.AttributeInit;
import org.galaxy.biotech.api.init.DataAttachmentInit;
import org.galaxy.biotech.api.init.ItemInit;
import org.slf4j.Logger;


@Mod(Biotech.MODID)
public class Biotech {

    public static final String MODID = "biotech";

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    public static ResourceLocation cid(String path) {
        return ResourceLocation.fromNamespaceAndPath("c", path);
    }


    public Biotech(IEventBus eventBus){
        DataAttachmentInit.register(eventBus);
        ItemInit.register(eventBus);
        AttributeInit.register(eventBus);
    }
}
