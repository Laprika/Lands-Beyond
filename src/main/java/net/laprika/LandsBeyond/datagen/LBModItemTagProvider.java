package net.laprika.LandsBeyond.datagen;

import net.laprika.LandsBeyond.Items.ModItems;
import net.laprika.LandsBeyond.LandsBeyond;
import net.laprika.LandsBeyond.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class LBModItemTagProvider extends ItemTagsProvider {

    public LBModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, LandsBeyond.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(ModTags.Items.DIVINE_AMPLIFY_ITEMS)
                .add(ModItems.RAW_DAWNGOLD.get())
                .add(Items.RAW_GOLD)
                .add(Items.GOLD_INGOT);

    }
}

