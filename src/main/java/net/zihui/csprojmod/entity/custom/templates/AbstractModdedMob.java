package net.zihui.csprojmod.entity.custom.templates;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

import net.zihui.csprojmod.entity.goal.enums.LeapTypes;

public abstract class AbstractModdedMob extends Mob {

    protected AbstractModdedMob(EntityType<? extends Monster> type, Level level, LeapTypes leapTypes) {
        super(type, level);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
    }

    @Override
    public void tick() {
        super.tick();
    }


}
