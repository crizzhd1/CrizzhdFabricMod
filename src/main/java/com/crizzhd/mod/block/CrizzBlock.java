package com.crizzhd.mod.block;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CrizzBlock extends Block {

    private boolean wasClicked = false;

    public CrizzBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            if(wasClicked == false){
                player.getServer().getCommandManager().executeWithPrefix(player.getCommandSource(),"execute in crizzhdmod:crizzdim run tp ~ ~ ~");
                wasClicked =true;
            }
            else {
                player.getServer().getCommandManager().executeWithPrefix(player.getCommandSource(),"execute in minecraft:overworld run tp ~ ~ ~");
                wasClicked = false;
            }
        }
        return ActionResult.SUCCESS;
    }
}