package GameStates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.*;

public class StartScreen extends BasicGameState {
    Image Title;
    Sounder s;
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       s = new Sounder("OpeningMusic.wav");
       Title = new Image("Images/Title_Screen.png");
       
       s.play();
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException { 
        Input in = gc.getInput();
       
        if (in.isKeyDown(Input.KEY_SPACE)) {
            s.stop();
            sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
       Title.draw(0,0);
       g.drawString("press space",350,500);
       
    }
    
    public int getID() {
       return 0;  //this id will be different for each screen
    }

    
}