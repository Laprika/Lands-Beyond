package net.laprika.LandsBeyond.datagen;

import net.laprika.LandsBeyond.Items.ModItems;
import net.laprika.LandsBeyond.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class LBDataMapProvider extends DataMapProvider {

    protected LBDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {
        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(ModItems.SOLARITE.getId(), new FurnaceFuel(1600), false)
                .add(ModBlocks.GOLDEN_LOG.getId(), new FurnaceFuel(400),false);
    }
}



