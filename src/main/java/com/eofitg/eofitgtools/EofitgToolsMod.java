package com.eofitg.eofitgtools;

import com.eofitg.eofitgtools.events.KeyBindListener;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = EofitgToolsMod.MODID, name = EofitgToolsMod.MODNAME, version = EofitgToolsMod.VERSION)
public class EofitgToolsMod {
    public static final String MODID = "eofitgtools";
    public static final String MODNAME = "eofitg Tools";
    public static final String VERSION = "1.0";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new KeyBindListener());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }


}
