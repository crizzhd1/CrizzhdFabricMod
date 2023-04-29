package com.crizzhd.mod.item;
import com.crizzhd.mod.CrizzhdMod;
import net.fabricmc.fabric.api.item.v1.EquipmentSlotProvider;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItem {
    //Items
    public Item Bonk = registerItem("model", new SwordItem(ToolMaterials.IRON,5,2f,new FabricItemSettings()));

    public Item Baa = registerItem("fdgdg", new Item(new FabricItemSettings()));
    //
    private void addItemsToItemGroup(){
        addToItemGroup(CrizzhdMod.modItemGroup.CrizzItems, Bonk);
        addToItemGroup(CrizzhdMod.modItemGroup.CrizzItems, Baa);
     }

    private Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(CrizzhdMod.ModId, name), item);
    }

    private void addToItemGroup(ItemGroup group, Item item){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public void registerModItems(){
        addItemsToItemGroup();
    }
}
