package net.jaymar.firstmod.item;

import net.jaymar.firstmod.JaymarMod;
import net.jaymar.firstmod.item.custom.MetalDetectorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    /*
        DeferredRegister is basically a long list of things, in our case `Item` and were
        going to register the items when forge is loaded
     */
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, JaymarMod.MOD_ID);

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BITCOIN = ITEMS.register("bitcoin", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));

    // FOODS
    public static final RegistryObject<Item> RAW_ONION = ITEMS.register("raw_onion",
            () -> new Item(new Item.Properties().food(ModFoods.RAW_ONION)));
    public static final RegistryObject<Item> CHOPPED_ONION = ITEMS.register("chopped_onion",
            () -> new Item(new Item.Properties().food(ModFoods.CHOPPED_ONION)));
    public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese",
            () -> new Item(new Item.Properties().food(ModFoods.CHEESE)));
    public static final RegistryObject<Item> LETTUCE = ITEMS.register("lettuce",
            () -> new Item(new Item.Properties().food(ModFoods.LETTUCE)));
    public static final RegistryObject<Item> RAW_BEEF_PATTY = ITEMS.register("raw_beef_patty",
            () -> new Item(new Item.Properties().food(ModFoods.RAW_BEEF_PATTY)));
    public static final RegistryObject<Item> COOKED_BEEF_PATTY = ITEMS.register("cooked_beef_patty",
            () -> new Item(new Item.Properties().food(ModFoods.COOKED_BEEF_PATTY)));
    public static final RegistryObject<Item> BURGER = ITEMS.register("burger",
            () -> new Item(new Item.Properties().food(ModFoods.BURGER)));

    // Register the items in the event bus
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
