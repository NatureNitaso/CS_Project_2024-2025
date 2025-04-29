package net.zihui.zsevomob.items.abstracts;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public abstract class ModItemEntity extends Entity {
    public ModItemEntity(EntityType<?> type, Level level) {
        super(type, level);
    }
}
