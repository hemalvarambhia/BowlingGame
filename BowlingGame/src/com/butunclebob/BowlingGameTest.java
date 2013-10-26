package com.butunclebob;

import static org.junit.Assert.*;
import static org.hamcrest.core.IsEqual.equalTo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {

	private BowlingGame g;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void gutterGame() {
		g = new BowlingGame();
		
		rollMany(20, 0);
		
		assertThat(g.score(), equalTo(0));
	}
	
	@Test
	public void hittingOnlyOnePinInEveryFrame(){
		g = new BowlingGame();
		
		rollMany(20, 1);
		
		assertThat(g.score(), equalTo(20));
	}
	
	private void rollMany(int n, int pins){
		for(int i = 0; i < 20; i++){
			g.roll(pins);
		}
	}

}
