import javax.swing.JOptionPane;

import com.sun.glass.events.KeyEvent;

import sun.security.x509.IssuingDistributionPointExtension;

public class RunThread {

	public static int RunGame() {
		GameLogic logic = new GameLogic();
		AudioUtility.playBG();
		new SoundThread("start").start();
		try {
			while (true) {
				Thread.sleep(50);
				if (InputUtility.getKeyTriggered(KeyEvent.VK_ENTER))
					GameLogic.setPause(!GameLogic.isPause());
				Main.screen.requestFocus();
				synchronized (logic) {
					if (logic.isOver()) {
						AudioUtility.stopBG();
						new SoundThread("death").start();
						HighScoreUtility.recordHighScore(logic.getPlayer().getScore());
						int input = HighScoreUtility.postMessage();
						return input;
					}
					logic.logicUpdate();
					Main.f.repaint();
					if (logic.isDora()) {
						if (logic.getDoraCount() == 175) {
							logic.setDora(false);
							logic.setDoraCount(0);
							AudioUtility.playBG();
						}
						logic.setDoraCount(logic.getDoraCount() + 1);
					} else if (logic.isNyan()) {
						if (logic.getNyanCount() == 100) {
							logic.setNyan(false);
							logic.setNyanCount(0);
							AudioUtility.playBG();
						}
						logic.setNyanCount(logic.getNyanCount() + 1);
					}
					Main.north.score.setText("SCORE : " + logic.getPlayer().getScore());
					Main.north.soul.setText("SOUL : " + logic.getPlayer().getSoulCount());
					Main.f.validate();
					InputUtility.postUpdate();
				}
			}
		} catch (Exception e) {
		}
		return 1;
	}
}
