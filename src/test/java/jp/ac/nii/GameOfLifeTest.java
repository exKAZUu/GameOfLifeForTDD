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
    Field field = createField2x2(false, true, true, true);
    GameOfLife game = new GameOfLife(field);
    game.start();
    game.advance();
    assertTrue(field.isLiving(0, 0));
  }
  
  @Test
  public void testAliveToDead0() {
    Field field = createField2x2(false, false, false, true);
    GameOfLife game = new GameOfLife(field);
    game.start();
    game.advance();
    assertFalse(field.isLiving(1, 1));
  }
  
  @Test
  public void testAliveToDead1() {
    Field field = createField2x2(false, false, true, true);
    GameOfLife game = new GameOfLife(field);
    game.start();
    game.advance();
    assertFalse(field.isLiving(1, 1));
  }
  
  @Test
  public void testAliveToDead4() {
    Field field = new Field(3, 3);
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        field.setNextCell(i, j, true);
      }
    }
    field.setNextCell(0, 0, false);
    field.update();
    GameOfLife game = new GameOfLife(field);
    game.start();
    game.advance();
    assertTrue(field.isLiving(0, 0));
    assertFalse(field.isLiving(0, 1));
    assertTrue(field.isLiving(0, 2));
    assertFalse(field.isLiving(1, 1));
  }

  @Test
  public void testDeadToDead() {
    Field field = createField2x2(false, true, false, true);
    GameOfLife game = new GameOfLife(field);
    game.start();
    game.advance();
    assertFalse(field.isLiving(0, 0));
  }

  private Field createField2x2(boolean b00, boolean b01, boolean b10, boolean b11) {
    Field field = new Field(2, 2);
    field.setNextCell(0, 0, b00);
    field.setNextCell(0, 1, b01);
    field.setNextCell(1, 0, b10);
    field.setNextCell(1, 1, b11);
    field.update();
    return field;
  }
}
