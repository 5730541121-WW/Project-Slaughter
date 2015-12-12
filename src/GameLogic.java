import java.util.ArrayList;

public class GameLogic {
	private static ArrayList<Monster> monsters = new ArrayList<>();
	private static ArrayList<Raze> razes = new ArrayList<>();
	private static Player player = new Player();
	private static int tick;
	private int stage;
	public static int getTick() {
		return tick;
	}

	public static void setTick(int tick) {
		GameLogic.tick = tick;
	}

	private static boolean isOver;

	public ArrayList<Monster> getMonsters() {
		return monsters;
	}

	public static void setMonsters(ArrayList<Monster> monsters) {
		GameLogic.monsters = monsters;
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
	private int creationDelay = 100;
	private int stageTick;

	public GameLogic() {
		tick = 50;
		stage = 1;
		monsterCount = 0;
		isOver = false;
		stageTick = 0;
		AudioUtility.playSound("start");
	}

	public static ArrayList<Raze> getRazes() {
		return razes;
	}

	public static void setRazes(ArrayList<Raze> razes) {
		GameLogic.razes = razes;
	}

	public void logicUpdate() {
		if (isOver == true) {
			// player.drawDead();
			return;
		}
		createMonster();
		
		for (int i = monsters.size()-1; i >= 0; i--) {
			Monster m = monsters.get(i);
			if (m.isDead()) {
				// m.drawDead();
				monsters.remove(m);
			}
		}		
		for (int i = razes.size()-1; i >= 0; i--) {
			//System.out.println(razes.get(i).isVisible());
			if (!razes.get(i).isVisible()) {
				razes.remove(i);
			}
		}
		for (int i = monsters.size()-1; i >= 0; i--) {
			Monster m = monsters.get(i);
			for(int j=0;j<razes.size();j++){
				if( m.isRazeHit(razes.get(j))&& !m.isDead())
					m.hit();
			}
			if(!m.isDead() && m.isInSamePosition(player)){
				m.setDead(true);
				player.decreaseLife();
			}
		}	
		player.update();
		for (Monster m : monsters) {
			m.update();
		}
		for (Raze r : razes) {
			r.update();
		}
	}

	public void createMonster() {
		if(stageTick == 300) {
			stageTick = 0;
			if(creationDelay<60)
				creationDelay=40;
			else 
				creationDelay -=20;
		}
		if (tick < creationDelay) {
			tick++;
			stageTick++;
			return;
		}
		tick = 0;
		monsters.add(new Monster());
	}
}
