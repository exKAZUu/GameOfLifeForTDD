package jp.ac.nii;

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

	private final int dx[] = { -1, 0, 1, 1, 1, 0, -1, -1 };
	private final int dy[] = { -1, -1, -1, 0, 1, 1, 1, 0 };

	public void advance() {
		for (int y = 0; y < _field.getHeight(); y++) {
			for (int x = 0; x < _field.getWidth(); x++) {
				int cellCount = 0;
				for (int d = 0; d < 8; d++) {
					int nx = x + dx[d], ny = y + dy[d];
					if(_field.isLiving(nx, ny)) {
						cellCount++;
					}
				}
				
				if(cellCount <= 1 || 4 <= cellCount) {
					_field.setNextCell(x, y, false);
				} else if(cellCount == 3 && !_field.isLiving(x, y)) {
					_field.setNextCell(x, y, true);
				}
			}
		}
		_field.update();
	}
}
