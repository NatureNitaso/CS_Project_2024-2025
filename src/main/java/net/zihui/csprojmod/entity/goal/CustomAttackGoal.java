package net.zihui.csprojmod.entity.goal;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.behavior.MeleeAttack;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import org.jetbrains.annotations.NotNull;

public class CustomAttackGoal extends MeleeAttackGoal {
    private final PathfinderMob mob;

    public CustomAttackGoal(PathfinderMob mob, double v, boolean b) {
        super(mob, v, b);
        this.mob = mob;
    }

    @Override
    protected void checkAndPerformAttack(@NotNull LivingEntity target, double attack) {
        super.checkAndPerformAttack(target, attack);

        if (getAttackReachSqr(mob) >= target.distanceToSqr(mob))
        {
            this.mob.swinging = true;
        }
    }

    @Override
    public void tick() {
        super.tick();
    }
}
