package presentacion;
import java.awt.*;

public class SpriteTest extends Sprite{
	private Image imagen;
	
	public SpriteTest(int x, int y){
		super(x,y);
		loadImage("/recursos visuales/EnemyGuy/_02/01-Idle/__Bandit02_Idle_000.png");
		imagen = getImage();
	}
	public void move() {
		
	}
}
