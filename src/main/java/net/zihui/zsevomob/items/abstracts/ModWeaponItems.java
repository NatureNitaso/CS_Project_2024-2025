package net.zihui.zsevomob.items.abstracts;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.zihui.zsevomob.entity.goal.interfaces.SpecialMoveset;

public abstract class ModWeaponItems extends SwordItem implements SpecialMoveset {

    public ModWeaponItems(Tier tier, int dmg, float speed, Properties props) {
        super(tier, dmg, speed, props);
    }
}
