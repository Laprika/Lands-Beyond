package net.laprika.LandsBeyond.datagen;

import net.laprika.LandsBeyond.Items.ModItems;
import net.laprika.LandsBeyond.LandsBeyond;
import net.laprika.LandsBeyond.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class LBModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public LBModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        // Golden Lands
        List<ItemLike> GOLDEN_LANDS_ORE_SMELTABLES = List.of(
                ModItems.RAW_DAWNGOLD,
                ModBlocks.DAWNGOLD_ORE,
                ModBlocks.DAWNGOLD_DEEPSLATE_ORE,
                ModBlocks.GOLDEN_LOG);
        List<ItemLike> GOLDEN_LANDS_LOG_SMELTABLES = List.of(
                ModBlocks.GOLDEN_LOG);



        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.DAWNGOLD_BLOCK.get())
                .pattern("DDD")
                .pattern("DDD")
                .pattern("DDD")
                .define('D', ModItems.DAWNGOLD.get())
                .unlockedBy("has_dawngold", has(ModItems.DAWNGOLD)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.DAWNGOLD.get(), 9)
                .requires(ModBlocks.DAWNGOLD_BLOCK)
                .unlockedBy("has_dawngold_block", has(ModBlocks.DAWNGOLD_BLOCK))
                .save(recipeOutput);
        oreSmelting(recipeOutput, GOLDEN_LANDS_LOG_SMELTABLES, RecipeCategory.MISC, Items.GOLD_NUGGET, 1, 100, "Golden_Lands");
        oreSmelting(recipeOutput, GOLDEN_LANDS_ORE_SMELTABLES, RecipeCategory.MISC, ModItems.DAWNGOLD.get(), 5, 3200, "Golden_Lands_Ores");
        oreBlasting(recipeOutput, GOLDEN_LANDS_ORE_SMELTABLES, RecipeCategory.MISC, ModItems.DAWNGOLD.get(), 5, 1600, "Golden_Lands_Ores");

        stairBuilder(ModBlocks.DAWNGOLD_STAIRS.get(), Ingredient.of(ModItems.DAWNGOLD)).group("dawngold")
                .unlockedBy("has_dawngold", has(ModItems.DAWNGOLD)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DAWNGOLD_SLAB.get(), ModItems.DAWNGOLD.get());
        buttonBuilder(ModBlocks.DAWNGOLD_BUTTON.get(), Ingredient.of(ModItems.DAWNGOLD)).group("dawngold")
                .unlockedBy("has_dawngold", has(ModItems.DAWNGOLD)).save(recipeOutput);
        fenceBuilder(ModBlocks.DAWNGOLD_FENCE.get(), Ingredient.of(ModItems.DAWNGOLD)).group("dawngold")
                .unlockedBy("has_dawngold", has(ModItems.DAWNGOLD)).save(recipeOutput);
        fenceGateBuilder(ModBlocks.DAWNGOLD_FENCE_GATE.get(), Ingredient.of(ModItems.DAWNGOLD)).group("dawngold")
                .unlockedBy("has_dawngold", has(ModItems.DAWNGOLD)).save(recipeOutput);
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DAWNGOLD_WALL.get(), ModItems.DAWNGOLD.get());
        doorBuilder(ModBlocks.DAWNGOLD_DOOR.get(), Ingredient.of(ModItems.DAWNGOLD)).group("dawngold")
                .unlockedBy("has_dawngold", has(ModItems.DAWNGOLD)).save(recipeOutput);
        trapdoorBuilder(ModBlocks.DAWNGOLD_TRAPDOOR.get(), Ingredient.of(ModItems.DAWNGOLD))
                .unlockedBy("has_dawngold", has(ModItems.DAWNGOLD)).save(recipeOutput);
    }

        protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
        float pExperience, int pCookingTIme, String pGroup) {
            oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                    pExperience, pCookingTIme, pGroup, "_from_smelting");
        }

        protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
        float pExperience, int pCookingTime, String pGroup) {
            oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                    pExperience, pCookingTime, pGroup, "_from_blasting");
        }

        protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                           List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
            for (ItemLike itemlike : pIngredients) {
                SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                        .save(recipeOutput, LandsBeyond.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));


            }
        }
}