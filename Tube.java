import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import javax.swing.JButton;
import java.awt.Color;


class Tube extends Sprite
{
    Model model;
	BufferedImage tube_image = loadImage("Tube.png");
	
     Tube(Json ob)
     {
         x = (int)ob.getLong("x");
         y = (int)ob.getLong("y");
         
     }
	 
    Tube(int x1 , int y1, Model m)
	{
        
       model = m;
        x = x1;
        y = y1;
		w = 55;
		h = 400;
		
		
    }
    
	boolean isTube() { return true; }

	
	boolean update(ArrayList<Sprite> s)
	{
		
		return false;
	}
	
	
	void drawSelf(Graphics g)
	{
		
		g.drawImage(tube_image, x - model.mario.x +150, y, null);
	}
    
    Json marshal()
     {
         Json ob = Json.newObject();
         ob.add("x",x);
         ob.add("y",y);
         
        return ob; 
     }
	 
	  void checkCollision(Sprite s)
	 {
		if(s.isTube())
		{
			if(didItCollide( model.mario.x - model.mario.w , model.mario.y - model.mario.h, model.mario.w, model.mario.h, s.x  - s.w, s.y, s.w, s.h))
			{
                model.mario.get_out_of_tube(s);
			}
		
			//if(didItCollide(model.goomba.x - model.goomba.w , model.goomba.y - model.goomba.h, model.goomba.w, model.goomba.h, s.x - s.w, s.y, s.w,s.h))
            //{  
				
				//model.goomba.move = !(model.goomba.move);
            //}
		
		
		}
	 }
    

}

//used for sorting tubes
class TubeComparator implements Comparator<Tube>
{
	public int compare(Tube a, Tube b)
	{
		if(a.x < b.x)
			return -1;
		else if(a.x > b.x)
			return 1;
		else
			return 0;
	}

	public boolean equals(Object obj)
	{
		return false;
	}
}


