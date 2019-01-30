import java.util.ArrayList;
import java.util.Iterator;



class Model
{
	
	int mouse_x;
	int mouse_y;
	
	//boolean used in checking 
	//if 2 tubes intercept
	boolean passed = false;
	
	boolean moving	= true;	//used in moving the goomba
	
	boolean hit = false;	//used to remove the goomba
	boolean made;
	Tube tubes;
	Mario mario;
	ArrayList<Sprite> sprites;
	Goomba goomba;
	Fireball fireball;
	
	
	
	Model()
	{
		made = false;
        mario = new Mario(150);
        sprites = new ArrayList<Sprite>();
		sprites.add(mario);
		
		//initialize tubes
		sprites.add(mario);
		tubes = new Tube(250, 200, this);
		sprites.add(tubes);
		tubes = new Tube(800, 150, this); 
		sprites.add(tubes);
		
		
		//add goomba on the screen
		goomba = new Goomba(this);
		sprites.add(goomba);
	
		
		
	}
	
	public void update()
	{
        for(Iterator<Sprite> it = sprites.iterator(); it.hasNext();)
        {
            Sprite s = it.next();
            s.update(sprites);           
			//s.checkCollision(s);
			if(s.isGoomba() && goomba.frame == 5 && goomba.hit)
			{
					it.remove();
					//goomba.deadGoombas++;
					//deadGoombas+=50;
			}
			
        }
	}
	
	
	//code to input tubes
	//it also checks if I hav already 
	//placed a tube where I clicked
    void mousePressedM(int x, int y)
    {
        
        mouse_x = x;
        mouse_y = y;
        boolean clicked = false;
        for(int i = 0; i < sprites.size(); i++)
        {
            
            Sprite s = sprites.get(i);
            clicked = s.isInside(x,y);
                if(clicked == true)
                {
                    sprites.remove(s);
                    return;
                }
            
            }
            if(clicked == false )
            {
            
                Sprite s = new Tube(this.mouse_x,this.mouse_y, this);
                sprites.add(s);
				
				//Sprite s1 = new Goomba();
                //sprites.add(s1);
				
		
				
            }
    }
	
	void ctrlPressed()
    {
                
				fireball = new Fireball(mario.x, mario.y, this);
				sprites.add(fireball);
				this.made = true;
				System.out.println("fire ball is made");
				
    }
	
	void addGoombas()
	{
		goomba = new Goomba(this);
		sprites.add(goomba);
	}
    
    /*Json marshal()
     {   
         Json ob = Json.newObject();
         Json jsonTubes = Json.newList();
         ob.add("tubes", jsonTubes);
         for(int i = 0; i < tubes.size(); i++)
                jsonTubes.add(tubes.get(i).marshal());
        return ob; 
     }
     
     void umarshal(Json obj)
     {
        tubes = new ArrayList<Tube>();
        Json jsonList = obj.get("tubes");
        for(int i = 0; i < jsonList.size(); i++)
            tubes.add(new Tube(jsonList.get(i))); 
    
     }*/
     
   
     

}

















