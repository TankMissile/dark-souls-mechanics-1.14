package com.tankmissile.dark_souls_mechanics;

import com.tankmissile.dark_souls_mechanics.blocks.BonfireBlock;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import static com.tankmissile.dark_souls_mechanics.DarkSoulsMechanics.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(MOD_ID)
public class ModBlocks {
    public static final Block bonfire = null;

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                new BonfireBlock().setRegistryName(MOD_ID, "bonfire")
        );
    }
}
