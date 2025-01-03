package net.zihui.csprojmod.entity.goal;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.level.Level;
import org.apache.logging.log4j.core.jmx.Server;

public class SummonMinionsGoal extends Goal {

    private Mob mob;
    private ServerLevel world;

    public SummonMinionsGoal(Mob entity, ServerLevel level)
    {
        this.mob = entity;
        this.world = level;
    }

    @Override
    public boolean canUse() {
        return false;
    }

    @Override
    public void tick() {
        // Checks to see if mob is part of the level/world
        if (mob.level instanceof ServerLevel level){
            // Gives a spawn pos for the ability
            BlockPos pos = mob.blockPosition().offset(3, 1,3);

            summonMinions(pos, 5);
        }
    }

    private void summonMinions(BlockPos pos, int count)
    {
        for (int i = 0; i < count; i++)
        {
            Skeleton minion = EntityType.SKELETON.create(world);
            if (minion != null)
            {
                minion.moveTo(minion.getX(), minion.getY() + 2, minion.getZ());
            }
        }
    }
}
