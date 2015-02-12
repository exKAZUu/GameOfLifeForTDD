package jp.ac.nii;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class GameOfLifeTest {

	private GameOfLife _gol;
	private Field _field;

	@Before
	public void setup() {
		_gol = new GameOfLife(3, 3);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 2) {
					_gol.getField().initializeCell(i, j, false);
				} else {
					_gol.getField().initializeCell(i, j, true);
				}
			}
		}
		_gol.getField().initializeCell(2, 1, false);
		_gol.getField().initializeCell(2, 2, true);
		
		_gol.advance();
	}

	@Test
	public void testFieldHeight() {
		assertThat(_gol.getField().getHeight(), is(3));
	}

	@Test
	public void testFieldWidth() {
		assertThat(_gol.getField().getWidth(), is(3));
	}

	@Test
	public void testActive() {
		assertThat(_gol.isActive(), is(false));
		_gol.start();
		assertThat(_gol.isActive(), is(true));
		_gol.stop();
		assertThat(_gol.isActive(), is(false));
	}

	@Test
	public void testDead() {
		assertThat(_gol.getField().isLiving(1, 0), is(false));
		assertThat(_gol.getField().isLiving(2, 2), is(false));
	}
}
