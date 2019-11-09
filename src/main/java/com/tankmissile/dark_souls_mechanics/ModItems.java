package com.tankmissile.dark_souls_mechanics;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import static com.tankmissile.dark_souls_mechanics.DarkSoulsMechanics.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(MOD_ID)
public class ModItems {
    public static final Item bonfire = null;

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){
        event.getRegistry().registerAll(
                new BlockItem(ModBlocks.bonfire, new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)).setRegistryName(ModBlocks.bonfire.getRegistryName())
        );
    }
}
