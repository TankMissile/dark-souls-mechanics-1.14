package com.tankmissile.dark_souls_mechanics;

import net.minecraft.item.*;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = DarkSoulsMechanics.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(DarkSoulsMechanics.MOD_ID)
public class ModItems {
    private static final Item.Properties weapon = new Item.Properties().group(ItemGroup.COMBAT);

    public static final Item smoughs_hammer =
            new SwordItem(ItemTier.DIAMOND, 7, -3, weapon)
                    .setRegistryName(DarkSoulsMechanics.MOD_ID, "smoughs_hammer");

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){
        event.getRegistry().registerAll(
                smoughs_hammer
        );
    }
}
