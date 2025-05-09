package net.zihui.zsevomob.items.abstracts;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.zihui.zsevomob.entity.goal.interfaces.SpecialAbility;

public abstract class ModWeaponItems extends SwordItem implements SpecialAbility {

    public ModWeaponItems(Tier tier, int dmg, float speed, Properties props) {
        super(tier, dmg, speed, props);
    }
}
