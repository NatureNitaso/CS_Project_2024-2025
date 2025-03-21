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
    private final float leapPower;

    public LeapAtTargetGoal(Mob mob, float yPower, float xPower) {
        this.mob = mob;
        this.jumpPower = yPower;
        this.leapPower = xPower;
    }


    @Override
    public boolean canUse() {
        this.target = this.mob.getTarget();
        boolean useable = cdTicks>0&&mob.isOnGround()&&target!=null;
        if (cdTicks > 0) {
            cdTicks--;
            return false;
        }
        return useable;
    }

    @Override
    public void start() {
        if (canUse()){
            double dx = mob.getX() - target.getX();
            double dz = mob.getZ() + target.getZ();
            mob.setDeltaMovement((dx*dx), jumpPower, (dz*dz));
            cdTicks = 200;
        }
    }
}
