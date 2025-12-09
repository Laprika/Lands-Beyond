package net.laprika.LandsBeyond.datagen;

import net.laprika.LandsBeyond.Items.ModItems;
import net.laprika.LandsBeyond.LandsBeyond;
import net.laprika.LandsBeyond.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class LBModItemModelProvider extends ItemModelProvider {
    public LBModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, LandsBeyond.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.LANDSBEYOND_ICON.get());
        basicItem(ModItems.LANDSBEYOND_ICON2.get());
        //Golden Lands
        basicItem(ModItems.DAWNGOLD.get());
        buttonItem(ModBlocks.DAWNGOLD_BUTTON, ModBlocks.DAWNGOLD_BLOCK);
        fenceItem(ModBlocks.DAWNGOLD_FENCE, ModBlocks.DAWNGOLD_BLOCK);
        wallItem(ModBlocks.DAWNGOLD_WALL, ModBlocks.DAWNGOLD_BLOCK);
        basicItem(ModBlocks.DAWNGOLD_DOOR.asItem());
        basicItem(ModItems.RAW_DAWNGOLD.get());
        basicItem(ModItems.SOLARITE.get());
        basicItem(ModItems.DAWNGOLD_APPLE.get());
        //Special
        basicItem(ModItems.ZITRONIUM.get());
        //Custom Special
        basicItem(ModItems.GOD_CHISEL_ITEM.get());



    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(LandsBeyond.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(LandsBeyond.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", ResourceLocation.fromNamespaceAndPath(LandsBeyond.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));

    }
}
