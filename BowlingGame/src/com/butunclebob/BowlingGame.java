package com.butunclebob;

public class BowlingGame {

	private int[] rolls = new int[20];
	private int roll = 0;
	
	public void roll(int pins) {
		rolls[roll++] = pins;
	}


	public int score() {
		int score = 0;
		int go = 0;
		for(int frame = 0; frame < 10; frame++){
			if(rolls[go] == 10){
				score += (10 + rolls[go + 1] + rolls[go + 2]);
				go++;
			}else {
				if(isASpare(go)){
					score += (10 + rolls[go + 2]);
				}else{
					score += (rolls[go] + rolls[go + 1]);
				}
				go += 2;
			}
		}
		
		return score;
	}
	
	private boolean isASpare(int go){
		return rolls[go] + rolls[go + 1] == 10;
	}

}
