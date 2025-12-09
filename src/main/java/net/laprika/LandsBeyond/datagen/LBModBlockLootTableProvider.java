package net.laprika.LandsBeyond.datagen;

import net.laprika.LandsBeyond.Items.ModItems;
import net.laprika.LandsBeyond.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class LBModBlockLootTableProvider extends BlockLootSubProvider {
    protected LBModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {

        //Golden Lands Biome
        dropSelf(ModBlocks.GOLDEN_LOG.get());
        dropSelf(ModBlocks.DAWNGOLD_BLOCK.get());
        dropSelf(ModBlocks.DAWNGOLD_STAIRS.get());
        add(ModBlocks.DAWNGOLD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DAWNGOLD_SLAB.get()));

        dropSelf(ModBlocks.DAWNGOLD_Pressure_Plate.get());
        dropSelf(ModBlocks.DAWNGOLD_BUTTON.get());

        dropSelf(ModBlocks.DAWNGOLD_FENCE.get());
        dropSelf(ModBlocks.DAWNGOLD_FENCE_GATE.get());
        dropSelf(ModBlocks.DAWNGOLD_WALL.get());

        dropSelf(ModBlocks.DAWNGOLD_TRAPDOOR.get());
        add(ModBlocks.DAWNGOLD_DOOR.get(),
                block -> createDoorTable(ModBlocks.DAWNGOLD_DOOR.get()));

        add(ModBlocks.DAWNGOLD_ORE.get(),
                block -> createOreDrop(ModBlocks.DAWNGOLD_ORE.get(), ModItems.RAW_DAWNGOLD.get()));

        add(ModBlocks.DAWNGOLD_DEEPSLATE_ORE.get(),
                block -> createOreDrop(ModBlocks.DAWNGOLD_DEEPSLATE_ORE.get(), ModItems.RAW_DAWNGOLD.get()));

        dropSelf(ModBlocks.SOLARITE_BLOCK.get());

        add(ModBlocks.SOLARITE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.SOLARITE_ORE.get(), ModItems.SOLARITE.get(),1,2));

        //Special
        dropSelf(ModBlocks.ZITRONIUM_BLOCK.get());

        add(ModBlocks.ZITRONIUM_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.ZITRONIUM_ORE.get(), ModItems.ZITRONIUM.get(),1, 3));


    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}