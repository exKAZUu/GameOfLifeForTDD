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

  @Test
  public void testBirth() {
    GameOfLife game = new GameOfLife(3, 3);
    Field f = game.getField();
    f.clear();
    f.initializeCell(0, 0, true);
    f.initializeCell(1, 0, true);
    f.initializeCell(0, 1, true);
    f.update();

    boolean[] res = new boolean[9];
    for (int i = 0; i < 9; i++) {
      res[i] = f.isLiving(i/3, i%3);
    }
    assertArrayEquals(res,
                      new boolean[]{true, true, false, true, true, false, false, false, false});
  }
}
