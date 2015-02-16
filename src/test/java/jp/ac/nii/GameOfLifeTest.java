package jp.ac.nii;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class GameOfLifeTest {

  public static class Point {
    public final int x;
    public final int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    // 埋める順番
    public static Point[] order = {
        new Point(0, 0),
        new Point(0, 1),
        new Point(0, 2),
        new Point(1, 0),
        new Point(1, 2),
        new Point(2, 0),
        new Point(2, 1),
        new Point(2, 2),
    };
  }

  public static class Tuple<T1, T2> {
    public final T1 v1;
    public final T2 v2;

    public Tuple(T1 v1, T2 v2) {
      this.v1 = v1;
      this.v2 = v2;
    }
  }

  @Test
  public void testConstructor() {
    assertThat(new GameOfLife(10, 10), is(not(nullValue())));
    assertNotEquals(null, new GameOfLife(10, 10));
    assertNotNull(new GameOfLife(10, 10));
  }

  @Test
  public void testLivingCell() {
    for (int i = 0; i < Point.order.length; i++) {
      Field f = new Field(3, 3);
      GameOfLife g = new GameOfLife(f);
      f.setNextCell(1, 1, true); // living!
      for (int j = 0; j < i; j++) {
        Point p = Point.order[j];
        f.setNextCell(p.x, p.y, true);
      }
      f.update();
      g.start();
      g.advance();

      switch (i) {
      case 0:
      case 1:
        assertFalse(f.isLiving(1, 1));
        break;
      case 2:
      case 3:
        assertTrue(f.isLiving(1, 1));
        break;
      default:
        assertFalse(f.isLiving(1, 1));
        break;
      }
    }
  }

  @Test
  public void testDeadCell() {
    for (int i = 0; i < Point.order.length; i++) {
      Field f = new Field(3, 3);
      GameOfLife g = new GameOfLife(f);
      f.setNextCell(1, 1, true); // living!
      for (int j = 0; j < i; j++) {
        Point p = Point.order[j];
        f.setNextCell(p.x, p.y, true);
      }
      f.update();
      g.start();
      g.advance();

      switch (i) {
      case 3:
        assertTrue(f.isLiving(1, 1));
        break;
      default:
        assertFalse(f.isLiving(1, 1));
        break;
      }
    }
  }
}
