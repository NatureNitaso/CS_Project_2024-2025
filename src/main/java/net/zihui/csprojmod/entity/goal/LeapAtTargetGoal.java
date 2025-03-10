package net.zihui.csprojmod.entity.goal;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.zihui.csprojmod.entity.goal.enums.LeapTypes;

import java.util.EnumSet;

public class LeapAtTargetGoal extends Goal {

    private final Mob mob;
    private final float jumpPower;
    private int cdTicks = 0;
    private LivingEntity target;

    public LeapAtTargetGoal(Mob mob, float leapPower) {
        this.mob = mob;
        this.jumpPower = leapPower;
    }


    @Override
    public boolean canUse() {
        this.target = this.mob.getTarget();
        if (cdTicks > 0) {
            cdTicks--;
            return false;
        }
        return target != null;
    }

    @Override
    public void start() {
        if (canUse()) {
            double dx = target.getX() - mob.getX();
            double dz = target.getZ() - mob.getZ();
            double distance = Math.sqrt(dx*dx+dz*dz);

            if (distance > 0) {
                mob.setDeltaMovement(
                        (dx/distance) * jumpPower,
                        1.5f,
                        (dz/distance) * jumpPower
                );
                cdTicks = 600; // Makes cd 30 sec
            }

        }
    }
}
