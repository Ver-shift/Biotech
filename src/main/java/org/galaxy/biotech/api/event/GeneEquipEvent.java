package org.galaxy.biotech.api.event;

import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import org.galaxy.biotech.api.gene.AbstractGene;

//基因装载在基因库里面触发
public class GeneEquipEvent extends PlayerEvent implements ICancellableEvent {
    private AbstractGene targeGene;
    private int oldLevel;
    private int newLevel;

    public GeneEquipEvent(Player player,AbstractGene gene, int oldLevel, int newLevel) {
        super(player);
        this.targeGene = gene;
        this.oldLevel = oldLevel;
        this.newLevel = newLevel;
    }


}
