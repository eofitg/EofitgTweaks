package com.eofitg.eofitgtools;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = EofitgToolsMod.MODID, version = EofitgToolsMod.VERSION, name = "eofitg Tools")
public class EofitgToolsMod {
    public static final String MODID = "eofitgtools";
    public static final String VERSION = "1.0";

    @EventHandler
    public void preLoad(FMLPreInitializationEvent event) {

    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
		// some example code
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    }

    @EventHandler
    public void postLoad(FMLPostInitializationEvent event) {

    }


}
