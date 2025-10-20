package org.galaxy.biotech.api.gene;

import net.neoforged.neoforge.event.entity.living.*;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;

public interface IGeneEventHandle {

    // 死亡事件
    default void death(LivingDeathEvent event) {
    }

    // 跳跃事件
    default void jump(LivingEvent.LivingJumpEvent event) {
    }

    // 受伤事件 - 使用 LivingDamageEvent.Pre（伤害应用前，可修改）
    default void hurt(LivingDamageEvent.Pre event) {
    }

    // 攻击事件
    default void attack(AttackEntityEvent event) {
    }
}
