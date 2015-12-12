import java.applet.Applet;
import java.applet.AudioClip;


public class AudioUtility {
		
	private static AudioClip acStart;
	private static AudioClip acRaze;
	private static AudioClip acRequiem;
	static{
		ClassLoader loader = AudioUtility.class.getClassLoader();
		acRaze = Applet.newAudioClip(loader.getResource("res/SOUND/Shadowraze.wav"));
		acStart = Applet.newAudioClip(loader.getResource("res/SOUND/Shadow_Fiend.wav"));
		acRequiem = Applet.newAudioClip(loader.getResource("res/SOUND/ROS.wav"));
	}
	
	public static void playSound(String identifier){
		/* fill code */
		if( identifier.equalsIgnoreCase("ros") ){
			acRequiem.play();
		}
		else if(identifier.equalsIgnoreCase("raze")){
			acRaze.play();
		}
		else {
			acStart.play();
		}
	}
}
