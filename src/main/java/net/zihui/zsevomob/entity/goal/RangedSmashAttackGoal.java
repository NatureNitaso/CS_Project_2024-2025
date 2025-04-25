package net.zihui.zsevomob.entity.goal;

import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.block.Blocks;

public class RangedSmashAttackGoal extends Goal {
    private Mob mob;
    private int cdTime = 0;
    private int maxCd;
    private int chargeTime; //
    private final int maxCharge = 60;// 3 sec chargeup
    private LivingEntity target;

    public RangedSmashAttackGoal(Mob mob, int cooldown) {
        this.maxCd = cooldown;
        this.mob = mob;
    }

    @Override
    public boolean canUse() {
        if (mob.getTarget() != null) {
            this.target = mob.getTarget();
        }
        return mob.getTarget() != null && cdTime == 0;
    }

    @Override
    public void start() {
        chargeTime = 0;
    }

    @Override
    public void tick() {
        chargeTime++;

        if (chargeTime == maxCharge) {
            smashAttack();
        }
    }

    private void smashAttack() {
        // Gets mob location
        double x = mob.getX();
        double y = mob.getY();
        double z = mob.getZ();

        mob.level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK,
                Blocks.IRON_BLOCK.defaultBlockState()), x, y, z, 0,
                0.5, 0);
    }
}
