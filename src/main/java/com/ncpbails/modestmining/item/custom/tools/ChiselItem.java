package com.ncpbails.modestmining.item.custom.tools;

import com.ncpbails.modestmining.block.custom.ChiselableBlock;
import com.ncpbails.modestmining.block.entity.custom.ChiselableBlockEntity;
import com.ncpbails.modestmining.sounds.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.BrushItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class ChiselItem extends BrushItem {
    private static final double MAX_CHISEL_DISTANCE;

    public ChiselItem(float v, float v1, Tier tier, Properties properties) {
        super(properties);
    }

    @Override
    public void onUseTick(Level level, LivingEntity livingEntity, ItemStack stack, int remainingUseDuration) {
        if (remainingUseDuration >= 0 && livingEntity instanceof Player player) {
            HitResult hitresult = this.calculateHitResult(livingEntity);
            if (hitresult instanceof BlockHitResult blockhitresult) {
                if (hitresult.getType() == HitResult.Type.BLOCK) {
                    int i = this.getUseDuration(stack) - remainingUseDuration + 1;
                    boolean flag = i % 10 == 5;
                    if (flag) {
                        BlockPos blockpos = blockhitresult.getBlockPos();
                        BlockState blockstate = level.getBlockState(blockpos);
                        HumanoidArm humanoidarm = livingEntity.getUsedItemHand() == InteractionHand.MAIN_HAND ? player.getMainArm() : player.getMainArm().getOpposite();
                        this.spawnDustParticles(level, blockhitresult, blockstate, livingEntity.getViewVector(0.0F), humanoidarm);
                        Block $$18 = blockstate.getBlock();
                        SoundEvent soundevent;
                        if ($$18 instanceof ChiselableBlock chiselableBlock) {
                            soundevent = chiselableBlock.getChiselSound();
                        } else {
                            soundevent = ModSounds.CHISEL_GENERIC.get();
                        }

                        level.playSound(player, blockpos, soundevent, SoundSource.BLOCKS);
                        if (!level.isClientSide()) {
                            BlockEntity blockentity = level.getBlockEntity(blockpos);
                            if (blockentity instanceof ChiselableBlockEntity chiselableBlockEntity) {
                                boolean flag1 = chiselableBlockEntity.brush(level.getGameTime(), player, blockhitresult.getDirection());
                                if (flag1) {
                                    EquipmentSlot equipmentslot = stack.equals(player.getItemBySlot(EquipmentSlot.OFFHAND)) ? EquipmentSlot.OFFHAND : EquipmentSlot.MAINHAND;
                                    stack.hurtAndBreak(1, livingEntity, (livingEntity1) -> livingEntity1.broadcastBreakEvent(equipmentslot));
                                }
                            }
                        }
                    }

                    return;
                }
            }

            livingEntity.releaseUsingItem();
        } else {
            livingEntity.releaseUsingItem();
        }

    }

    private HitResult calculateHitResult(LivingEntity entity) {
        return ProjectileUtil.getHitResultOnViewVector(entity, (p_281111_) -> !p_281111_.isSpectator() && p_281111_.isPickable(), MAX_CHISEL_DISTANCE);
    }

    static {
        MAX_CHISEL_DISTANCE = Math.sqrt(ServerGamePacketListenerImpl.MAX_INTERACTION_DISTANCE) - (double)1.0F;
    }
}
