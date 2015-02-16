package jp.ac.nii;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class GameOfLifeTest {

  @Test
  public void testConstructor() {
    assertThat(new GameOfLife(10, 10), is(not(nullValue())));
    assertNotEquals(null, new GameOfLife(10, 10));
    assertNotNull(new GameOfLife(10, 10));
  }

  @Test
  public void testDeadToAlive() {
    Field field = new Field(2, 2);
    field.clear();
    field.setNextCell(0, 1, true);
    field.setNextCell(1, 1, true);
    field.setNextCell(1, 0, true);
    field.update();
    GameOfLife game = new GameOfLife(field);
    game.start();
    game.advance();
    assertTrue(field.isLiving(0, 0));
  }
  
}
