package net.laprika.LandsBeyond.datagen;

import net.laprika.LandsBeyond.LandsBeyond;
import net.laprika.LandsBeyond.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class LBModBlockStateProvider extends BlockStateProvider {
    public LBModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, LandsBeyond.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //Golden Lands
        blockWithItem(ModBlocks.DAWNGOLD_BLOCK);

        stairsBlock(ModBlocks.DAWNGOLD_STAIRS.get(), blockTexture(ModBlocks.DAWNGOLD_BLOCK.get()));
        slabBlock(ModBlocks.DAWNGOLD_SLAB.get(), blockTexture(ModBlocks.DAWNGOLD_BLOCK.get()), blockTexture(ModBlocks.DAWNGOLD_BLOCK.get()));

        buttonBlock(ModBlocks.DAWNGOLD_BUTTON.get(), blockTexture(ModBlocks.DAWNGOLD_BLOCK.get()));
        pressurePlateBlock(ModBlocks.DAWNGOLD_Pressure_Plate.get(), blockTexture(ModBlocks.DAWNGOLD_BLOCK.get()));

        fenceBlock(ModBlocks.DAWNGOLD_FENCE.get(), blockTexture(ModBlocks.DAWNGOLD_BLOCK.get()));
        fenceGateBlock(ModBlocks.DAWNGOLD_FENCE_GATE.get(), blockTexture(ModBlocks.DAWNGOLD_BLOCK.get()));
        wallBlock(ModBlocks.DAWNGOLD_WALL.get(), blockTexture(ModBlocks.DAWNGOLD_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.DAWNGOLD_DOOR.get(), modLoc("block/dawngold_door_bottom"), modLoc("block/dawngold_door_top"), "cutout" );
        trapdoorBlockWithRenderType(ModBlocks.DAWNGOLD_TRAPDOOR.get(), modLoc("block/dawngold_trapdoor"), true, "cutout" );


        blockItem(ModBlocks.DAWNGOLD_STAIRS);
        blockItem(ModBlocks.DAWNGOLD_SLAB);
        blockItem(ModBlocks.DAWNGOLD_Pressure_Plate);
        blockItem(ModBlocks.DAWNGOLD_FENCE_GATE);
        blockItem(ModBlocks.DAWNGOLD_TRAPDOOR, "_bottom");

        blockWithItem(ModBlocks.GOLDEN_LOG);
        blockWithItem(ModBlocks.DAWNGOLD_ORE);
        blockWithItem(ModBlocks.DAWNGOLD_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.SOLARITE_BLOCK);
        blockWithItem(ModBlocks.SOLARITE_ORE);
        //Special
        blockWithItem(ModBlocks.ZITRONIUM_BLOCK);
        blockWithItem(ModBlocks.ZITRONIUM_ORE);
        //Custom Special
        blockWithItem(ModBlocks.DIVINE_BLOCK);

    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("landsbeyond:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("landsbeyond:block/" + deferredBlock.getId().getPath() + appendix));

    }
}

