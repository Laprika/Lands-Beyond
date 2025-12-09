package net.laprika.LandsBeyond.block;

import net.laprika.LandsBeyond.Items.ModItems;
import net.laprika.LandsBeyond.LandsBeyond;
import net.laprika.LandsBeyond.block.CUSTOM.DivineBlock;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {

    //public static void test {
  // Blocks.OAK_LOG
   // }

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(LandsBeyond.MOD_ID);


    //Golden Lands
    public static final DeferredBlock<Block> GOLDEN_LOG = registerBlock("golden_log",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> DAWNGOLD_BLOCK = registerBlock("dawngold_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .requiresCorrectToolForDrops()
                    .strength(5f)
                    .sound(SoundType.METAL)));

    public static final DeferredBlock<StairBlock> DAWNGOLD_STAIRS = registerBlock("dawngold_stairs",
            () -> new StairBlock(ModBlocks.DAWNGOLD_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.of()
                    .strength(5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));
    public static final DeferredBlock<SlabBlock> DAWNGOLD_SLAB = registerBlock("dawngold_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));

    public static final DeferredBlock<PressurePlateBlock> DAWNGOLD_Pressure_Plate = registerBlock("dawngold_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON, BlockBehaviour.Properties.of()
                    .strength(5f)
                    .requiresCorrectToolForDrops()));
    public static final DeferredBlock<ButtonBlock> DAWNGOLD_BUTTON = registerBlock("dawngold_button",
            () -> new ButtonBlock(BlockSetType.IRON, 20, BlockBehaviour.Properties.of()
                    .strength(5f)
                    .requiresCorrectToolForDrops()
                    .noCollission()));

    public static final DeferredBlock<FenceBlock> DAWNGOLD_FENCE = registerBlock("dawngold_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of()
                    .strength(5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));
    public static final DeferredBlock<FenceGateBlock> DAWNGOLD_FENCE_GATE = registerBlock("dawngold_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.of()
                    .strength(5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));
    public static final DeferredBlock<WallBlock> DAWNGOLD_WALL = registerBlock("dawngold_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of()
                    .strength(5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));

    public static final DeferredBlock<DoorBlock> DAWNGOLD_DOOR = registerBlock("dawngold_door",
            () -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of()
                    .strength(5f)
                    .requiresCorrectToolForDrops()));
    public static final DeferredBlock<TrapDoorBlock> DAWNGOLD_TRAPDOOR = registerBlock("dawngold_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON,BlockBehaviour.Properties.of()
                    .strength(5f)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()));

    public static final DeferredBlock<Block> DAWNGOLD_ORE = registerBlock("dawngold_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> DAWNGOLD_DEEPSLATE_ORE = registerBlock("dawngold_deepslate_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SOLARITE_ORE = registerBlock("solarite_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SOLARITE_BLOCK = registerBlock("solarite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()));

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

    // CUSTOM
    public static final DeferredBlock<Block> DIVINE_BLOCK = registerBlock("divine_block",
            () -> new DivineBlock(BlockBehaviour.Properties.of()
                    .strength(5f)
                    .sound(SoundType.AMETHYST_CLUSTER)
                    .noLootTable()));


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
