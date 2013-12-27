package jp.ac.nii;

import java.awt.Point;
import java.util.ArrayList;

public class GameOfLife {
  private Map _map;
  private static final ArrayList<Point> _deltas;

  static{
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
    _map = new Map(width, height);
    
  }

  public Map getMap() {
    return _map;
  }

  public void advance() {
  }

  public boolean birth(int x, int y, int count) {
    if (count == 3) {
      _map.setLiving(x, y, true);
      return true;
    }
    return false;
  }

  public void live(int x, int y) {
//    if (count == 2 || count == 3) {
//      _map.setLiving(x, y, true);
//      return true;
//    }
//    return false;
  }

  public void depopulate(int x, int y) {
  }

  public void congest(int x, int y) {
  }
}
