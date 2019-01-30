import javax.swing.JFrame;
import java.awt.Toolkit;

public class Game extends JFrame
{

    Controller controller;
    View view;
    Model model;
   
 
    
    public Game()
	{
        //member variables
        model = new Model();
        controller = new Controller(model);
		view = new View(controller, model);
		controller.setview(view);
		
		//setup the inputs of game
		this.addKeyListener(controller);
		view.addMouseListener(controller);
		
		//configure the window
		this.setTitle("SUPER MARIO!!!");
		this.setSize(500, 500);
		this.setFocusable(true);
		this.getContentPane().add(view);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

    public void run()
    {
        while(true)
        {
		//model.update();        
		controller.update();
		model.update();
		view.repaint(); // Indirectly calls View.paintComponent
		Toolkit.getDefaultToolkit().sync();

		// Go to sleep for 50 miliseconds
		try
		{
			Thread.sleep(40);
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		
        }
    }
   
	public static void main(String[] args)
	{
        //testmodelmarshler();
        //testtube();
		Game g = new Game();
		g.run();
	}
}
