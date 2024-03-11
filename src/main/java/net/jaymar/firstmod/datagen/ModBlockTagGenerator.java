package net.jaymar.firstmod.datagen;

import net.jaymar.firstmod.JaymarMod;
import net.jaymar.firstmod.blocks.ModBlocks;
import net.jaymar.firstmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, JaymarMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(ModBlocks.SAPPHIRE_ORE.get())
                .addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        ModBlocks.SAPPHIRE_ORE.get(),
                        ModBlocks.SAPPHIRE_BLOCK.get(),
                        ModBlocks.MYSTERY_BLOCK.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SAPPHIRE_ORE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SAPPHIRE_BLOCK.get());

        this.tag(ModTags.Blocks.NEEDS_SAPPHIRE_TOOL)
                .add(
                        ModBlocks.SOUND_BLOCK.get(),
                        ModBlocks.SAPPHIRE_BLOCK.get(),
                        ModBlocks.SAPPHIRE_STAIRS.get(),
                        ModBlocks.SAPPHIRE_SLAB.get(),
                        ModBlocks.SAPPHIRE_DOOR.get(),
                        ModBlocks.SAPPHIRE_TRAPDOOR.get(),
                        ModBlocks.SAPPHIRE_FENCE.get(),
                        ModBlocks.SAPPHIRE_BUTTON.get(),
                        ModBlocks.SAPPHIRE_FENCE_GATE.get());

        // FENCE, FENCE GATE AND WALL, this must be added so that they will connect to each other
        this.tag(BlockTags.FENCES)
                .add(ModBlocks.SAPPHIRE_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.SAPPHIRE_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.SAPPHIRE_WALL.get());
    }
}
