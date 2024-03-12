package net.jaymar.firstmod.item;

import net.jaymar.firstmod.JaymarMod;
import net.jaymar.firstmod.item.custom.FoodItem;
import net.jaymar.firstmod.item.custom.FuelItem;
import net.jaymar.firstmod.item.custom.MetalDetectorItem;
import net.minecraft.world.item.*;
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
            () -> new FoodItem(new Item.Properties().food(ModFoods.RAW_ONION)));
    public static final RegistryObject<Item> CHOPPED_ONION = ITEMS.register("chopped_onion",
            () -> new FoodItem(new Item.Properties().food(ModFoods.CHOPPED_ONION)));
    public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese",
            () -> new FoodItem(new Item.Properties().food(ModFoods.CHEESE)));
    public static final RegistryObject<Item> LETTUCE = ITEMS.register("lettuce",
            () -> new FoodItem(new Item.Properties().food(ModFoods.LETTUCE)));
    public static final RegistryObject<Item> RAW_BEEF_PATTY = ITEMS.register("raw_beef_patty",
            () -> new FoodItem(new Item.Properties().food(ModFoods.RAW_BEEF_PATTY)));
    public static final RegistryObject<Item> COOKED_BEEF_PATTY = ITEMS.register("cooked_beef_patty",
            () -> new FoodItem(new Item.Properties().food(ModFoods.COOKED_BEEF_PATTY)));
    public static final RegistryObject<Item> BURGER = ITEMS.register("burger",
            () -> new FoodItem(new Item.Properties().food(ModFoods.BURGER)));

    public static final RegistryObject<Item> PINE_CONE = ITEMS.register("pine_cone",
            () -> new FuelItem(new Item.Properties(), 400));

    public static final RegistryObject<Item> SAPPHIRE_STAFF = ITEMS.register("sapphire_staff", () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword", () -> new SwordItem(ModToolTiers.SAPPHIRE, 5, 4,new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe", () -> new PickaxeItem(ModToolTiers.SAPPHIRE, 2, 1,new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_AXE = ITEMS.register("sapphire_axe", () -> new AxeItem(ModToolTiers.SAPPHIRE, 7, 2,new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel", () -> new ShovelItem(ModToolTiers.SAPPHIRE, 1, 0,new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe", () -> new HoeItem(ModToolTiers.SAPPHIRE, 0, 0,new Item.Properties()));


    public static final RegistryObject<Item> SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet", () -> new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_CHESTPLATE = ITEMS.register("sapphire_chestplate", () -> new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_LEGGINGS = ITEMS.register("sapphire_leggings", () -> new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_BOOTS = ITEMS.register("sapphire_boots", () -> new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.BOOTS, new Item.Properties()));
    // Register the items in the event bus
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
