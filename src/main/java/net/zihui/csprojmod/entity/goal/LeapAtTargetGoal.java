package net.zihui.csprojmod.entity.goal;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.zihui.csprojmod.entity.goal.enums.LeapTypes;

import java.util.EnumSet;

public class LeapAtTargetGoal extends Goal {
    private final Mob mob;
    private LivingEntity target;
    private final LeapTypes leapTypes;
    private final int cooldownMax;
    private int cdTicks = 0;

    public LeapAtTargetGoal(Mob mob, LeapTypes leapTypes, int cd) {
        this.mob = mob;
        this.leapTypes = leapTypes;
        this.cooldownMax = cd;
    }

    @Override
    public boolean canUse() {
        this.target = this.mob.getTarget();
        return this.target != null && this.mob.isOnGround() && (cdTicks == 0);
    }


    @Override
    public void start() {
        double dx = target.getX() - mob.getX(); // Grabs the distance between the target and the mob itself
        double dz = target.getZ() - mob.getZ();
        double distance = Math.sqrt(dx * dx + dz * dz);

        if (distance > 0 && canUse()) {
            mob.setDeltaMovement(
                    (dx / distance) * leapTypes.getHorizontalStrength(),
                    leapTypes.getVerticalStrength(),
                    (dz / distance) * leapTypes.getHorizontalStrength()
            );
            cdTicks = cooldownMax;
        }
    }

    public Mob getMob() {
        return mob;
    }

    public LeapTypes getLeapTypes() {
        return leapTypes;
    }

    public LivingEntity getTarget() {
        return target;
    }

    @Override
    public void tick() {
        super.tick();

        if ((cdTicks > 0))
        {
            cdTicks--;
        }
    }

    @Override
    public boolean requiresUpdateEveryTick() {
        return true;
    }

}
