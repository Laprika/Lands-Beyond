package net.laprika.LandsBeyond.Items;

import net.laprika.LandsBeyond.Items.CUSTOM.GodChiselItem;
import net.laprika.LandsBeyond.LandsBeyond;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(LandsBeyond.MOD_ID);

    public static  final DeferredItem<Item> RAW_DAWNGOLD = ITEMS.register("raw_dawngold",
            () -> new Item(new Item.Properties()));

    public static  final DeferredItem<Item> DAWNGOLD = ITEMS.register("dawngold",
            () -> new Item(new Item.Properties()));

    public static  final DeferredItem<Item> LANDSBEYOND_ICON = ITEMS.register("landsbeyond_icon",
            () -> new Item(new Item.Properties()));

    public static  final DeferredItem<Item> LANDSBEYOND_ICON2 = ITEMS.register("landsbeyond_icon2",
            () -> new Item(new Item.Properties()));

    public static  final DeferredItem<Item> ZITRONIUM = ITEMS.register("zitronium",
            () -> new Item(new Item.Properties()));
    public static  final DeferredItem<Item> GOD_CHISEL_ITEM = ITEMS.register("god_chisel_item",
            () -> new GodChiselItem(new Item.Properties().durability(64)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
