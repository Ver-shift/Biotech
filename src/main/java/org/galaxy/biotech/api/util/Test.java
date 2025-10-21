package org.galaxy.biotech.api.util;

import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import org.galaxy.biotech.Biotech;
import org.galaxy.biotech.api.init.DataAttachmentRegistry;

@EventBusSubscriber(modid = Biotech.MODID)
public class Test {

    @SubscribeEvent
    public static void printGenData(PlayerInteractEvent.RightClickItem event){
        if (true){
            var player = event.getEntity();
            if (player instanceof ServerPlayer serverPlayer){
                var aaa = serverPlayer.getData(DataAttachmentRegistry.POWER_DATA);
                Float aa = aaa.getPower();
                String  a = aa.toString();
                DeBug.LOGGER.info(a);
                aaa.addPower(1);
            }

        }


    }
}
