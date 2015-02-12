package jp.ac.nii;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {

  public static void main(String[] args) {
    JFrame frame = new JFrame("Game of Life");
    GameOfLife gameOfLife = new GameOfLife(50, 50);
    MyPanel panel = new MyPanel(gameOfLife, 10, 10);
    panel.setSize(new Dimension(500, 500));
    panel.setPreferredSize(new Dimension(500, 500));
    frame.getContentPane().add(panel);
    panel.setBackground(Color.WHITE);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

    gameOfLife.getField().initializeRandomly();

    System.out.println("INITIALIZE");
    while (frame.isVisible()) {
      try {
        Thread.sleep(1000 / 60);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      gameOfLife.advance();
      frame.repaint();
    }
    frame.dispose();
  }
}
