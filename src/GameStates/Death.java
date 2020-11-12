package GameStates;

import java.awt.Font;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Death extends BasicGameState {
    
    //private Image image;
    TrueTypeFont f;
    
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
      //image = new Image("EndScreen copy.png");
      f = new TrueTypeFont(new java.awt.Font("Arial",0,30),true);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException { 
        Input in = gc.getInput();
        
        if (in.isKeyDown(Input.KEY_SPACE)) {
            System.exit(0);
        }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
      //image.draw(0,0);
      
      g.drawString("Game Over",350,300);
    }
    
    public int getID() {
       return 3;
    }

    
}