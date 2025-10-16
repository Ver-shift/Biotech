package org.galaxy.biotech.api.gene.data;

import com.google.common.collect.Maps;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.capabilities.magic.CooldownInstance;
import org.galaxy.biotech.api.gene.AbstractGene;

import java.util.Map;

public class CoolDownData {
    //只能player使用
    class CooldownInstance{
        private int cooldownRemaining;
        private final int geneCooldown;

        public CooldownInstance(int skillCooldown) {
            this.geneCooldown = skillCooldown;
            this.cooldownRemaining = skillCooldown;
        }

        public CooldownInstance(int skillCooldown, int cooldownRemaining) {
            this.geneCooldown = skillCooldown;
            this.cooldownRemaining = cooldownRemaining;
        }

        public void decrement() {
            cooldownRemaining--;
        }

        public void decrementBy(int amount) {
            cooldownRemaining -= amount;
        }

        public int getCooldownRemaining() {
            return cooldownRemaining;
        }

        public int getSkillCooldown() {
            return geneCooldown;
        }

        public float getCooldownPercent() {
            if (cooldownRemaining == 0) {
                return 0;
            }
            return cooldownRemaining / (float) geneCooldown;
        }
    }
    private final Map<String, CooldownInstance> cooldowns;
    private int tickBuffer;

    public CoolDownData() {
        this.cooldowns = Maps.newHashMap();
    }
    public boolean isOnCooldown(AbstractGene gene) {
        return cooldowns.containsKey(gene.getTextureId());
    }

    public void tick(int actualTicks) {
        var spells = cooldowns.entrySet().stream().filter(x -> decrementCooldown(x.getValue(), actualTicks)).toList();
        spells.forEach(spell -> cooldowns.remove(spell.getKey()));
    }

    public boolean hasCooldownsActive() {
        return !cooldowns.isEmpty();
    }

    //get add remove clear
    public Map<String, CooldownInstance> getCooldowns() {
        return cooldowns;
    }
    public void addCooldown(AbstractGene gene,int durationTick){
        cooldowns.put(gene.getTextureId().toString(),new CooldownInstance(durationTick));
    }
    public void addCooldown(AbstractGene gene,int durationTick,int remaining){
        cooldowns.put(gene.getTextureId().toString(),new CooldownInstance(durationTick,remaining));
    }
    public void removeCooldown(AbstractGene gene,int durationTick){

    }
    public void clearCooldowns(){
        cooldowns.clear();
    }

    //用于每tick减少全部技能冷却
    public boolean decrementCooldown(CooldownInstance c, int amount) {
        c.decrementBy(amount);
        return c.getCooldownRemaining() <= tickBuffer;
    }


}
