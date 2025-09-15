package org.galaxy.biotech;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.galaxy.biotech.api.init.AttributeInit;
import org.galaxy.biotech.api.init.DataAttachmentInit;
import org.galaxy.biotech.api.init.ItemInit;
import org.slf4j.Logger;


@Mod(Biotech.MODID)
public class Biotech {

    public static final String MODID = "biotech";



    public Biotech(IEventBus eventBus){
        DataAttachmentInit.register(eventBus);
        ItemInit.register(eventBus);
        AttributeInit.register(eventBus);
    }
}
