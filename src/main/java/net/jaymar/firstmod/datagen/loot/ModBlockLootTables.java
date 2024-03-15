package net.jaymar.firstmod.datagen.loot;

import net.jaymar.firstmod.blocks.ModBlocks;
import net.jaymar.firstmod.blocks.custom.CornCropBlock;
import net.jaymar.firstmod.blocks.custom.StrawberryCropBlock;
import net.jaymar.firstmod.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.SAPPHIRE_BLOCK.get());
        this.dropSelf(ModBlocks.SOUND_BLOCK.get());

        this.add(ModBlocks.SAPPHIRE_ORE.get(), block -> createCustomDrop(ModBlocks.SAPPHIRE_ORE.get(), ModItems.SAPPHIRE.get(), UniformGenerator.between(2.0f, 3.0f)));
        createMultipleDrops(ModBlocks.MYSTERY_BLOCK.get(),
            List.of(
                    ModItems.SAPPHIRE.get(),
                    ModItems.BITCOIN.get(),
                    ModItems.PINE_CONE.get(),
                    ModItems.METAL_DETECTOR.get()
        ), UniformGenerator.between(1.0f, 1.0f));

        this.dropSelf(ModBlocks.SAPPHIRE_STAIRS.get());
        this.dropSelf(ModBlocks.SAPPHIRE_BUTTON.get());
        this.dropSelf(ModBlocks.SAPPHIRE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.SAPPHIRE_TRAPDOOR.get());
        this.dropSelf(ModBlocks.SAPPHIRE_FENCE.get());
        this.dropSelf(ModBlocks.SAPPHIRE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.SAPPHIRE_WALL.get());

        this.add(ModBlocks.SAPPHIRE_SLAB.get(), block -> createSlabItemTable(ModBlocks.SAPPHIRE_SLAB.get()));
        this.add(ModBlocks.SAPPHIRE_DOOR.get(), block -> createDoorTable(ModBlocks.SAPPHIRE_DOOR.get()));

        // Make sure that the strawberry crop will only drop strawberry when the age reaches to 5(Max)
        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.STRAWBERRY_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(StrawberryCropBlock.AGE, 5));
        this.add(ModBlocks.STRAWBERRY_CROP.get(), createCropDrops(ModBlocks.STRAWBERRY_CROP.get(), ModItems.STRAWBERRY.get(),
                ModItems.STRAWBERRY_SEEDS.get(), lootItemConditionBuilder));

        // Make sure that the corn crop will only drop cron when the age reaches to age 7 or stage 8
        LootItemCondition.Builder lootItemConditionBuilder2 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.CORN_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(StrawberryCropBlock.AGE, 7))
                .or(LootItemBlockStatePropertyCondition
                        .hasBlockStateProperties(ModBlocks.CORN_CROP.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornCropBlock.AGE, 8)));
        this.add(ModBlocks.CORN_CROP.get(), createCropDrops(ModBlocks.CORN_CROP.get(), ModItems.CORN.get(),
                ModItems.CORN_SEEDS.get(), lootItemConditionBuilder2));
    }

    protected LootTable.Builder createCustomDrop(Block pBlock, Item item, UniformGenerator uniformGenerator) {
        return createSilkTouchDispatchTable(pBlock, (LootPoolEntryContainer.Builder)
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(uniformGenerator))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    protected void createMultipleDrops(Block pBlock, List<Item> items, UniformGenerator uniformGenerator){
        items.forEach(item -> this.add(pBlock, createCustomDrop(pBlock, item, uniformGenerator)));
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
