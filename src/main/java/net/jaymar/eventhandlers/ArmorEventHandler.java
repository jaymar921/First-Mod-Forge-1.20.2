package net.jaymar.eventhandlers;

import com.google.common.collect.ImmutableMap;
import net.jaymar.firstmod.item.ModArmorMaterials;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Map;

/*
    Alternative to ModArmorItem.onArmorTick() : Not sure if this is efficient
    To make this work, you must have to register this as a new instance in your Mod Main class

    See in JaymarMod.class
    Example: MinecraftForge.EVENT_BUS.register(new ArmorEventHandler());
 */
public class ArmorEventHandler {
    private static final Map<ArmorMaterial, MobEffectInstance> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>())
                    .put(ModArmorMaterials.SAPPHIRE, new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 1, false, false, true)).build();

    @SubscribeEvent
    public void OnArmorTicking(TickEvent.PlayerTickEvent event){
        Player player = event.player;
        if(hasFullSuitOfArmorOn(player)){
            evaluateArmorEffects(player);
        }
    }

    private boolean hasFullSuitOfArmorOn(Player player){
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack chestplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty() && !chestplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }

    private void evaluateArmorEffects(Player player){
        for(Map.Entry<ArmorMaterial, MobEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()){
            ArmorMaterial mapArmorMaterial = entry.getKey();
            MobEffectInstance mapStatusEffect = entry.getValue();

            if(hasCorrectArmorOn(mapArmorMaterial, player)){
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, Player player){
        for(ItemStack armorStack : player.getInventory().armor){
            // We have to make sure that the player only equips armor item, except Elytra
            if(!(armorStack.getItem() instanceof ArmorItem))
                return false;
        }

        ArmorItem boots = ((ArmorItem) player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmor(1).getItem());
        ArmorItem breastplate = ((ArmorItem) player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmor(3).getItem());

        return helmet.getMaterial() == material && breastplate.getMaterial() == material && leggings.getMaterial() == material && boots.getMaterial() == material;
    }

    private void addStatusEffectForMaterial(Player player, ArmorMaterial mapArmorMaterial, MobEffectInstance mapStatusEffect){
        boolean hasPlayerEffect = player.hasEffect(mapStatusEffect.getEffect());

        if(hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect)
            player.addEffect(new MobEffectInstance(mapStatusEffect));
    }
}
