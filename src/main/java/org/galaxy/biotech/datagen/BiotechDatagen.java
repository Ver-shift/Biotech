package org.galaxy.biotech.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.galaxy.biotech.Biotech;
import org.galaxy.biotech.api.gene.GeneCheckers;
import org.galaxy.biotech.api.gene.GeneSequenceChecker;

import java.util.Optional;

/**
 * @author baka4n
 * @code @Date 2025/9/16 13:28:56
 */
@EventBusSubscriber(modid = Biotech.MODID)
public class BiotechDatagen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {

        event.createDatapackRegistryObjects(
                new RegistrySetBuilder()
                        .add(GeneSequenceChecker.GENE_CHECKER,
                                ctx -> {

                                    ctx.register(GeneCheckers.TEST.get(), new GeneSequenceChecker(
                                    "ATAG", Attributes.MAX_HEALTH, 1, AttributeModifier.Operation.ADD_VALUE

                            ));
                                })
        );
    }
}
