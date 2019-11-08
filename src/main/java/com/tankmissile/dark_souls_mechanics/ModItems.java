package com.tankmissile.dark_souls_mechanics;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.tankmissile.dark_souls_mechanics.DarkSoulsMechanics.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {
    public static final Item bonfire = new BlockItem(ModBlocks.bonfire, new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)).setRegistryName(ModBlocks.bonfire.getRegistryName());

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){
        event.getRegistry().registerAll(
                bonfire
        );
    }
}
