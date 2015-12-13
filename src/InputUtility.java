
public class InputUtility {
	public static int mouseX, mouseY;
	public static boolean mouseClick = false;
	private static boolean keyPressed[] = new boolean[256];
	private static boolean keyTriggered[] = new boolean[256];
	public static boolean getKeyPressed(int key) {
		if (key < 0 || key >= 256)
			return false;
		return keyPressed[key];
	}

	public static void setKeyPressed(int key, boolean pressed) {
		if (key < 0 || key >= 256)
			return;
		InputUtility.keyPressed[key] = pressed;
	}
	public static void setKeyTriggered(int key, boolean pressed){
		if (key < 0 || key >= 256)
			return;
		InputUtility.keyTriggered[key] = pressed;
	}
	public static boolean getKeyTriggered(int key){
		return InputUtility.keyTriggered[key];
	}
	public static void postUpdate(){
		for(int i =0;i<256;i++) InputUtility.keyTriggered[i] = false;
	}
}
