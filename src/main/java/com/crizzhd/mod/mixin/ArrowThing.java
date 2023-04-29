package com.crizzhd.mod.mixin;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ArrowEntity.class)
public class ArrowThing {

    @Inject(method = "onHit", at = @At("HEAD"))
    public void onHit(LivingEntity target, CallbackInfo ci){
        target.world.createExplosion(target, target.getX(), target.getY(), target.getZ(), 3.5F, World.ExplosionSourceType.TNT);
    }
}
