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
		g = new BowlingGame();	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void gutterGame() {
		rollMany(20, 0);
		
		assertThat(g.score(), equalTo(0));
	}
	
	@Test
	public void hittingOnlyOnePinInEveryFrame(){
		rollMany(20, 1);
		
		assertThat(g.score(), equalTo(20));
	}
	
	@Test
	public void gettingASpare(){
		rollASpare();
		g.roll(3);
		rollMany(17, 0);
		
		assertThat(g.score(), equalTo(16));
	}
	
	@Test
	public void gettingAStrike(){
		g.roll(10);
		g.roll(3);
		g.roll(6);
		rollMany(17, 0);
		assertThat(g.score(), equalTo(28));
	}
	
	private void rollMany(int n, int pins){
		for(int i = 0; i < n; i++){
			g.roll(pins);
		}
	}
	
	private void rollASpare(){
		g.roll(5);
		g.roll(5);
	}

}
