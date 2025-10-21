package org.galaxy.biotech.api.event;

import net.minecraft.core.component.PatchedDataComponentMap;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.*;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;
import org.galaxy.biotech.api.component.BaseGeneComponent;
import org.galaxy.biotech.api.init.DataAttachmentRegistry;

import java.util.function.Consumer;

@EventBusSubscriber
public class GeneEvent {


    @SubscribeEvent
    public static void onPlayerTick(LevelTickEvent.Pre event) {
        if (event.getLevel().isClientSide) {
            return;
        }
        event.getLevel().players().stream().toList().forEach(entity -> {
            if (entity instanceof ServerPlayer player) {
                eventHandle(player, comp -> comp.onPlayerTick(event));
            }
        });
    }

    @SubscribeEvent
    public static void onEntityTick(LevelTickEvent.Pre event) {
        if (event.getLevel().isClientSide || !(event.getLevel() instanceof ServerLevel serverLevel)) {
            return;
        }
        serverLevel.getAllEntities().forEach(entity -> {
            if (entity instanceof LivingEntity living) {
                eventHandle(living, comp -> comp.onEntityTick(event));
            }
        });
    }

    @SubscribeEvent
    public static void onDeath(LivingDeathEvent event) {
        eventHandle(event.getEntity(), comp -> comp.onDeath(event));
    }

    @SubscribeEvent
    public static void onHurt(LivingDamageEvent.Pre event) {
        eventHandle(event.getEntity(), comp -> comp.onHurt(event));
    }

    @SubscribeEvent
    public static void onAttack(AttackEntityEvent event) {
        if (event.getEntity() instanceof LivingEntity living) {
            eventHandle(living, comp -> comp.onAttack(event));
        }
    }

    @SubscribeEvent
    public static void onJump(LivingEvent.LivingJumpEvent event) {
        eventHandle(event.getEntity(), comp -> comp.onJump(event));
    }

    @SubscribeEvent
    public static void onHeal(LivingHealEvent event) {
        eventHandle(event.getEntity(), comp -> comp.onHeal(event));
    }



    /**
     * 通用事件处理方法：遍历实体的所有基因组件并执行指定的处理器
     * @param entity 触发事件的实体
     * @param handler 要执行的处理器方法引用
     */
    private static void eventHandle(LivingEntity entity, Consumer<BaseGeneComponent> handler) {
        var geneData = entity.getData(DataAttachmentRegistry.GENE_DATA);
        if (geneData.getGene() == null) return;

        var components = geneData.getGene().getComponents();
        components.forEach(component -> {
            Object value = component.value();
            if (value instanceof BaseGeneComponent comp) {
                handler.accept(comp);
            }
        });
    }

    /**
     * 获取实体的基因组件映射
     * @param entity 实体
     * @return 基因组件映射，如果没有基因则返回 null
     */
    public static PatchedDataComponentMap getComponents(LivingEntity entity) {
        var geneData = entity.getData(DataAttachmentRegistry.GENE_DATA);
        if (geneData.getGene() == null) return null;
        return geneData.getGene().getComponents();
    }

}
