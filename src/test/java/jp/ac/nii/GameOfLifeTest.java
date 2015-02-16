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
  public void testAdvance() {
    Field field = new Field(3, 3);
    for(int i = 0; i < 5; i++)
      for(int j = 0; j < 5; j++)
        field.initializeCell(i, j, (i + j) % 2 == 0);
    GameOfLife gameOfLife = new GameOfLife(field);
    gameOfLife.advance();
    field = gameOfLife.getField();
    assertTrue(field.isLiving(1, 0));
    assertTrue(field.isLiving(0, 1));
    assertTrue(field.isLiving(1, 2));
    assertTrue(field.isLiving(2, 1));
    assertFalse(field.isLiving(0, 0));
    assertFalse(field.isLiving(0, 2));
    assertFalse(field.isLiving(1, 1));
    assertFalse(field.isLiving(2, 0));
    assertFalse(field.isLiving(2, 2));
  }
}
