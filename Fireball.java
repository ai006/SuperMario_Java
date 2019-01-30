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

class Fireball extends Sprite
{
	double vert_velocity;
    double hor_velocity;
    int  i; //used to switch between 1 and zero
    Model model;
	BufferedImage fireball_image = loadImage("fireball.png");
	
	Fireball(int x1 , int y1, Model m)
	{
        
       model = m;
        x = x1;
        y = y1;
		w = 55;
		h = 400;
		vert_velocity = 3.0; 
        hor_velocity = 3.0;
		i = 0;
		
    }
    
	boolean update(ArrayList<Sprite> s)
	{
		x+= hor_velocity;
       
        if( i == 0)
        {
            y-= vert_velocity;
            if(y < 200)
            {
                i = 1;
            }
           
        }
        else  
        {
            y+= vert_velocity; 
            if(y > 300)
            {
                i = 0;
            }
        }
       
        return false;
	}
	
	
	void drawSelf(Graphics g)
	{
		g.drawImage(fireball_image, x - model.mario.x +150, y - 40, null);
	}

	boolean isFireball() { return true;}
	
	void checkCollision(Sprite s)
	 {	
		
	 }


}