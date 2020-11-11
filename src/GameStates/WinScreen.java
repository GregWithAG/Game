package GameStates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class WinScreen extends BasicGameState {
    private Image image;
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        image = new Image("Images/Win.png");
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException { 

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
       
    }
    
    public int getID() {
       return 3;  //this id will be different for each screen
    }

    
}
