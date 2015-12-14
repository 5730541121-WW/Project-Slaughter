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
	private static AudioClip title;
	private static AudioClip bgmusic;
	
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
		title = Applet.newAudioClip(loader.getResource("res/SOUND/title.wav"));
		bgmusic = Applet.newAudioClip(loader.getResource("res/SOUND/bgmusic.wav"));
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
	
	public static void playTitle(){		
		title.loop();		
	}
	
	public static void stopTitle(){
		title.stop();
	}
	
	public static void playBG(){		
		bgmusic.loop();		
	}
	
	public static void stopBG(){
		bgmusic.stop();
	}
}
