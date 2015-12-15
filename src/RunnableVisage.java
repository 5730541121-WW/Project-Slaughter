
public class RunnableVisage implements Runnable {

	Visage visage;

	public RunnableVisage(Visage visage) {
		this.visage = visage;
	}

	@Override
	public void run() {
		while (true) {
			if (GameLogic.isOver())
				break;
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {

			}
			synchronized (GameLogic.getVisage()) {
				if (GameLogic.isPause())
					try {
						visage.wait();
					} catch (InterruptedException e) {

					}
			}
			visage.increaseTick();
			visage.setX(visage.getX() - 5);
			if (visage.getX() < -120)
				visage.setX(1400);
			//System.out.println(visage.getX());
		}

	}

}
