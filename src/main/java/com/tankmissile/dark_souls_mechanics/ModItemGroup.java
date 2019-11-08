package com.tankmissile.dark_souls_mechanics;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static com.tankmissile.dark_souls_mechanics.ModItems.bonfire;

public class ModItemGroup {
    public static final ItemGroup DARK_SOULS_BLOCKS = (new ItemGroup(0, "darkSoulsBlocks") {
        @OnlyIn(Dist.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(bonfire);
        }
    }).setTabPath("dark_souls_blocks");
}
