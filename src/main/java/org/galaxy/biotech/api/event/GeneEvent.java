package org.galaxy.biotech.api.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.*;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import org.galaxy.biotech.api.gene.IGeneEventHandle;
import org.galaxy.biotech.api.init.DataAttachmentRegistry;

@EventBusSubscriber
public class GeneEvent {

    @SubscribeEvent
    public static void death(LivingDeathEvent event){
        var geneData = event.getEntity().getData(DataAttachmentRegistry.GENE_DATA);
        if (geneData.getGene() == null) return;

        var components = geneData.getGene().getComponents();
        components.stream()
                .map(typedComponent -> typedComponent.value())
                .filter(IGeneEventHandle.class::isInstance)
                .map(IGeneEventHandle.class::cast)
                .forEach(handler -> handler.death(event));
    }

    @SubscribeEvent
    public static void jump(LivingEvent.LivingJumpEvent event){
        var geneData = event.getEntity().getData(DataAttachmentRegistry.GENE_DATA);
        if (geneData.getGene() == null) return;

        var components = geneData.getGene().getComponents();
        components.stream()
                .map(typedComponent -> typedComponent.value())
                .filter(IGeneEventHandle.class::isInstance)
                .map(IGeneEventHandle.class::cast)
                .forEach(handler -> handler.jump(event));
    }

    @SubscribeEvent
    public static void hurt(LivingDamageEvent.Pre event){
        var geneData = event.getEntity().getData(DataAttachmentRegistry.GENE_DATA);
        if (geneData.getGene() == null) return;

        var components = geneData.getGene().getComponents();
        components.stream()
                .map(typedComponent -> typedComponent.value())
                .filter(IGeneEventHandle.class::isInstance)
                .map(IGeneEventHandle.class::cast)
                .forEach(handler -> handler.hurt(event));
    }

    @SubscribeEvent
    public static void attack(AttackEntityEvent event){
        var geneData = event.getEntity().getData(DataAttachmentRegistry.GENE_DATA);
        if (geneData.getGene() == null) return;

        var components = geneData.getGene().getComponents();
        components.stream()
                .map(typedComponent -> typedComponent.value())
                .filter(IGeneEventHandle.class::isInstance)
                .map(IGeneEventHandle.class::cast)
                .forEach(handler -> handler.attack(event));
    }
}
