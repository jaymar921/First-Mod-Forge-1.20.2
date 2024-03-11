package net.jaymar.firstmod.item;

import net.jaymar.firstmod.JaymarMod;
import net.jaymar.firstmod.blocks.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JaymarMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> JAYMAR_MOD_TAB = CREATIVE_MODE_TABS.register("jaymar_mod_tabs",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.SAPPHIRE.get()))
                    .title(Component.translatable("creativetab.jaymar_mod_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        // register our items, ordering matters
                        output.accept(ModItems.SAPPHIRE.get());
                        output.accept(ModItems.RUBY.get());
                        output.accept(ModItems.BITCOIN.get());
                        output.accept(ModItems.PINE_CONE.get());
                        output.accept(ModItems.SAPPHIRE_STAFF.get());
                        output.accept(ModItems.SAPPHIRE_SWORD.get());
                        output.accept(ModItems.SAPPHIRE_AXE.get());
                        output.accept(ModItems.SAPPHIRE_PICKAXE.get());
                        output.accept(ModItems.SAPPHIRE_SHOVEL.get());
                        output.accept(ModItems.SAPPHIRE_HOE.get());
                        // adding vanilla items, no need get() method
                        output.accept(Items.CRAFTING_TABLE);

                        // register our block
                        output.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                        output.accept(ModBlocks.SAPPHIRE_ORE.get());
                        output.accept(ModBlocks.MYSTERY_BLOCK.get());

                        // register custom Items
                        output.accept(ModItems.METAL_DETECTOR.get());
                        // register custom blocks
                        output.accept(ModBlocks.SOUND_BLOCK.get());

                        output.accept(ModBlocks.SAPPHIRE_STAIRS.get());
                        output.accept(ModBlocks.SAPPHIRE_SLAB.get());
                        output.accept(ModBlocks.SAPPHIRE_BUTTON.get());
                        output.accept(ModBlocks.SAPPHIRE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.SAPPHIRE_FENCE.get());
                        output.accept(ModBlocks.SAPPHIRE_FENCE_GATE.get());
                        output.accept(ModBlocks.SAPPHIRE_WALL.get());
                        output.accept(ModBlocks.SAPPHIRE_DOOR.get());
                        output.accept(ModBlocks.SAPPHIRE_TRAPDOOR.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> JAYMAR_MOD_FOOD = CREATIVE_MODE_TABS.register("jaymar_food_tabs",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.BURGER.get()))
                    .title(Component.translatable("creativetab.jaymar_food_tab"))
                    .displayItems(((itemDisplayParameters, output) -> {
                        // register foods
                        output.accept(ModItems.RAW_ONION.get());
                        output.accept(ModItems.CHOPPED_ONION.get());
                        output.accept(ModItems.CHEESE.get());
                        output.accept(ModItems.LETTUCE.get());
                        output.accept(ModItems.RAW_BEEF_PATTY.get());
                        output.accept(ModItems.COOKED_BEEF_PATTY.get());
                        output.accept(ModItems.BURGER.get());
                    }))
                    .build());
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
