package com.crizzhd.mod.mixin;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ChickenEntity.class)
public abstract class ChickenGoseBoomMixin extends LivingEntity {

    protected ChickenGoseBoomMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    public void onDeath(DamageSource damageSource) {
        world.createExplosion(this, this.getX(), this.getY(), this.getZ(), 3.5F, World.ExplosionSourceType.TNT);
    }
}
