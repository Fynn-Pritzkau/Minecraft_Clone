package de.Fynn.engine;

import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;

public class KeyListener {
    private static KeyListener instance;
    private static boolean[] keyPressed = new boolean[350];


    private KeyListener()
    {

    }

    public static void keyCallback(long window, int key, int scancode, int action, int mods)
    {
        if(action == GLFW_PRESS)
        {
            if(key < get().keyPressed.length)
                get().keyPressed[key] = true;
        }
        else if(action == GLFW_RELEASE)
        {
            get().keyPressed[key] = false;
        }
    }

    public static KeyListener get()
    {
        if(KeyListener.instance == null)
        {
            KeyListener.instance = new KeyListener();
        }

        return KeyListener.instance;
    }

    public static boolean isKeyPressed(int keyCode)
    {
        if(keyCode < keyPressed.length)
            return keyPressed[keyCode];
        else
            return false;
    }


}
