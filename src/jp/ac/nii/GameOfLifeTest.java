package jp.ac.nii;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameOfLifeTest {
  
  private GameOfLife _gol;
  private Map _map;


  @Before
  public void before() {
    _gol = new GameOfLife(10, 10);
    _map = _gol.getMap();
  }
  
  @Test
  public void failToBirth() {
    assertEquals(_gol.birth(0, 0, 0), false);
    assertEquals(_map.isLiving(0, 0), false);
  }
  
  @Test
  public void succeedToBirth() {
    _map.setLiving(1, 1, true);
    _map.setLiving(0, 1, true);
    _map.setLiving(1, 0, true);
    assertEquals(_gol.birth(0, 0, 3), true);
    assertEquals(_map.isLiving(0, 0), true);
  }

}
