package net.jaymar.firstmod.datagen;

import net.jaymar.firstmod.JaymarMod;
import net.jaymar.firstmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, JaymarMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.SAPPHIRE);
        simpleItem(ModItems.RUBY);
        simpleItem(ModItems.METAL_DETECTOR);
        simpleItem(ModItems.RAW_ONION);
        simpleItem(ModItems.CHOPPED_ONION);
        simpleItem(ModItems.CHEESE);
        simpleItem(ModItems.LETTUCE);
        simpleItem(ModItems.RAW_BEEF_PATTY);
        simpleItem(ModItems.COOKED_BEEF_PATTY);
        simpleItem(ModItems.BURGER);
        simpleItem(ModItems.PINE_CONE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        // jaymar_first_mod/model/{item/item.id}
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(JaymarMod.MOD_ID, "item/"+item.getId().getPath()));
    }
}
