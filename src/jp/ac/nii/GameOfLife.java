package jp.ac.nii;

import java.awt.Point;
import java.util.ArrayList;

public class GameOfLife {
  private Field _field;
  private boolean _active;

  private static final ArrayList<Point> _deltas;
  static {
    _deltas = new ArrayList<Point>();
    _deltas.add(new Point(-1, -1));
    _deltas.add(new Point(1, 1));
    _deltas.add(new Point(-1, 1));
    _deltas.add(new Point(1, -1));
    _deltas.add(new Point(-1, 0));
    _deltas.add(new Point(1, 0));
    _deltas.add(new Point(0, -1));
    _deltas.add(new Point(0, 1));
  }

  public GameOfLife(int width, int height) {
    _field = new Field(width, height);
    _active = false;
  }

  public Field getField() {
    return _field;
  }

  public void advance() {
    if (!_active) {
      return;
    }
    for (int x = 0; x < _field.getWidth(); x++) {
      for (int y = 0; y < _field.getHeight(); y++) {
        if (_field.isLiving(x, y)) {
          _field.setNextCell(x, y, live(x, y));
        } else {
          _field.setNextCell(x, y, birth(x, y));
        }
      }
    }
    _field.update();
  }

  public int countLiving(int x, int y) {
    int count = 0;
    for (Point delta : _deltas) {
      if (_field.isLiving(x + delta.x, y + delta.y)) {
        count++;
      }
    }
    return count;
  }

  public boolean birth(int x, int y) {
    int count = countLiving(x, y);
    if (count == 3) {
      return true;
    }
    return false;
  }

  public boolean live(int x, int y) {
    int count = countLiving(x, y);
    if (count == 2 || count == 3) {
      return true;
    }
    return false;
  }

  public boolean isActive() {
    return _active;
  }

  public void start() {
    _active = true;
  }

  public void stop() {
    _active = false;
  }

  public void clear() {
    _active = false;
    _field.clear();
  }
}
