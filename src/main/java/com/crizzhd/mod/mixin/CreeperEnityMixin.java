package com.crizzhd.mod.mixin;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import static com.crizzhd.mod.block.ModBlocks.Crizz_Block;

@Mixin(CreeperEntity.class)
public abstract class CreeperEnityMixin extends HostileEntity  {

    protected CreeperEnityMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public void setMovementSpeed(float movementSpeed) {
        movementSpeed = 1.0f;
        super.setMovementSpeed(movementSpeed);
    }

    @Override
    public void onDeath(DamageSource damageSource) {
        dropItem(Crizz_Block,0);
    }
}
