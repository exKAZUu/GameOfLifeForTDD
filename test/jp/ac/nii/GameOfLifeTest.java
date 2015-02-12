package jp.ac.nii;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameOfLifeTest {

	private GameOfLife _gol;
	private Field _map;

	@Before
	public void before() {
		_gol = new GameOfLife(10, 10);
		_map = _gol.getField();
	}

	@Test
	public void failToBirth() {
		_gol.advance();
		assertEquals(_map.isLiving(0, 0), false);
	}

	@Test
	public void succeedToBirth() {
		_map.setNextCell(1, 1, true);
		_map.setNextCell(0, 1, true);
		_map.setNextCell(1, 0, true);
		_gol.advance();
		assertEquals(_map.isLiving(0, 0), true);
	}
}
