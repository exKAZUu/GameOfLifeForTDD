package jp.ac.nii;

/**
 * ライフゲームのルールを表現するクラスです。
 * advanceメソッドのみ変更して下さい。 
 * ただし、新たにメソッドを追加しても構いません。
 *
 * @author exKAZUu
 */
public class GameOfLife {
  private Field _field;
  private boolean _active;

  public GameOfLife(int width, int height) {
    this(new Field(width, height));
  }

  public GameOfLife(Field field) {
    _field = field;
    _active = false;
  }

  public Field getField() {
    return _field;
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

  public void advance() {
    if (!_active) {
      return;
    }
    
    // ここに処理を追記して完成させよう
    int w = _field.getWidth();
    int h = _field.getHeight();
    for (int y = 0; y < h; y++) {
      for (int x = 0; x < w; x++) {
        boolean isLiving = _field.isLiving(x, y);
        int c = countLivingNeighborCells(x, y);
        if (!isLiving && c == 3)
          birth(x, y);
        if (isLiving && c >= 2 && c <= 3)
          living(x, y);
      }
    }

    _field.update();
  }
  
  // メソッドを適宜追加しよう
  public void birth(int x, int y) {
    _field.setNextCell(x, y, true);
  }

  public void living(int x, int y) {
    _field.setNextCell(x, y, true);
  }

  public int countLivingNeighborCells(int x, int y) {
    int c = 0;
    for (int _y = y - 1; _y <= y + 1; _y++) {
      if (_y < 0 || _y >= _field.getHeight())
        continue;
      for (int _x = x - 1; _x <= x + 1; _x++) {
        if (_x < 0 || _x >= _field.getWidth())
          continue;

        if (_field.isLiving(_x, _y))
          c++;
      }
    }
    return c;
  }
}
