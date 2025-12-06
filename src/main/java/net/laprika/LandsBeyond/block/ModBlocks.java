package net.laprika.LandsBeyond.block;

import net.laprika.LandsBeyond.Items.ModItems;
import net.laprika.LandsBeyond.LandsBeyond;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {


    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(LandsBeyond.MOD_ID);

    public static final DeferredBlock<Block> ZITRONIUM_BLOCK = registerBlock("zitronium_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.of()
                    .requiresCorrectToolForDrops()
                    .instrument(NoteBlockInstrument.HAT)
                    .strength(4f)
                    .sound(SoundType.METAL)
                    .noOcclusion()
                    .isValidSpawn(Blocks::never)));

    public static final DeferredBlock<Block> ZITRONIUM_ORE = registerBlock("zitronium_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 10),
                    BlockBehaviour.Properties.of()
                            .requiresCorrectToolForDrops()
                            .strength(4f)
                            .sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> DAWNGOLD_BLOCK = registerBlock("dawngold_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .requiresCorrectToolForDrops()
                    .strength(5f)
                    .sound(SoundType.METAL)));

    public static final DeferredBlock<Block> DAWNGOLD_ORE = registerBlock("dawngold_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> DAWNGOLD_DEEPSLATE_ORE = registerBlock("dawngold_deepslate_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()));


     private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
