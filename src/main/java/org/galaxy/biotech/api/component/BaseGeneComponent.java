package org.galaxy.biotech.api.component;

import net.neoforged.neoforge.event.entity.living.*;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;

public abstract class BaseGeneComponent {


    //行动======================================================
    //主动技能
    public void onCast() {}

    //被动事件
    public void onPlayerTick(LevelTickEvent.Pre event) {}

    public void onEntityTick(LevelTickEvent.Pre event) {}

    public void onDeath(LivingDeathEvent event) {}

    public void onHurt(LivingDamageEvent.Pre event) {}

    public void onAttack(AttackEntityEvent event) {}

    public void onJump(LivingEvent.LivingJumpEvent event) {}

    public void onHeal(LivingHealEvent event) {}

}
