package org.galaxy.biotech;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.galaxy.biotech.api.init.*;


@Mod(Biotech.MODID)
public class Biotech {

    public static final String MODID = "biotech";



    public Biotech(IEventBus eventBus){
        DataAttachmentRegistry.register(eventBus);
        AttributeRegistry.register(eventBus);
        CreativeTabRegistry.register(eventBus);
        ItemRegistry.register(eventBus);
        SpeciesReg.register(eventBus);
        GeneComps.register(eventBus);




    }
}
