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
}
