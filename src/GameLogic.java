import java.util.ArrayList;

public class GameLogic {
	private static ArrayList<Monster> monsters;
	private static ArrayList<Raze> razes;
	private static Player player;
	private static int tick;
	private static int creationDelay;
	private static int stageTick;
	private static boolean isPause;
	private static boolean isNyan, isDora;
	private static int nyanCount, doraCount;
	private static boolean isOver;
	public GameLogic() {
		razes = new ArrayList<>();
		player = new Player();
		monsters = new ArrayList<>();
		tick = 50;
		creationDelay = 100;
		isOver = false;
		stageTick = 0;
		isDora = false;
		doraCount = 0;
		isNyan = false;
		nyanCount = 0;
	}

	public static boolean isNyan() {
		return isNyan;
	}

	public static void setNyan(boolean isNyan) {
		GameLogic.isNyan = isNyan;
	}

	public static boolean isDora() {
		return isDora;
	}

	public static void setDora(boolean isDora) {
		GameLogic.isDora = isDora;
	}

	public static boolean isPause() {
		return isPause;
	}

	public static void setPause(boolean isPause) {
		GameLogic.isPause = isPause;
	}

	public static int getTick() {
		return tick;
	}

	public static void setTick(int tick) {
		GameLogic.tick = tick;
	}

	public static ArrayList<Monster> getMonsters() {
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

	

	public static ArrayList<Raze> getRazes() {
		return razes;
	}

	public static void setRazes(ArrayList<Raze> razes) {
		GameLogic.razes = razes;
	}

	public void logicUpdate() {
		if (isOver == true || isPause) {
			return;
		}
		createMonster();

		for (int i = monsters.size() - 1; i >= 0; i--) {
			Monster m = monsters.get(i);
			if (m.isDead()) {
				monsters.remove(m);
			}
		}
		for (int i = razes.size() - 1; i >= 0; i--) {
			if (!razes.get(i).isVisible()) {
				razes.remove(i);
			}
		}
		for (int i = monsters.size() - 1; i >= 0; i--) {
			Monster m = monsters.get(i);
			for (int j = 0; j < razes.size(); j++) {
				if (m.isRazeHit(razes.get(j)) && !m.isDead())
					m.hit();
			}
			if (!m.isDead() && m.isInSamePosition(player)) {
				if (player.isImmortal()) {
					player.increaseScore();
					player.increaseSoul();
				} else {
					new SoundThread("pain").start();
					player.decreaseLife();
				}
				m.setDead(true);
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

	public static int getNyanCount() {
		return nyanCount;
	}

	public static void setNyanCount(int nyanCount) {
		GameLogic.nyanCount = nyanCount;
	}

	public static int getDoraCount() {
		return doraCount;
	}

	public static void setDoraCount(int doraCount) {
		GameLogic.doraCount = doraCount;
	}

	public void createMonster() {
		if (stageTick == 300) {
			stageTick = 0;
			if (creationDelay < 60)
				creationDelay = 40;
			else
				creationDelay -= 20;
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
