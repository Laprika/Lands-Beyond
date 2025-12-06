package net.laprika.LandsBeyond.Items.CUSTOM;

import net.laprika.LandsBeyond.block.ModBlocks;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

import java.util.Map;

public class GodChiselItem extends Item {
    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.STONE, Blocks.DIAMOND_ORE,
                    Blocks.COPPER_BLOCK, Blocks.IRON_BLOCK,
                    Blocks.IRON_BLOCK, Blocks.GOLD_BLOCK,
                    Blocks.GOLD_BLOCK, Blocks.DIAMOND_BLOCK,
                    Blocks.DIAMOND_BLOCK, Blocks.NETHERITE_BLOCK,
                    Blocks.AMETHYST_BLOCK, Blocks.BUDDING_AMETHYST,
                    Blocks.OAK_LOG, Blocks.COAL_BLOCK
            );
    public GodChiselItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(CHISEL_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide) {

                level.setBlockAndUpdate(context.getClickedPos(),CHISEL_MAP.get(clickedBlock).defaultBlockState());

                context.getItemInHand().hurtAndBreak(1,((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                if(Math.random() < 0.001F) {
                    Vec3 playerPos = context.getPlayer().position();
                    context.getLevel().explode(context.getPlayer(), playerPos.x, playerPos.y, playerPos.z, 20F, true, Level.ExplosionInteraction.MOB);
                }

                if(Math.random() < 0.001F) {
                    Player player = context.getPlayer();
                    for(int i = 0; i < 100; i++) {

                        Creeper creeper = new Creeper(EntityType.CREEPER, level);
                        creeper.setPos(player.position());
                        level.addFreshEntity(creeper);

                    }
                }


                }


                level.playSound(null, context.getClickedPos(), SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.BLOCKS);
            }
        }




        return InteractionResult.SUCCESS;
    }
}
