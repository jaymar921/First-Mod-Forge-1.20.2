package net.jaymar.firstmod.datagen;

import it.unimi.dsi.fastutil.Hash;
import net.jaymar.firstmod.JaymarMod;
import net.jaymar.firstmod.blocks.ModBlocks;
import net.jaymar.firstmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Iterator;
import java.util.List;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> BEEF_PATTY_SMELT = List.of(ModItems.RAW_BEEF_PATTY.get());
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        oreBlasting(recipeOutput, BEEF_PATTY_SMELT, RecipeCategory.FOOD, ModItems.COOKED_BEEF_PATTY.get(), 0.25f,400, "beef_patty");
        oreSmelting(recipeOutput, BEEF_PATTY_SMELT, RecipeCategory.FOOD, ModItems.COOKED_BEEF_PATTY.get(), 0.25f,500, "beef_patty");

        simpleCookingRecipe(recipeOutput, "campfire_cooking_raw_beef_patty", SimpleCookingSerializer.CAMPFIRE_COOKING_RECIPE, 400, ModItems.RAW_BEEF_PATTY.get(), ModItems.COOKED_BEEF_PATTY.get(), 1.0f);
        simpleCookingRecipe(recipeOutput, "smoking_raw_beef_patty", SimpleCookingSerializer.SMOKING_RECIPE, 80, ModItems.RAW_BEEF_PATTY.get(), ModItems.COOKED_BEEF_PATTY.get(), 1.0f);

        // Burger
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.BURGER.get())
                .pattern("BBB")
                .pattern("LPC")
                .pattern("BBB")
                .define('B', Items.BREAD)
                .define('L', ModItems.LETTUCE.orElse(ModItems.CHEESE.get()))
                .define('P', ModItems.COOKED_BEEF_PATTY.get())
                .define('C', ModItems.CHEESE.orElse(ModItems.LETTUCE.get()))
                .unlockedBy(getHasName(ModItems.COOKED_BEEF_PATTY.get()), has(ModItems.COOKED_BEEF_PATTY.get()))
                .unlockedBy(getHasName(ModItems.CHEESE.get()), has(ModItems.CHEESE.get()))
                .unlockedBy(getHasName(ModItems.LETTUCE.get()), has(ModItems.LETTUCE.get()))
                .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                .save(recipeOutput);

        // Sapphire Block
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SAPPHIRE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
                .save(recipeOutput);

        // Sapphire
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 9)
                .requires(ModBlocks.SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
                .save(recipeOutput);

        // Chopped Onion
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHOPPED_ONION.get(), 2)
                .requires(ModItems.RAW_ONION.get())
                .unlockedBy(getHasName(ModItems.RAW_ONION.get()),has(ModItems.RAW_ONION.get()))
                .save(recipeOutput);

        // Raw Beef Patty
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.RAW_BEEF_PATTY.get(), 2)
                .requires(Items.BEEF)
                .requires(ModItems.CHOPPED_ONION.get())
                .unlockedBy(getHasName(Items.BEEF),has(Items.BEEF))
                .unlockedBy(getHasName(ModItems.CHOPPED_ONION.get()),has(ModItems.CHOPPED_ONION.get()))
                .save(recipeOutput);

        // Cheese
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHEESE.get(), 2)
                .requires(Items.MILK_BUCKET)
                .unlockedBy(getHasName(Items.MILK_BUCKET),has(Items.MILK_BUCKET))
                .save(recipeOutput);
    }

    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<? extends AbstractCookingRecipe> pSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult, pExperience, pCookingTime, pSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike)).save(pRecipeOutput, JaymarMod.MOD_ID + ":" +getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
        }

    }

    private static void simpleCookingRecipe(RecipeOutput pRecipeOutput, String pCookingMethod, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, int pCookingTime, ItemLike pMaterial, ItemLike pResult, float pExperience) {
        SimpleCookingRecipeBuilder var10000 = SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{pMaterial}), RecipeCategory.FOOD, pResult, pExperience, pCookingTime, pCookingSerializer).unlockedBy(getHasName(pMaterial), has(pMaterial));
        String var10002 = getItemName(pResult);
        var10000.save(pRecipeOutput, JaymarMod.MOD_ID + ":" +var10002 + "_from_" + pCookingMethod);
    }
}
