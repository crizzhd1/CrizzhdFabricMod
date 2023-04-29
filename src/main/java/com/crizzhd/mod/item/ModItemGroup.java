package com.crizzhd.mod.item;
import com.crizzhd.mod.CrizzhdMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public ItemGroup CrizzItems;

    public void RegisterItemGroups(){
        CrizzItems = FabricItemGroup.builder(new Identifier(CrizzhdMod.ModId,"crizzhd_items"))
                .displayName(Text.literal("Crizzhd's Items"))
                .icon(()-> new ItemStack(CrizzhdMod.modItem.Bonk)).build();
    }
}
