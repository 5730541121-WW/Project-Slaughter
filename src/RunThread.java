import javax.swing.JOptionPane;

public class RunThread {

	public static int RunGame() {
		GameLogic logic = new GameLogic();
		try {
			
			while (true) {
				Thread.sleep(50);
				Main.screen.requestFocus();
				synchronized (logic) {
					if (logic.isOver()) {
						HighScoreUtility.recordHighScore(logic.getPlayer().getScore());
						int input =HighScoreUtility.displayTop10();
						return input;
						//System.exit(0);
					}
					logic.logicUpdate();
					Main.f.repaint();
					Main.north.score.setText("SCORE : " + logic.getPlayer().getScore());
					Main.north.soul.setText("SOUL : " + logic.getPlayer().getSoulCount());
					InputUtility.postUpdate();
				}
			}
		} catch (Exception e) {
		}
		return 1;
	}
}
