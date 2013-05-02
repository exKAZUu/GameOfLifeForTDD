package jp.ac.nii;

public class GameOfLife {
	private Map map;

	public GameOfLife(int width, int height) {
		map = new Map(width, height);
	}
	
	public Map getMap() {
		return map;
	}
	
	public void advance() {
	}
}
