package GameStates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.*;

public class StartScreen extends BasicGameState {
    Image Title;
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       Title = new Image("Images/Title_Screen.png");
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException { 
        Input in = gc.getInput();
       
        if (in.isKeyDown(Input.KEY_SPACE)) {
            sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
       g.drawString("press space",0,0);
       Title.draw(0,0);
    }
    
    public int getID() {
       return 0;  //this id will be different for each screen
    }

    
}