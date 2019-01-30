
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


class Mario extends Sprite
{
    
    int prev_x;
    int prev_y;
    
    double vert_velocity;//vertical velocity
    int frame = 0; //incremented run through pictures
	int onGround;
	
	BufferedImage[] marios;
	ArrayList<Sprite> sprites;
		
    Mario(int xx)
    {
		marios = new BufferedImage[5];
	    marios[0] = loadImage("mario1.png");
        marios[1] = loadImage("mario2.png");
        marios[2] = loadImage("mario3.png");
        marios[3] = loadImage("mario4.png");
        marios[4] = loadImage("mario5.png");
        x = xx;//changed mario x position from 150 to 89
        y = 200;
        w = 61;
		h = 95;
		onGround = 0;
		
		vert_velocity = -12.0;
        
    }
    
    boolean update(ArrayList<Sprite> s)
    {   
        
        vert_velocity += 1.9;   //those 2 lines 
        y += vert_velocity;//simulate gravity
        
        if(y > 300)
        {
            vert_velocity = 0;
            y = 300;
			onGround = 0;
        }
        
        //frame++;
        if(frame > 4)
            frame = 0;
		
		onGround++;
		
		for(Iterator<Sprite> it = s.iterator(); it.hasNext();)
        {
			Sprite s1 = it.next();
			checkCollision(s1);
		}
         
		return false;
    }
	
	boolean isMario() { return true; }
	
	void drawSelf(Graphics g)
	{
		
		g.drawImage(marios[frame], 150, y - h ,null);
		
	}
    
    //function to make mario jump
    void jump()
    {
        vert_velocity -= 17;
		//model.jumpCount += 1;
    
    }
    
     void get_out_of_tube(Sprite s)
     {   
         if(x + w >= s.x && prev_x + w < s.x )// if he crossed the left side of the tube
		 {
			 x = s.x- w - 2 ;
         }
		else if(x <= s.x + s.w && prev_x  > s.x +s.w)
         {  
             x = s.x+s.w+2;
         }
         else if(y >= s.y && prev_y < s.y) // if he crossed the top of the tube
         {
             y = s.y - 2;
             onGround = 0;
             vert_velocity = 0;
			 System.out.println("up");
         }
         else if(y - h <= s.y + s.h && prev_y - h > s.y + s.h) // if he crossed the bottom
         {
             y = s.y + s.h + h + 1;
         }
         else
             System.out.println("How did I get in here?");
     }

  void checkCollision(Sprite s)
   {
	 if(s.isTube())
	 {
			 
			if(didItCollide(s.x, s.y, s.w, s.h, x, y, w, h))
            {  
				get_out_of_tube(s);
            }
	 }
	}
	 
}
