import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import javax.swing.JButton;
import java.awt.Color;

class Goomba extends Sprite
{
	BufferedImage goomba_image = loadImage("gumba.png");
	BufferedImage goombaFire_image = loadImage("gumba_fire.png");
	
	double vert_velocity;
    double hor_velocity;
	boolean move;
	boolean die;	//used to switch between burning and !buring goomba
	boolean hit;	//used check if goomba is hit 
	int frame;//frames to pass while goomba burns
	Model model;
	ArrayList<Sprite> sprites;
	

	Goomba(Model m)
	{
        model = m;
        x = 480;
        y = 200;
		w = 99;
		h = 118;
		move = false;
		hit = false;
		die = false;
		vert_velocity = 2;
		hor_velocity = 2;
		frame = 0;
		
    }
    
	boolean update(ArrayList<Sprite> s)
	{
		if(move)x-= hor_velocity;
		else x+= hor_velocity;
		if(frame > 6 )
		{
				frame = 0;
		}
		for(Iterator<Sprite> it = s.iterator(); it.hasNext();)
        {
			Sprite s1 = it.next();
			checkCollision(s1);
		}
		return false;
	}
	
	boolean isGoomba() { return true; }
	
	void drawSelf(Graphics g)
	{
		if(!die)
		{
			g.drawImage(goomba_image, x - model.mario.x + 110 , y , null);
		}
		else
		{
			g.drawImage(goombaFire_image, x - model.mario.x + 110 , y , null);
			frame++;
		}
	}
	
	 void checkCollision(Sprite s)
	 {
		             
		if(s.isFireball())
		{
			if(didItCollide(s.x - s.w , s.y - s.h, s.w, s.h, x - w, y, w, h))
			{  
				hit = true;
				die =true;
				
			}	
		 }
		 if(s.isTube() ||s.isMario())
		 {
			 
			if(didItCollide(s.x, s.y, s.w, s.h, x, y, w, h))
            {  
				//System.out.println("it is checking in here");
				move = !(move);
            }
		 }
	  }
   }