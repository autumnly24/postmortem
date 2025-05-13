
package net.mcreator.postmortem.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class CleansedDiamondItem extends Item {
	public CleansedDiamondItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
	}
}
