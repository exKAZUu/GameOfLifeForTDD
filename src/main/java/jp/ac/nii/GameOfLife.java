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
    int width = _field.getWidth();
    int height = _field.getHeight();
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        int c = countLivingNeighbours(x, y);
        if (c == 0) {
          _field.setNextCell(x, y, false);
        }
        if (c == 3) {
          _field.setNextCell(x, y, true);
        }
      }
    }
    
    _field.update();
  }
  
  // メソッドを適宜追加しよう
  private int countLivingNeighbours(int x, int y) {
    int c = 0;
    for (int dx = -1; dx <= 1; dx++) {
      for (int dy = -1; dy <= 1; dy++) {
        if (dx == 0 && dy == 0) continue;
        if (_field.isLiving(x + dx, y + dy)) c++;
      }
    }
    return c;
  }
}
