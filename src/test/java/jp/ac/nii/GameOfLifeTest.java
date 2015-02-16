package jp.ac.nii;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GameOfLifeTest {

  @Test
  public void testConstructor() {
    assertThat(new GameOfLife(10, 10), is(not(nullValue())));
    assertNotEquals(null, new GameOfLife(10, 10));
    assertNotNull(new GameOfLife(10, 10));
  }

  private void startGame(GameOfLife game) {
    game.start();
    game.advance();
    game.stop();
  }

  @Test
  public void testBirth() {
    GameOfLife game = new GameOfLife(3, 3);
    Field f = game.getField();
    f.clear();
    f.initializeCell(0, 0, true);
    f.initializeCell(1, 0, true);
    f.initializeCell(0, 1, true);

    startGame(game);

    boolean[] res = new boolean[9];
    for (int i = 0; i < 9; i++) {
      res[i] = f.isLiving(i%3, i/3);
    }
    assertArrayEquals(new boolean[]{true, true, false,
                                    true, true, false,
                                    false, false, false},
                      res);
  }

  @Test
  public void testLiving() {
    GameOfLife game = new GameOfLife(4, 4);
    Field f = game.getField();
    f.clear();
    f.initializeCell(1, 1, true);
    f.initializeCell(2, 1, true);
    f.initializeCell(1, 2, true);
    f.initializeCell(2, 2, true);

    startGame(game);

    boolean[] res = new boolean[16];
    for (int i = 0; i < 16; i++) {
      res[i] = f.isLiving(i%4, i/4);
    }
    assertArrayEquals(new boolean[]{false, false, false, false,
                                    false, true, true, false,
                                    false, true, true, false,
                                    false, false, false, false},
                      res);

  }

  @Test
  public void testDepopulation() {
    GameOfLife game = new GameOfLife(3, 3);
    Field f = game.getField();
    f.clear();
    f.initializeCell(1, 1, true);
    f.initializeCell(2, 1, true);

    startGame(game);

    boolean[] res = new boolean[9];
    for (int i = 0; i < 9; i++) {
      res[i] = f.isLiving(i%3, i/3);
    }
    assertArrayEquals(new boolean[9], res);
  }

  @Test
  public void testOverpopulation() {
    GameOfLife game = new GameOfLife(3, 3);
    Field f = game.getField();
    f.clear();
    f.initializeCell(0, 0, true);
    f.initializeCell(1, 0, true);
    f.initializeCell(2, 0, true);
    f.initializeCell(0, 1, true);
    f.initializeCell(1, 1, true);

    startGame(game);

    boolean[] res = new boolean[9];
    for (int i = 0; i < 9; i++) {
      res[i] = f.isLiving(i%3, i/3);
    }
    assertArrayEquals(new boolean[]{true, false, true,
                                    true, false, true,
                                    false, false, false},
                      res);
  }
}
