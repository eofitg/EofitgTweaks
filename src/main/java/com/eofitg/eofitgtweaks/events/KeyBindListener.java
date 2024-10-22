package com.eofitg.eofitgtweaks.events;

import com.eofitg.eofitgtweaks.utils.AutoJump;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class KeyBindListener {

    private final KeyBinding autoJumpKeyBind = new KeyBinding("Pickup Jump", Keyboard.KEY_TAB, "EofitgTweaks");

    public KeyBindListener() {
        // you need to register your key-bind for it to show up in the settings menu
        ClientRegistry.registerKeyBinding(autoJumpKeyBind);
    }

    @SubscribeEvent
    public void onKeyPress(InputEvent.KeyInputEvent event) {
        // this method runs everytime a key on the keyboard is pressed / unpressed

        if (autoJumpKeyBind.isPressed()) { // using isPressed() will return true once when the key is pressed

            AutoJump.isActive = !AutoJump.isActive;
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Pickup Jump Toggled To \"" + AutoJump.isActive + "\""));

        } else if (autoJumpKeyBind.isKeyDown()) { // using isKeyDown() will return true the whole time the key is held down

            // Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("The example keybind is held down"));

        }
    }
}
