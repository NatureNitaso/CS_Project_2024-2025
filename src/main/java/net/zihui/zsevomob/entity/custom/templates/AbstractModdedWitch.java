package net.zihui.zsevomob.entity.custom.templates;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.level.Level;

public abstract class AbstractModdedWitch extends Witch {
    public AbstractModdedWitch(EntityType<? extends Witch> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public void performRangedAttack(LivingEntity entity, float v) {
        super.performRangedAttack(entity, v);
    }


}
