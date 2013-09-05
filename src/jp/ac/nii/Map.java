package jp.ac.nii;

public class Map {
  private final int width;
  private final int height;
  private final boolean[][] table;

  public Map(int width, int height) {
    this.width = width;
    this.height = height;
    this.table = new boolean[height][width];
  }

  public boolean isLiving(int x, int y) {
    if (!(0 <= x && x < width && 0 <= y && y < height)) {
      return false;
    }
    return table[y][x];
  }

  public void setLiving(int x, int y, boolean value) {
    table[y][x] = value;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }
}
