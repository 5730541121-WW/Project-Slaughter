
public class SoundThread extends Thread{
	private String word;
	public SoundThread(String word){
		super();
		this.word = word;
	}
	public void run(){
		AudioUtility.playSound(word);
	}
}
