package net.kdt.pojavlaunch.customcontrols.gamepad;

import net.kdt.pojavlaunch.LwjglGlfwKeycode;

public class GamepadMap {


    public static final short MOUSE_SCROLL_DOWN = -1;
    public static final short MOUSE_SCROLL_UP = -2;
    // Made mouse keycodes their own specials because managing special keycodes above 0
    // proved to be complicated
    public static final short MOUSE_LEFT = -3;
    public static final short MOUSE_MIDDLE = -4;
    public static final short MOUSE_RIGHT = -5;
    // Workaround, because GLFW_KEY_UNKNOWN and GLFW_MOUSE_BUTTON_LEFT are both 0
    public static final short UNSPECIFIED = -6;

    /*
    This class is just here to store the mapping
    can be modified to create re-mappable controls I guess

    Be warned, you should define ALL keys if you want to avoid a non defined exception
   */

    public GamepadButton BUTTON_A;
    public GamepadButton BUTTON_B;
    public GamepadButton BUTTON_X;
    public GamepadButton BUTTON_Y;
    
    public GamepadButton BUTTON_START;
    public GamepadButton BUTTON_SELECT;

    public GamepadButton TRIGGER_RIGHT;         //R2
    public GamepadButton TRIGGER_LEFT;          //L2
    
    public GamepadButton SHOULDER_RIGHT;        //R1
    public GamepadButton SHOULDER_LEFT;         //L1

    public GamepadEmulatedButton DIRECTION_FORWARD;
    public GamepadEmulatedButton DIRECTION_BACKWARD;
    public GamepadEmulatedButton DIRECTION_RIGHT;
    public GamepadEmulatedButton DIRECTION_LEFT;
    
    public GamepadButton THUMBSTICK_RIGHT;      //R3
    public GamepadButton THUMBSTICK_LEFT;       //L3
    
    public GamepadButton DPAD_UP;
    public GamepadButton DPAD_RIGHT;
    public GamepadButton DPAD_DOWN;
    public GamepadButton DPAD_LEFT;

    public GamepadMap() {
        BUTTON_A = new GamepadButton();
        BUTTON_B = new GamepadButton();
        BUTTON_X = new GamepadButton();
        BUTTON_Y = new GamepadButton();
        BUTTON_START = new GamepadButton();
        BUTTON_SELECT = new GamepadButton();
        TRIGGER_RIGHT = new GamepadButton();
        TRIGGER_LEFT = new GamepadButton();
        SHOULDER_RIGHT = new GamepadButton();
        SHOULDER_LEFT = new GamepadButton();
        DIRECTION_FORWARD = new GamepadEmulatedButton();
        DIRECTION_BACKWARD = new GamepadEmulatedButton();
        DIRECTION_RIGHT = new GamepadEmulatedButton();
        DIRECTION_LEFT = new GamepadEmulatedButton();
        THUMBSTICK_RIGHT = new GamepadButton();
        THUMBSTICK_LEFT = new GamepadButton();
        DPAD_UP = new GamepadButton();
        DPAD_RIGHT = new GamepadButton();
        DPAD_DOWN = new GamepadButton();
        DPAD_LEFT = new GamepadButton();
    }

    /*
     * Sets all buttons to a not pressed state, sending an input if needed
     */
    public void resetPressedState(){
        BUTTON_A.resetButtonState();
        BUTTON_B.resetButtonState();
        BUTTON_X.resetButtonState();
        BUTTON_Y.resetButtonState();

        BUTTON_START.resetButtonState();
        BUTTON_SELECT.resetButtonState();

        TRIGGER_LEFT.resetButtonState();
        TRIGGER_RIGHT.resetButtonState();

        SHOULDER_LEFT.resetButtonState();
        SHOULDER_RIGHT.resetButtonState();

        THUMBSTICK_LEFT.resetButtonState();
        THUMBSTICK_RIGHT.resetButtonState();

        DPAD_UP.resetButtonState();
        DPAD_RIGHT.resetButtonState();
        DPAD_DOWN.resetButtonState();
        DPAD_LEFT.resetButtonState();

    }

    /*
     * Returns a pre-done mapping used when the mouse is grabbed by the game.
     */
    public static GamepadMap getDefaultGameMap(){
        GamepadMap gameMap = GamepadMap.createEmptyMap();

        gameMap.BUTTON_A.keycodes[0] = LwjglGlfwKeycode.GLFW_KEY_SPACE;
        gameMap.BUTTON_B.keycodes[0] = LwjglGlfwKeycode.GLFW_KEY_Q;
        gameMap.BUTTON_X.keycodes[0] = LwjglGlfwKeycode.GLFW_KEY_E;
        gameMap.BUTTON_Y.keycodes[0] = LwjglGlfwKeycode.GLFW_KEY_F;

        gameMap.DIRECTION_FORWARD.keycodes[0] = LwjglGlfwKeycode.GLFW_KEY_W;
        gameMap.DIRECTION_BACKWARD.keycodes[0] = LwjglGlfwKeycode.GLFW_KEY_S;
        gameMap.DIRECTION_RIGHT.keycodes[0] = LwjglGlfwKeycode.GLFW_KEY_D;
        gameMap.DIRECTION_LEFT.keycodes[0] = LwjglGlfwKeycode.GLFW_KEY_A;

        gameMap.DPAD_UP.keycodes[0] = LwjglGlfwKeycode.GLFW_KEY_LEFT_SHIFT;
        gameMap.DPAD_DOWN.keycodes[0] = LwjglGlfwKeycode.GLFW_KEY_O;    //For mods ?
        gameMap.DPAD_RIGHT.keycodes[0] = LwjglGlfwKeycode.GLFW_KEY_K;   //For mods ?
        gameMap.DPAD_LEFT.keycodes[0] = LwjglGlfwKeycode.GLFW_KEY_J;    //For mods ?

        gameMap.SHOULDER_LEFT.keycodes[0] = GamepadMap.MOUSE_SCROLL_UP;
        gameMap.SHOULDER_RIGHT.keycodes[0] = GamepadMap.MOUSE_SCROLL_DOWN;

        gameMap.TRIGGER_LEFT.keycodes[0] = GamepadMap.MOUSE_RIGHT;
        gameMap.TRIGGER_RIGHT.keycodes[0] = GamepadMap.MOUSE_LEFT;

        gameMap.THUMBSTICK_LEFT.keycodes[0] = LwjglGlfwKeycode.GLFW_KEY_LEFT_CONTROL;
        gameMap.THUMBSTICK_RIGHT.keycodes[0] = LwjglGlfwKeycode.GLFW_KEY_LEFT_SHIFT;
        gameMap.THUMBSTICK_RIGHT.isToggleable = true;

        gameMap.BUTTON_START.keycodes[0] = LwjglGlfwKeycode.GLFW_KEY_ESCAPE;
        gameMap.BUTTON_SELECT.keycodes[0] = LwjglGlfwKeycode.GLFW_KEY_TAB;

        return gameMap;
    }

    /*
     * Returns a pre-done mapping used when the mouse is NOT grabbed by the game.
     */
    public static GamepadMap getDefaultMenuMap(){
        GamepadMap menuMap = GamepadMap.createEmptyMap();

        menuMap.BUTTON_A.keycodes[0] = GamepadMap.MOUSE_LEFT;
        menuMap.BUTTON_B.keycodes[0] = LwjglGlfwKeycode.GLFW_KEY_ESCAPE;
        menuMap.BUTTON_X.keycodes[0] = GamepadMap.MOUSE_RIGHT;
        {
            short[] keycodes = menuMap.BUTTON_Y.keycodes;
            keycodes[0] = LwjglGlfwKeycode.GLFW_KEY_LEFT_SHIFT;
            keycodes[1] = GamepadMap.MOUSE_RIGHT;
        }

        {
            short[] keycodes = menuMap.DIRECTION_FORWARD.keycodes;
            keycodes[0] = keycodes[1] = keycodes[2] = keycodes[3] = GamepadMap.MOUSE_SCROLL_UP;
        }
        {
            short[] keycodes = menuMap.DIRECTION_BACKWARD.keycodes;
            keycodes[0] = keycodes[1] = keycodes[2] = keycodes[3] = GamepadMap.MOUSE_SCROLL_DOWN;
        }

        menuMap.DPAD_DOWN.keycodes[0] = LwjglGlfwKeycode.GLFW_KEY_O; //For mods ?
        menuMap.DPAD_RIGHT.keycodes[0] = LwjglGlfwKeycode.GLFW_KEY_K; //For mods ?
        menuMap.DPAD_LEFT.keycodes[0] = LwjglGlfwKeycode.GLFW_KEY_J; //For mods ?

        menuMap.SHOULDER_LEFT.keycodes[0] = GamepadMap.MOUSE_SCROLL_UP;
        menuMap.SHOULDER_RIGHT.keycodes[0] = GamepadMap.MOUSE_SCROLL_DOWN;

        menuMap.BUTTON_SELECT.keycodes[0] = LwjglGlfwKeycode.GLFW_KEY_ESCAPE;

        return menuMap;
    }

    /*
     * Returns all GamepadEmulatedButtons of the controller key map.
     */
    public GamepadEmulatedButton[] getButtons(){
        return new GamepadEmulatedButton[]{ BUTTON_A, BUTTON_B, BUTTON_X, BUTTON_Y,
                                    BUTTON_SELECT, BUTTON_START,
                                    TRIGGER_LEFT, TRIGGER_RIGHT,
                                    SHOULDER_LEFT, SHOULDER_RIGHT,
                                    THUMBSTICK_LEFT, THUMBSTICK_RIGHT,
                                    DPAD_UP, DPAD_RIGHT, DPAD_DOWN, DPAD_LEFT,
                                    DIRECTION_FORWARD, DIRECTION_BACKWARD,
                                    DIRECTION_LEFT, DIRECTION_RIGHT};
    }

    /*
     * Returns an pre-initialized GamepadMap with only empty keycodes
     */
    @SuppressWarnings("unused") public static GamepadMap createEmptyMap(){
        GamepadMap emptyMap = new GamepadMap();
        for(GamepadEmulatedButton button : emptyMap.getButtons())
            button.keycodes = new short[] {UNSPECIFIED, UNSPECIFIED, UNSPECIFIED, UNSPECIFIED};
        return emptyMap;
    }

    public static String[] getSpecialKeycodeNames() {
        return new String[] {"UNSPECIFIED", "MOUSE_RIGHT", "MOUSE_MIDDLE", "MOUSE_LEFT", "SCROLL_UP", "SCROLL_DOWN"};
    }
}
