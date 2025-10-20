package org.galaxy.biotech.api.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import org.galaxy.biotech.api.gene.IGeneAction;
import org.galaxy.biotech.api.gene.IGeneEventHandle;
import org.galaxy.biotech.api.init.DataAttachmentRegistry;

@EventBusSubscriber
public class GeneEvent {

    @SubscribeEvent
    public static void death(LivingDeathEvent event){
        var geneData = event.getEntity().getData(DataAttachmentRegistry.POWER_DATA);

        if (geneData instanceof IGeneEventHandle<LivingDeathEvent> component){
            component.death(event);
        }
    }
}
