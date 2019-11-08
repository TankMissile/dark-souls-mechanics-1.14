package com.tankmissile.dark_souls_mechanics;

import com.tankmissile.dark_souls_mechanics.blocks.BonfireBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.tankmissile.dark_souls_mechanics.DarkSoulsMechanics.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks {
    public static final Block bonfire = new BonfireBlock().setRegistryName(MOD_ID, "bonfire");

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                bonfire
        );
    }
}
