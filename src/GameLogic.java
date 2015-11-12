import java.util.ArrayList;

public class GameLogic {
	private ArrayList<Monster> monsters = new ArrayList<>();
	private static Player player;
	private int tick;
	private int stage;
	private static boolean isOver;
	public ArrayList<Monster> getMonsters() {
		return monsters;
	}
	public void setMonsters(ArrayList<Monster> monsters) {
		this.monsters = monsters;
	}
	public static Player getPlayer() {
		return player;
	}
	public static void setPlayer(Player player) {
		GameLogic.player = player;
	}
	public static boolean isOver() {
		return isOver;
	}
	public static void setOver(boolean isOver) {
		GameLogic.isOver = isOver;
	}
	private int monsterCount;
	public GameLogic(){
		monsters = null;
		player = new Player();
		tick = 0;
		stage = 1;
		monsterCount=0;
		isOver = false;
	}
	public void logicUpdate(){
		if(isOver == true)
			return;
		for(Monster m : monsters){
			if(m.isDead())
				monsters.remove(m);
			else{
				m.update();
				if(m.getX()-player.getX()<=5 || player.getX()-m.getX()<=5){
					m.hit();
					monsters.remove(m);
				}
			}
		}
		if(stage == 1){
			if(tick == 100){
				String word="";
				Monster newMonster = new Monster(word);
				monsters.add(newMonster);
				tick = 0;
				monsterCount++;
				if(monsterCount == 10) stage++;
			}
			else tick++;
		}
		else if(stage == 2){
			if(tick == 70){
				String word="";
				Monster newMonster = new Monster(word);
				monsters.add(newMonster);
				tick =0;
				if(monsterCount == 25) stage++;
			}
			else tick++;
		}
		else {
			if(tick%40 ==0){
				String word="";
				Monster newMonster = new Monster(word);
				monsters.add(newMonster);
			}
			else tick++;
		}
	}
}
