package net.laprika.LandsBeyond.datagen;

import net.laprika.LandsBeyond.LandsBeyond;
import net.laprika.LandsBeyond.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class LBModBlockTagProvider extends BlockTagsProvider {
    public LBModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, LandsBeyond.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.DAWNGOLD_BLOCK.get())

                .add(ModBlocks.DAWNGOLD_ORE.get())
                .add(ModBlocks.DAWNGOLD_DEEPSLATE_ORE.get())
                .add(ModBlocks.ZITRONIUM_BLOCK.get())
                .add(ModBlocks.ZITRONIUM_ORE.get())
                .add(ModBlocks.SOLARITE_BLOCK.get())
                .add(ModBlocks.SOLARITE_ORE.get())
        ;

        tag(BlockTags.FENCES).add(ModBlocks.DAWNGOLD_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.DAWNGOLD_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.DAWNGOLD_WALL.get());

        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.GOLDEN_LOG.get())
        ;

        tag(BlockTags.NEEDS_STONE_TOOL)

        ;

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.GOLDEN_LOG.get())

        ;

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.DAWNGOLD_ORE.get())
                .add(ModBlocks.DAWNGOLD_DEEPSLATE_ORE.get())
                .add(ModBlocks.ZITRONIUM_BLOCK.get())
                .add(ModBlocks.ZITRONIUM_ORE.get())
                .add(ModBlocks.SOLARITE_BLOCK.get())
                .add(ModBlocks.SOLARITE_ORE.get())


        ;
        tag(BlockTags.FENCES).add(ModBlocks.DAWNGOLD_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.DAWNGOLD_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.DAWNGOLD_WALL.get());


    }
}
