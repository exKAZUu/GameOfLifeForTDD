package jp.ac.nii;

import java.util.Random;

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

  public boolean isLiving(int x, int y) {
    if (!(0 <= x && x < width && 0 <= y && y < height)) {
      return false;
    }
    return table[y][x];
  }

  public void initializeRandomly() {
    Random random = new Random();
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        table[y][x] = random.nextBoolean();
      }
    }
  }

  public void initializeCell(int x, int y, boolean living) {
    table[y][x] = living;
  }

  public void setNextCell(int x, int y, boolean living) {
    nextTable[y][x] = living;
  }

  public void update() {
    boolean[][] temp = table;
    table = nextTable;
    nextTable = temp;
  }

  public void clear() {
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        table[y][x] = false;
        nextTable[y][x] = false;
      }
    }
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }
}
