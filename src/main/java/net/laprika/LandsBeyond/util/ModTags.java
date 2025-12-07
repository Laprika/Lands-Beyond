package net.laprika.LandsBeyond.util;

import net.laprika.LandsBeyond.LandsBeyond;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;


public class ModTags {

    public static class Blocks {

        public static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(LandsBeyond.MOD_ID, name));
        }
    }

    public static class Items {
            public static final TagKey<Item> DIVINE_AMPLIFY_ITEMS = createTag("divine_amplify_items");

        public static TagKey<Item> createTag (String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(LandsBeyond.MOD_ID, name));
        }

    }

}