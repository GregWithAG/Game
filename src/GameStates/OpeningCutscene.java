package GameStates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class OpeningCutscene extends BasicGameState {

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException { 
        Input in = gc.getInput();
       
        if (in.isKeyDown(Input.KEY_SPACE)) {
            sbg.enterState(2, new FadeOutTransition(), new FadeInTransition());
        }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
       g.drawString("You are a curious child in your small village town.",150,0);
       g.drawString("Being the curious person you are you decide to search the old haunted mansion on the hill.", 0, 20);
       g.drawString("Unfortunately, when you enter the mansion doors they shut behind you and lock", 75, 40);
       g.drawString("You must now avoid the monster that haunts the place,", 150, 60);
       g.drawString("all while hunting down the chests with the keys 10 inside.", 130, 80);
       g.drawString("WASD to move", 350, 150);
       g.drawString("Space to start", 340, 160);
    }
    
    public int getID() {
       return 1;  //this id will be different for each screen
    }

    
}