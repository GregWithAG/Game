package GameStates;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class testScreen extends BasicGameState {
    
    private SpriteSheet image;
    private Animation ani[] = new Animation[4];
    private Image walk[][] = new Image[4][4];
    private Rectangle hitbox;
    int guyX = 100, guyY = 100;
    int dir = 3;
    Monster m;
    
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       m = new Monster(100,100);
       image = new SpriteSheet("Images/george.png", 48, 48);
        image.startUse();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                walk[i][j] = image.getSubImage(i, j);
            }
            ani[i] = new Animation(walk[i], 100);
        }
        

    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException { 
        m.move(100, 100);
        Input in = gc.getInput();
        
        if (in.isKeyDown(Input.KEY_D)) {
            guyX++;
            dir=3;
        }
        if (in.isKeyDown(Input.KEY_A)) {
            guyX--;
            dir=1;
        }
        if (in.isKeyDown(Input.KEY_S)) {
            guyY++;
            dir=0;
        }
        if (in.isKeyDown(Input.KEY_W)) {
            guyY--;
            dir=2;
        }
        
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
       m.draw();
       ani[dir].draw(guyX,guyY);
       
    }
    
    public int getID() {
       return 0;  //this id will be different for each screen
    }

    
}