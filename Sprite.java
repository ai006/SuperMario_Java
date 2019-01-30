
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import javax.swing.JButton;
import java.awt.Color;

abstract class Sprite
{
	
	int x;
	int y;
	int w;
	int h;
	BufferedImage CurrentImage;

	boolean isInside (int mouse_x, int mouse_y)
	{
       
        if(mouse_x < x)
            return false;
        if(mouse_x > x + w)
            return false;
        if(mouse_y < y )
            return false;
        if(mouse_y > y + h)
            return false;
    return true;
    }
	
	abstract boolean update(ArrayList<Sprite> s);
	abstract void checkCollision(Sprite s);
	abstract void drawSelf(Graphics g);
	
	boolean isTube() { return false; }
	boolean isGoomba() { return false; }
	boolean isFireball() { return false; }
	boolean isMario() { return false; }
	
	static BufferedImage loadImage(String filename)
	{
       BufferedImage image = null;
        try
		{
			image = ImageIO.read(new File(filename));
		} 
		catch(Exception e)
		{
			e.printStackTrace(System.err);
			System.exit(1);
		}
        return image;
	}
	
	
	static boolean didItCollide(int x1, int y1, int w1, int h1, int x2, int y2, int w2, int h2) 
	{
 
		if(x1 + w1 < x2)
        {
            return false;
        }   
		if(x1 > x2 + w2)
        {
	
            return false;
        }
       
		if(y1 > y2)
        {
            return false;
        }
        if(y1 > y2 + h2) return false;
		
        return true;
	}
}