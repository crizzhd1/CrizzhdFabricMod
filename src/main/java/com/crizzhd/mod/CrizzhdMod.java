package com.crizzhd.mod;
import com.crizzhd.mod.block.ModBlocks;
import com.crizzhd.mod.item.ModItem;
import com.crizzhd.mod.item.ModItemGroup;
import com.crizzhd.mod.world.dimension.ModDimensions;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class CrizzhdMod implements ModInitializer {
	public  static final String  ModId = "crizzhdmod";
	public static final Logger LOGGER = LoggerFactory.getLogger("crizzhdmod");
	public static ModItem modItem = new ModItem();
	public static ModItemGroup modItemGroup = new ModItemGroup();

	@Override
	public void onInitialize() {
		modItemGroup.RegisterItemGroups();
		modItem.registerModItems();
		ModDimensions.register();
		ModBlocks.registerModBlocks();
		//ModEntityGeneration.addSpawns();

	}
}