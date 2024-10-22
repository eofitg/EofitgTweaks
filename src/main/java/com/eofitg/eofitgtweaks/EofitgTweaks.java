package com.eofitg.eofitgtweaks;

import com.eofitg.eofitgtweaks.events.KeyBindListener;
import com.eofitg.eofitgtweaks.utils.AutoJump;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = EofitgTweaks.MODID, name = EofitgTweaks.MODNAME, version = EofitgTweaks.VERSION)
public class EofitgTweaks {
    public static final String MODID = "eofitgtweaks";
    public static final String MODNAME = "eofitg Tweaks";
    public static final String VERSION = "1.0";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new KeyBindListener());
        MinecraftForge.EVENT_BUS.register(new AutoJump());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }


}
