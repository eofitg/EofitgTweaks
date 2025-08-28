package com.eofitg.eofitgtweaks;

import com.eofitg.eofitgtweaks.event.KeyBindListener;
import com.eofitg.eofitgtweaks.service.AntiAntiAFK;
import com.eofitg.eofitgtweaks.service.AutoJump;
import com.eofitg.eofitgtweaks.util.Reference;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.*;

@Mod(
        modid = Reference.MOD_ID,
        name = Reference.MOD_NAME,
        version = Reference.MOD_VERSION,
        clientSideOnly = true
)
public class EofitgTweaks {
    public static final AutoJump autoJump = new AutoJump();
    public static final AntiAntiAFK antiAntiAFK = new AntiAntiAFK();

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

    // Personal save or server stopping
    @EventHandler
    public void stopping(FMLServerStoppingEvent event) {
        killThreads();
    }

    // Stop all the running threads
    private void killThreads() {
        autoJump.killThread();
        antiAntiAFK.killThread();
    }
}
