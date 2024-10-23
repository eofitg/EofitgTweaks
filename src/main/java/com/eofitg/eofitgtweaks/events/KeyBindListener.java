package com.eofitg.eofitgtweaks.events;

import com.eofitg.eofitgtweaks.utils.AutoJump;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class KeyBindListener {

    private final KeyBinding autoJumpKeyBind = new KeyBinding("Auto Jump", Keyboard.KEY_TAB, "EofitgTweaks");

    public KeyBindListener() {
        // register key-bind for it to show up in the settings menu
        ClientRegistry.registerKeyBinding(autoJumpKeyBind);
    }

    @SubscribeEvent
    public void onKeyPress(InputEvent.KeyInputEvent event) {
        // this method runs everytime a key on the keyboard is pressed / unpressed

        if (autoJumpKeyBind.isPressed()) { // using isPressed() will return true once when the key is pressed
            AutoJump.toggle();
        }

    }
}
