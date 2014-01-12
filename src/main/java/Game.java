/**
 * Created with IntelliJ IDEA.
 * User: hongseongmin
 * Date: 2014. 1. 10.
 * Time: 오후 5:50
 * To change this template use File | Settings | File Templates.
 */
public class Game {
	private int[] rolls = new int[21];
	private int currentRoll = 0;


	public void roll(int pins) {
		rolls[currentRoll++] = pins;
	}

	public int getScore() {
		int score = 0;
		int firstRollInFrame = 0;

		for (int frame = 0; frame < 10; frame++) {
			if (isSpare(firstRollInFrame)) {
				score += 10 + nextBallForSpare(firstRollInFrame);
				firstRollInFrame += 2;
			} else if (isStrike(firstRollInFrame)){
				score += 10 + nextBallsForStrike(firstRollInFrame);
				firstRollInFrame += 1;
			} else {
				score += nextBallsForFrames(firstRollInFrame);
				firstRollInFrame += 2;
			}
		}

		return score;
	}

	private int nextBallsForFrames(int firstRollInFrame) {
		return rolls[firstRollInFrame] + rolls[firstRollInFrame + 1];
	}

	private int nextBallsForStrike(int firstRollInFrame) {
		return rolls[firstRollInFrame + 1] + rolls[firstRollInFrame + 2];
	}

	private int nextBallForSpare(int firstRollInFrame) {
		return rolls[firstRollInFrame + 2];
	}

	private boolean isStrike(int firstRollInFrame) {
		return rolls[firstRollInFrame] == 10;
	}

	private boolean isSpare(int firstRollInFrame) {
		return rolls[firstRollInFrame] + rolls[firstRollInFrame + 1] == 10;
	}
}
