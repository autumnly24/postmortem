
package net.mcreator.postmortem.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class CrackedTotemOfRebirthItem extends Item {
	public CrackedTotemOfRebirthItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
	}
}
