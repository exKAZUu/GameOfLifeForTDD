package jp.ac.nii;

/**
 * ライフゲームのルールを表現するクラスです。 advanceメソッドのみ変更して下さい。 ただし、新たにメソッドを追加しても構いません。
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
    for (int y = 0; y < _field.getHeight(); y++) {
      for (int x = 0; x < _field.getWidth(); x++) {
        if (_field.isLiving(x, y)) {
          int cnt = 0;
          for (int yy = -1; yy <= +1; yy++) {
            for (int xx = -1; xx <= +1; xx++) {
              if (xx == 0 && yy == 0)
                continue;
              if (_field.isLiving(x + xx, y + yy))
                cnt++;
            }
          }
          switch (cnt) {
          case 0:
          case 1:
            _field.setNextCell(x, y, false);
            break;
          case 2:
          case 3:
            _field.setNextCell(x, y, true);
            break;
          default:
            _field.setNextCell(x, y, false);
            break;
          }
        }
      }
    }

    _field.update();
  }
  // メソッドを適宜追加しよう
}
