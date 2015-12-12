import javax.swing.JOptionPane;

public class RunThread extends Thread {
	Thread prevThread;
	GameLogic logic;

	public RunThread(Thread prevThread) {
		super();
		this.prevThread = prevThread;
		logic = new GameLogic();
	}

	public void run() {
		try {
			if(prevThread!=null)prevThread.join();
			while (true) {
				Thread.sleep(50);
				Main.screen.requestFocus();
				synchronized (logic) {
					if (logic.isOver()) {
						HighScoreUtility.recordHighScore(logic.getPlayer().getScore());
						int input =HighScoreUtility.displayTop10();
						if(input == JOptionPane.YES_OPTION){
							Main.screen.isRestart = true;
							break;
						}
						else if( input == JOptionPane.CLOSED_OPTION || input ==JOptionPane.NO_OPTION) {
							System.exit(0);
						}
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
	}
}
