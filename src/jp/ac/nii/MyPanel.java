package jp.ac.nii;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
  private static final long serialVersionUID = 8111796824930071853L;
  private final int tileWidth;
  private final int tileHeight;
  private Map map;

  public MyPanel(GameOfLife gameOfLife, int tileWidth, int tileHeight) {
    this.map = gameOfLife.getMap();
    this.tileWidth = tileWidth;
    this.tileHeight = tileHeight;
    final MyPanel self = this;
    this.addMouseListener(new MouseListener() {
      public void mouseReleased(MouseEvent arg0) {}

      public void mousePressed(MouseEvent arg0) {}

      public void mouseExited(MouseEvent arg0) {}

      public void mouseEntered(MouseEvent arg0) {}

      public void mouseClicked(MouseEvent e) {
        int x = e.getX() / self.tileWidth;
        int y = e.getY() / self.tileHeight;
        if (!(0 <= x && x < self.map.getWidth() && 0 <= y && y < self.map.getHeight())) {
          return;
        }
        if (e.getButton() == MouseEvent.BUTTON1) {
          map.setLiving(x, y, !map.isLiving(x, y));
        } else {
          System.out.println("START");
          self.removeMouseListener(this);
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
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, 500, 500);

    g.setColor(Color.BLACK);
    for (int x = 0; x < map.getWidth(); x++) {
      for (int y = 0; y < map.getHeight(); y++) {
        boolean value = map.isLiving(x, y);
        if (value) {
          g.fillRect(tileWidth * x, tileHeight * y, tileWidth, tileHeight);
        }
      }
    }
  }
}
