package jp.ac.nii;

/**
 * ライフゲームのルールを表現するクラスです。 advanceメソッドのみ変更して下さい。
 * ただし、新たにメソッドを追加しても構いません。
 *
 * @author exKAZUu
 */
public class GameOfLife {
  private Field _field;
  private boolean _active;

  public GameOfLife(int width, int height) {
    _field = new Field(width, height);
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
    // ここに処理を追記して完成させよう
  }
  // メソッドを適宜追加しよう
}
