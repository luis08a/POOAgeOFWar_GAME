package presentacion;
import java.awt.*;

public class SpriteTest extends Sprite{
	private Image imagen;
	
	public SpriteTest(int x, int y){
		
		super(x,y);
		loadImage("/recursos visuales/walk_1.png");
		imagen = getImage();
		
	}
	public void move() {
		
	}
}
