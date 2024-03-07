package net.jaymar.firstmod.item;

import net.jaymar.firstmod.JaymarMod;
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


    // Register the items in the event bus
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
