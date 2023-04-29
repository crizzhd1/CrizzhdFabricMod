package com.crizzhd.mod.world.dimension;
import com.crizzhd.mod.CrizzhdMod;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensions {
    //CrizzDimension
    private RegistryKey<World> CRIZZDIM_DIMENSION_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(CrizzhdMod.ModId, "crizzdim"));

    private RegistryKey<DimensionType> CRIZZDIM_TYPE_KEY = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            CRIZZDIM_DIMENSION_KEY.getValue());
    //
    public static void register(){
        CrizzhdMod.LOGGER.info("Registering ModBlocks for " + CrizzhdMod.ModId);
    }
}
