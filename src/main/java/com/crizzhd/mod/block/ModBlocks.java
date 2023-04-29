package com.crizzhd.mod.block;
import com.crizzhd.mod.CrizzhdMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks{
    //Blocks
       public static final Block Crizz_Block = registerBlock("crizzblock",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()),CrizzhdMod.modItemGroup.CrizzItems);
    //
    private static Block registerBlock(String name, Block block, ItemGroup group){
        registerBlockItem(name,block,group);
        return Registry.register(Registries.BLOCK, new Identifier(CrizzhdMod.ModId, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(CrizzhdMod.ModId, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }

    public static void registerModBlocks(){
        CrizzhdMod.LOGGER.info("Registering ModBlocks for " + CrizzhdMod.ModId);
    }
}
