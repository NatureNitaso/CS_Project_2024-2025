package net.zihui.csprojmod.entity.custom.templates;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

import net.zihui.csprojmod.entity.goal.enums.LeapTypes;

public abstract class AbstractModdedGolem extends AbstractGolem {

    protected AbstractModdedGolem(EntityType<? extends AbstractModdedGolem> type, Level level) {
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

    public abstract void specialAbility();

    public abstract void performSpecialAttack();

}
