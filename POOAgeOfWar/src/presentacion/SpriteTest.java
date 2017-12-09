package presentacion;
import java.awt.*;

public class SpriteTest extends Sprite{
	private Image imagen;
	private final String[] eras = {"/recursos visuales/walk_1.png","/recursos visuales/EnemyGuy/_02/01-Idle/__Bandit02_Idle_000.png"};
	
	public SpriteTest(int x, int y, int era){
		
		super(x,y);
		loadImage(eras[era-1]);
		imagen = getImage();
	}
	
}
