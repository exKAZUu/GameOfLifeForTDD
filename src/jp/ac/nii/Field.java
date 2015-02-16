package jp.ac.nii;

import java.util.Random;

/**
 * ライフゲームのフィールドを表現するクラスです。
 * このファイルは書き換えないで下さい。
 *
 * @author exKAZUu
 */
public class Field {
  private final int width;
  private final int height;
  private boolean[][] table;
  private boolean[][] nextTable;

  public Field(int width, int height) {
    this.width = width;
    this.height = height;
    this.table = new boolean[height][width];
    this.nextTable = new boolean[height][width];
  }


  /**
   * 指定したセルが生きているかどうかを表すブール値を返します。
   * 
   * @param x 参照するセルのx座標
   * @param y 参照するセルのy座標
   * @return 指定したセルが生きているかどうかを表すブール値
   */
  public boolean isLiving(int x, int y) {
    if (!(0 <= x && x < width && 0 <= y && y < height)) {
      return false;
    }
    return table[y][x];
  }

  /**
   * 乱数を使ってフィールドを初期化します。
   */
  public void initializeRandomly() {
    Random random = new Random();
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        table[y][x] = random.nextBoolean();
      }
    }
  }

  /**
   * 指定したセルの初期値（生きているか死んでいるか）を設定します。
   * 
   * @param x 設定するセルのx座標
   * @param y 設定するセルのy座標
   * @param living 指定したセルが生きているかどうかを表すブール値
   */
  public void initializeCell(int x, int y, boolean living) {
    table[y][x] = living;
  }

  /**
   * updateメソッドを呼び出した際に反映するセルの値（生きているか死んでいるか）を設定します。
   * 
   * @param x 設定するセルのx座標
   * @param y 設定するセルのy座標
   * @param living 指定したセルが生きているかどうかを表すブール値
   */
  public void setNextCell(int x, int y, boolean living) {
    nextTable[y][x] = living;
  }

  /**
   * setNextCellメソッドによる設定結果をフィールドに反映します。 全てのセルに対してsetNextCellメソッドを実行してから呼び出して下さい。
   */
  public void update() {
    boolean[][] temp = table;
    table = nextTable;
    nextTable = temp;
  }

  /**
   * フィールドを死んでいるセルで初期化します。
   */
  public void clear() {
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        table[y][x] = false;
        nextTable[y][x] = false;
      }
    }
  }

  /**
   * フィールドの横幅（横の列に存在するセル数）を返します。
   * 
   * @return フィールドの横幅（横の列に存在するセル数）
   */
  public int getWidth() {
    return width;
  }

  /**
   * フィールドの縦幅（縦の列に存在するセル数）を返します。
   * 
   * @return フィールドの縦幅（縦の列に存在するセル数）
   */
  public int getHeight() {
    return height;
  }
}
