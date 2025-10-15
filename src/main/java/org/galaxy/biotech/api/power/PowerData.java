package org.galaxy.biotech.api.power;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.common.NeoForge;
import org.galaxy.biotech.api.event.ChangePowerEvent;
import org.galaxy.biotech.api.init.AttributeRegistry;

public class PowerData {
    //基因能量值
    private boolean isMob = false;

    public PowerData(boolean isMob) {
        this.isMob = isMob;
    }
    public PowerData() {
        this(false);
    }
    public PowerData(float power) {
        this.power = power;
    }
    public PowerData(ServerPlayer player) {
        this(false);
        this.serverPlayer = player;
    }


    //genePower
    private float power;
    private ServerPlayer serverPlayer = null;
    public static final String POWER = "power";


    public float getPower() {return power;}

    public void setPower(float power) {
        //Event will not get posted if the server player is null
        ChangePowerEvent e = new ChangePowerEvent(this.serverPlayer, this, this.power, power);
        if (this.serverPlayer == null || !NeoForge.EVENT_BUS.post(e).isCanceled()) {
            float newPower = e.getNewPower();

            // 检查上限：如果有 serverPlayer 使用属性值，否则使用默认上限 10.0
            float maxPower = 10.0f; // 默认上限
            if (this.serverPlayer != null) {
                maxPower = (float) serverPlayer.getAttributeValue(AttributeRegistry.MAX_POWER);
            }

            // 无论何时都要检查上限
            if (newPower > maxPower) {
                newPower = maxPower;
            }

            // 同时确保不会设置负值
            if (newPower < 0) {
                newPower = 0;
            }

            this.power = newPower;
        }
    }

    public void addPower(float power) {
        setPower(this.power + power);
    }

    public static final Codec<PowerData> RECORD_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.FLOAT.optionalFieldOf("power", 0.0f).forGetter(PowerData::getPower)
            ).apply(instance, PowerData::new)
    );
}
