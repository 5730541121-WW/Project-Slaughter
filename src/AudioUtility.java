import java.applet.Applet;
import java.applet.AudioClip;


public class AudioUtility {
		
	private static AudioClip acStart;
	private static AudioClip acRaze;
	private static AudioClip acRequiem;
	private static AudioClip acHeal;
	private static AudioClip acImmortal;
	private static AudioClip acFreeze;
	private static AudioClip acDeath;
	private static AudioClip acPain;
	static{
		ClassLoader loader = AudioUtility.class.getClassLoader();
		acRaze = Applet.newAudioClip(loader.getResource("res/SOUND/Shadowraze.wav"));
		acStart = Applet.newAudioClip(loader.getResource("res/SOUND/Shadow_Fiend.wav"));
		acRequiem = Applet.newAudioClip(loader.getResource("res/SOUND/ROS.wav"));
		acHeal = Applet.newAudioClip(loader.getResource("res/SOUND/Raah.wav"));
		acImmortal = Applet.newAudioClip(loader.getResource("res/SOUND/nyan.wav"));
		acFreeze = Applet.newAudioClip(loader.getResource("res/SOUND/dora.wav"));
		acDeath = Applet.newAudioClip(loader.getResource("res/SOUND/death.wav"));
		acPain = Applet.newAudioClip(loader.getResource("res/SOUND/pain.wav"));
	}
	
	public static void playSound(String identifier){
		/* fill code */
		if( identifier.equalsIgnoreCase("ros") ){
			acRequiem.play();
		}
		else if(identifier.equalsIgnoreCase("raze")){
			acRaze.play();
		}
		else if(identifier.equalsIgnoreCase("heal")){
			acHeal.play();
		}
		else if(identifier.equalsIgnoreCase("immortal")){
			acImmortal.play();
		}
		else if(identifier.equalsIgnoreCase("freeze")){
			acFreeze.play();
		}
		else if(identifier.equalsIgnoreCase("death")){
			acDeath.play();
		}
		else if(identifier.equalsIgnoreCase("pain")){
			acPain.play();
		}
		else {
			acStart.play();
		}
	}
}
