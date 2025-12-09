package net.laprika.LandsBeyond.Items;

import net.laprika.LandsBeyond.LandsBeyond;
import net.laprika.LandsBeyond.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LandsBeyond.MOD_ID);

    public static final Supplier<CreativeModeTab> LANDSBEYOND_ITEM_TAB = CREATIVE_MODE_TAB.register("landsbeyond_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.LANDSBEYOND_ICON.get()))
                    .title(Component.translatable("creativetab.landsbeyond.items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.RAW_DAWNGOLD);
                        output.accept(ModItems.DAWNGOLD);
                        output.accept(ModItems.ZITRONIUM);
                        output.accept(ModItems.GOD_CHISEL_ITEM);
                        output.accept(ModItems.DAWNGOLD_APPLE);
                        output.accept(ModItems.SOLARITE);

                    }).build());

    public static final Supplier<CreativeModeTab> LANDSBEYOND_BLOCKS_TAB = CREATIVE_MODE_TAB.register("landsbeyond_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.LANDSBEYOND_ICON2.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(LandsBeyond.MOD_ID,"landsbeyond_items_tab"))
                    .title(Component.translatable("creativetab.landsbeyond.blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        //Golden Lands
                        output.accept(ModBlocks.DAWNGOLD_BLOCK);
                        output.accept(ModBlocks.DAWNGOLD_STAIRS);
                        output.accept(ModBlocks.DAWNGOLD_SLAB);
                        output.accept(ModBlocks.DAWNGOLD_Pressure_Plate);
                        output.accept(ModBlocks.DAWNGOLD_BUTTON);
                        output.accept(ModBlocks.DAWNGOLD_FENCE);
                        output.accept(ModBlocks.DAWNGOLD_FENCE_GATE);
                        output.accept(ModBlocks.DAWNGOLD_WALL);
                        output.accept(ModBlocks.DAWNGOLD_DOOR);
                        output.accept(ModBlocks.DAWNGOLD_TRAPDOOR);
                        output.accept(ModBlocks.DAWNGOLD_ORE);
                        output.accept(ModBlocks.DAWNGOLD_DEEPSLATE_ORE);
                        output.accept(ModBlocks.SOLARITE_ORE);
                        output.accept(ModBlocks.SOLARITE_BLOCK);
                        output.accept(ModBlocks.GOLDEN_LOG);


                        output.accept(ModBlocks.ZITRONIUM_BLOCK);
                        output.accept(ModBlocks.ZITRONIUM_ORE);
                        output.accept(ModBlocks.DIVINE_BLOCK);
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
