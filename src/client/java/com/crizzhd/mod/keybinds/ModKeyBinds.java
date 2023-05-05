package com.crizzhd.mod.keybinds;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class ModKeyBinds {
    public String Key_Category = "key.crizzhdmod";
    public String test_Key_Name = "key.crizzhdmod.test";
    public KeyBinding test;

    public void registerKeyInputs(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(test.wasPressed()) {
                client.player.sendMessage(Text.of("MY ASS IS NICE COME LOOK"),true);
            }
        });
    }
    public void register(){
        test = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                test_Key_Name,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_O,
                Key_Category
        ));
        registerKeyInputs();
    }
}
