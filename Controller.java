import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

class Controller implements  MouseListener, KeyListener
{
   // ArrayList<Sprite> sprites;
    View view;
    Model model;
    boolean keyLeft;
	boolean keyRight;
	boolean keyUp;
	boolean keyDown;
	boolean keySpace;
	boolean ctrl;
    boolean count = false;
	int spaceTouch = 0;
    
    
    
    void setview(View v)
	{
		view = v;
	}
	
    public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_RIGHT: keyRight = true; break;
			case KeyEvent.VK_LEFT: keyLeft = true; break;
			case KeyEvent.VK_UP: keyUp = true; break;
			case KeyEvent.VK_DOWN: keyDown = true; break;
			case KeyEvent.VK_SPACE: keySpace = true; spaceTouch++; break;
			case KeyEvent.VK_CONTROL: ctrl = true; break; 
		}
		char c = e.getKeyChar();
		if(c == 's')
		{
           //model.marshal().save("model.json");
           System.out.println("your model has been saved to model.json");
		}
		if(c == 'l')
		{
           
            //Json j = Json.load("model.json");
            //model.umarshal(j);
            System.out.println("you pressed l");
		}
		if(c == 'g')
		{
			model.addGoombas();
		}
	} 

	public void keyReleased(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_RIGHT: keyRight = false; break;
			case KeyEvent.VK_LEFT: keyLeft = false; break;
			case KeyEvent.VK_UP: keyUp = false; break;
			case KeyEvent.VK_DOWN: keyDown = false; break;
			case KeyEvent.VK_SPACE: keySpace = false;break;
			case KeyEvent.VK_CONTROL: ctrl = false; break;
		}
	}

	public void keyTyped(KeyEvent e)
	{
	}

	
	void update()
	{
        model.mario.prev_x = model.mario.x;
		if(keyRight) 
		{
            model.mario.x+=5; 
            model.mario.frame++;
		}
		
		if(keyLeft)
		{
           
            model.mario.x-=5;
            model.mario.frame++;
		}
		
		if(keyDown)
		{
            //model.dest_y++;
            
		}
		if(keyUp)
		{
            //model.dest_y--;
            model.mario.jump();
		}
		if((keySpace || spaceTouch > 0) && model.mario.onGround < 5 )
		{
            model.mario.jump();
            spaceTouch = 0;
		}
		if(ctrl)
		{
            model.ctrlPressed();
                
		}
	}
	
	//used in adding the tubes to the game 
	//captures the coordinates of where the 
	//mouse was pressed 
    public void mousePressed(MouseEvent e)
	{      
        //this code sends the coordinates of (X Y) 
        //of where the mouse was pressed
		//model.setDestination(e.getX(), e.getY());
		
		System.out.println("yooooooooooooo");
		//sends the coordinates of mouse pressed
		//view.scroll used in checking if there
		//there is a tube
        model.mousePressedM(e.getX()+ model.mario.x - 150  , e.getY());
        //added mario_x pos and sub 150 so that even after I scroll and click 
        //the screen the tubes will appear in the right place on screen and 
        //still be able to moe or remove them
        
        
	}

	public void mouseReleased(MouseEvent e) {    }
	public void mouseEntered(MouseEvent e) {    }
	public void mouseExited(MouseEvent e) {    }
	public void mouseClicked(MouseEvent e) {    }
    
    
	Controller( Model m)
	{
        model = m;
        //  tubes = new ArrayList<Tube>(); //I added this
        
	}
	void setView(View v)
	{
		view = v;
	}


}
