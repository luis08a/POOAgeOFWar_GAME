package presentacion;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import javax.swing.*;

import aplicacion.*;

public class Sprite {
	protected int xPosition;
	protected int yPosition;
	private int height;
	private int width;
	private Image imagen;
	private final String[] SoldadosMelee = {"/recursos visuales/0.png","/recursos visuales/walk_1.png","/recursos visuales/EnemyGuy/_02/01-Idle/__Bandit02_Idle_000.png","/recursos visuales/Idle (1).png"};
	private final String[] SoldadosTanque = {"/recursos visuales/mini-tyranausor-1.png","/recursos visuales\\dragon_1.png","/recursos visuales/Blaster.png","/recursos visuales/American_sherman_move_forward_1.png"};
	private final String[] torres = {"/recursos visuales/Tower1.png","/recursos visuales/tower-drawing/Tower.png","/recursos visuales/Tower2.png","/recursos visuales/Tower3.png"};
	
	public Sprite(Unidad u){
		xPosition = u.getPosx();
		yPosition = u.getPosy();
		
		if (u instanceof Melee ) { loadImage(SoldadosMelee[u.getEra()-1]);}
		else if (u instanceof Tanque ) { loadImage(SoldadosTanque[u.getEra()-1]);}
		else if (u instanceof Base) {loadImage(torres[u.getEra()-1]);}
	}
	
	public void loadImage(String source) {
		imagen = new ImageIcon(getClass().getResource(source)).getImage();
	}
	
	public Image getImage() {
		return imagen;
	}
	
	public int getX() {
		
		return xPosition;
	}
	
	public int getY() {
		return yPosition;
	}
	
	private static BufferedImage toBufferedImage(Image img){
	    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
	    Graphics2D bGr = bimage.createGraphics();
	    bGr.drawImage(img, 0, 0, null);
	    bGr.dispose();
	    return bimage;
	}
	
	public static Image flip(Image i) {
		AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
		tx.translate(-i.getWidth(null), 0);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		BufferedImage ima = Sprite.toBufferedImage(i);
		return op.filter(ima, null);
	}
}
