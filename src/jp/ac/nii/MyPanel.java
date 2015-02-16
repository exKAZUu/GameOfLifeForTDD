package jp.ac.nii;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

/**
 * ライフゲームのGUIビューアを実装するクラスです。
 * このファイルは書き換えないで下さい。
 *
 * @author exKAZUu
 */
public class MyPanel extends JPanel {
  private static final long serialVersionUID = 8111796824930071853L;
  private final int tileWidth;
  private final int tileHeight;
  private final GameOfLife gameOfLife;

  public MyPanel(GameOfLife gameOfLife, int tileWidth, int tileHeight) {
    this.gameOfLife = gameOfLife;
    this.tileWidth = tileWidth;
    this.tileHeight = tileHeight;
    this.addMouseListener(new MouseListener() {
      public void mouseReleased(MouseEvent arg0) {}

      public void mousePressed(MouseEvent arg0) {}

      public void mouseExited(MouseEvent arg0) {}

      public void mouseEntered(MouseEvent arg0) {}

      public void mouseClicked(MouseEvent e) {
        int x = e.getX() / tileWidth;
        int y = e.getY() / tileHeight;
        Field field = gameOfLife.getField();
        if (!(0 <= x && x < field.getWidth() && 0 <= y && y < field.getHeight())) {
          return;
        }
        if (e.getButton() == MouseEvent.BUTTON1) {
          field.initializeCell(x, y, !field.isLiving(x, y));
        } else {
          System.out.println("START");
          gameOfLife.start();
          removeMouseListener(this);
        }
      }
    });
  }

  @Override
  public void update(Graphics g) {
    paint(g);
  }

  @Override
  public void paint(Graphics g) {
    Field field = gameOfLife.getField();
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, 500, 500);

    g.setColor(Color.BLACK);
    for (int x = 0; x < field.getWidth(); x++) {
      for (int y = 0; y < field.getHeight(); y++) {
        boolean value = field.isLiving(x, y);
        if (value) {
          g.fillRect(tileWidth * x, tileHeight * y, tileWidth, tileHeight);
        }
      }
    }
  }
}
