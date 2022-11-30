package vh.scene;

import java.awt.Graphics;

import vh.helper.LevelBuilder;
import vh.main.GameMain;
import vh.objectManagers.EnemyManager;
import vh.objectManagers.MapTileManager;

public class Playing extends GameScene implements SceneMethods {

	private int[][] level;
	private MapTileManager tileManager;
	private EnemyManager enemyManager;
	
	public Playing(GameMain game) {
		super(game);
		
		level = LevelBuilder.getLevel();
		tileManager = new MapTileManager();
		enemyManager = new EnemyManager(this);
	}
	
	public void update() {
		enemyManager.update();
	}

	@Override
	public void render(Graphics g) {
		drawMap(g);
		enemyManager.draw(g);
	}
	
	private void drawMap(Graphics g) {
		for (int i = 0; i < level.length; i++) {
			for (int j = 0; j < level[i].length; j++) {
				int id = level[i][j];
				g.drawImage(tileManager.getMap(id), j * 16, i * 16, null);
			}
		}
	}

	@Override
	public void mouseClicked(int x, int y) {
		enemyManager.addEnemy(x, y);
	}

	@Override
	public void mouseMoved(int x, int y) {
	}

	@Override
	public void mousePressed(int x, int y) {
	}

	@Override
	public void mouseReleased(int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
