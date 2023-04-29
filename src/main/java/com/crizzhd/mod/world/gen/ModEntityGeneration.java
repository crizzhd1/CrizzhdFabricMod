package com.crizzhd.mod.world.gen;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntityGeneration {

    public static void addSpawns(){
        //BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.BADLANDS),
               //SpawnGroup.CREATURE, GoBoom.EXPLOSIVE_CHICKEN_ENTITY,35,1,2);

        //SpawnRestriction.register(GoBoom.EXPLOSIVE_CHICKEN_ENTITY, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
    }
}
