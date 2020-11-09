package GameStates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainRoom extends BasicGameState {
    Image Floor;

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        Floor = new Image("Images/Floor.png");
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException { 

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
       g.drawString("Main Game",0,0);
       for(int x=0; x<800; x+=32){
            for(int y=0; y<600; y +=32){
                Floor.draw(x,y);
            }
       }
    }
    
    public int getID() {
       return 1;  //this id will be different for each screen
    }

    
}