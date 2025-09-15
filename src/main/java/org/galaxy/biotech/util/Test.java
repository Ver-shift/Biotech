package org.galaxy.biotech.util;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import org.galaxy.biotech.Biotech;
import org.galaxy.biotech.api.init.DataAttachmentInit;
import org.galaxy.biotech.capabilities.EntityGeneDataProvider;

@EventBusSubscriber(modid = Biotech.MODID)
public class Test {

    @SubscribeEvent
    public static void printGenData(PlayerInteractEvent.RightClickItem event){
        if (true){
            if (event.getEntity() instanceof ServerPlayer serverPlayer){
                if (serverPlayer.getMainHandItem().getItem() == Items.STICK) {
                    var aaa =  serverPlayer.getData(DataAttachmentInit.ENTITY_GENE_DATA);


                    DeBug.LOGGER.info("Complexity: " + aaa.getComplexity());
                    DeBug.LOGGER.info("Genes: " + aaa.getMetabolicRate());
                }
            }
        }

    }
}
