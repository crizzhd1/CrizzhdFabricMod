package com.crizzhd.mod.mixin;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import java.util.List;
import java.util.Random;
import static com.crizzhd.mod.block.ModBlocks.Crizz_Block;

@Mixin(CreeperEntity.class)
public abstract class CreeperEnityMixin extends LivingEntity {

    @Shadow private int explosionRadius;

    protected CreeperEnityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    public void setMovementSpeed(float movementSpeed) {
        movementSpeed = GetRandomFloat(0.1f, 5.0f);
        super.setMovementSpeed(movementSpeed);
    }

    public void onDeath(DamageSource damageSource) {
        dropItem(Crizz_Block, 0);
    }

    public float GetRandomFloat(float min, float max){
        Random ran = new Random();
        float random = ran.nextFloat(max);
        random = random + min;
        return random;
    }

    public StatusEffect RandonEffect() {

        StatusEffect effects = null;
        int i = random.nextInt(5);

        if (i <= 1) {
            effects = StatusEffects.GLOWING;
        } else if (i <= 2) {
            effects = StatusEffects.BAD_OMEN;
        } else if (i <= 3) {
            effects = StatusEffects.JUMP_BOOST;
        } else if (i <= 4) {
            effects = StatusEffects.LEVITATION;
        }
        return effects;
    }

    @Inject(method = "explode", at = @At("HEAD"))
    private void applyEffect(CallbackInfo ci) {
        LivingEntity mob = this;
        StatusEffectInstance effectInstance;

        List<LivingEntity> nearbyEntities = mob.world.getEntitiesByClass(LivingEntity.class,
                new Box(mob.getPos().add(-5, -5, -5), mob.getPos().add(5, 5, 5)), entity -> entity != mob);

        for (LivingEntity entity : nearbyEntities) {
            effectInstance = new StatusEffectInstance(RandonEffect(), (int) GetRandomFloat(100, 400));
            entity.addStatusEffect(effectInstance);
        }
    }
}