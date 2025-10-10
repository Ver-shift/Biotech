package org.galaxy.biotech.api.event;

import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import org.galaxy.biotech.api.power.PowerData;

public class ChangePowerEvent extends PlayerEvent implements ICancellableEvent {
    private final PowerData data;
    private final float oldPower;
    private float newPower;

    public ChangePowerEvent(Player player,PowerData data,float oldPower,float newPower) {
        super(player);
        this.data = data;
        this.oldPower = oldPower;
        this.newPower = newPower;
    }

    public PowerData getData() {
        return data;
    }
    public float getOldPower() {
        return oldPower;
    }
    public float getNewPower() {
        return newPower;
    }
    public void setNewPower(float newPower) {
        this.newPower = newPower;
    }
}
