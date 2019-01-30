import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import javax.swing.JButton;
import java.awt.Color;






class View extends JPanel
{

    BufferedImage[] marios;
    Model model = new Model();
      
    public void paintComponent(Graphics g)
	{ 
        g.setColor(new Color(128, 255, 255));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(new Color(0,0,0));
        g.drawLine(0, 300,1000,300);
        for(int i = 0 ; i < model.sprites.size(); i++)
		{
			Sprite s = model.sprites.get(i);
			s.drawSelf(g);
		}
	}
		
	int findFirstSpriteOnScreen()
    {
        int start = 0;
        int end = model.sprites.size();
        while(true)
            {
                    int mid = (start + end) / 2;
                    if(mid == start)
                        return start;
                    Sprite s = model.sprites.get(mid);
                    if(s.x - model.mario.x < -100)
                        start = mid;
                    else
                        end = mid;
        }
    }
 

	View(Controller c, Model m)
	{
        model = m;
       
	}
    
   
	
	
	
}
