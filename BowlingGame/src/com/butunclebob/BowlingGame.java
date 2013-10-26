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
			if(gotAStrike(go)){
				score += (10 + strikeBonusFor(go));
				go++;
			}else {
				if(gotASpare(go)){
					score += (10 + spareBonusFor(go));
				}else{
					score += (rolls[go] + rolls[go + 1]);
				}
				go += 2;
			}
		}
		
		return score;
	}
	
	private boolean gotAStrike(int go){
		return rolls[go] == 10;
	}
	
	private int strikeBonusFor(int go){
		return rolls[go + 1] + rolls[go + 2];
	}
	
	private boolean gotASpare(int go){
		return rolls[go] + rolls[go + 1] == 10;
	}

	private int spareBonusFor(int go){
		return rolls[go + 2];
	}
	
}
