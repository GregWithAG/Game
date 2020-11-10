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

public class MainRoom extends BasicGameState {
    Image Floor;
    private SpriteSheet image;
    private Animation ani[] = new Animation[4];
    private Image walk[][] = new Image[4][4];
    private Image idle[] = new Image[4];
    private Rectangle hitbox;
    int guyX = 700, guyY = 500;
    int dir = 3;
    boolean stop = true;
    Monster m;

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        Floor = new Image("Images/floor.png");
        m = new Monster(100,100);
       image = new SpriteSheet("Images/george.png", 48, 48);
        image.startUse();
            for (int i = 0; i < 4; i++) {
                idle[i] = image.getSubImage(i, 0);
                for (int j = 0; j < 4; j++) {
                    walk[i][j] = image.getSubImage(i, j);
                }
            ani[i] = new Animation(walk[i], 100);
        }
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException { 
        Input in = gc.getInput();
        stop = false;
        if (in.isKeyDown(Input.KEY_D) && guyX <=800) {
            guyX++;
            dir=3;
        }
        else if (in.isKeyDown(Input.KEY_A) && guyX >=0) {
            guyX--;
            dir=1;
        }
        else if (in.isKeyDown(Input.KEY_S) && guyY <=600) {
            guyY++;
            dir=0;
        }
        else if (in.isKeyDown(Input.KEY_W) && guyY >=0) {
            guyY--;
            dir=2;
        }
        else{
            stop = true;
        }
        m.move(guyX, guyY);
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
       g.drawString("Main Game",0,0);
       for(int x=0; x<800; x+=192){
            for(int y=0; y<600; y +=95){
                Floor.draw(x,y);
            }
       }
       if(stop){
           ani[dir].stop();
           idle[dir].draw(guyX,guyY);
       }
       else{
           ani[dir].start();
           ani[dir].draw(guyX,guyY);
       }
       m.draw();
    }
    
    public int getID() {
       return 1;  //this id will be different for each screen
    }

    
}