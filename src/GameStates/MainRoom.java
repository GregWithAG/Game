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
import org.newdawn.slick.state.transition.*;

public class MainRoom extends BasicGameState {
    Sounder s;
    Image Floor,wallt,walll,wallr,wallb;
    private SpriteSheet image;
    private Image chest;
    private Animation ani[] = new Animation[4];
    private Image walk[][] = new Image[4][4];
    private Image idle[] = new Image[4];
    private Rectangle hitbox, chit;
    int guyX = 700, guyY = 500, cx,cy;
    int dir = 3;
    boolean stop = true;
    int points = 0;
    Monster m;
    int timer;


    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        timer = 0;

        s = new Sounder("MainMusic.wav");
        
        Floor = new Image("Images/floor.png");
        walll = new Image("Images/wall-left.png");
        wallr = new Image("Images/wall-right.png");
        wallt = new Image("Images/wall-top.png");
        wallb = new Image("Images/wall-bottom.png");
        chest = new Image("Images/Chest.png");
        m = new Monster(100, 100);
        image = new SpriteSheet("Images/george.png", 48, 48);
        image.startUse();
        s.play();
        
        for (int i = 0; i < 4; i++) {
            idle[i] = image.getSubImage(i, 0);
            for (int j = 0; j < 4; j++) {
                walk[i][j] = image.getSubImage(i, j);
            }
            ani[i] = new Animation(walk[i], 100);
        }
        
        cx = (int) (Math.random() * 750);
        cy = (int) (Math.random() * 500 + 45);
        chit = new Rectangle(cx,cy,chest.getWidth(),chest.getHeight());
        hitbox = new Rectangle(guyX+30, guyY+30,idle[1].getWidth() - 20,idle[1].getHeight() - 20);

    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        timer++;

        
        Input in = gc.getInput();
        stop = false;
        
        guyX = (int)hitbox.getX();
        guyY = (int)hitbox.getY();
        if (in.isKeyDown(Input.KEY_D) && guyX <= 750) {
            guyX += 2;
            dir = 3;
        } else if (in.isKeyDown(Input.KEY_A) && guyX >= 0) {
            guyX -= 2;
            dir = 1;
        } else if (in.isKeyDown(Input.KEY_S) && guyY <= 550) {
            guyY += 2;
            dir = 0;
        } else if (in.isKeyDown(Input.KEY_W) && guyY >= 83) {
            guyY -= 2;
            dir = 2;
        } else {
            stop = true;
        }
        
        hitbox.setX(guyX);
        hitbox.setY(guyY);
        
        if(chit.intersects(hitbox)){
            cx = (int) (Math.random() * 750);
            cy = (int) (Math.random() * 500 + 83);
            points += 1;
            chit.setLocation(cx, cy);
        }
        
        m.move(guyX, guyY);
        if (m.hit(hitbox)) {
            sbg.enterState(3, new FadeOutTransition(), new FadeInTransition());
        }
        if (points == 10) {
            sbg.enterState(4, new FadeOutTransition(), new FadeInTransition());
        }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        
        g.drawString("Main Game", 0, 0);
        for (int x = 0; x < 800; x += 192) {
            for (int y = 0; y < 600; y += 95) {
                Floor.draw(x, y);
            }
        }
        for (int i = 0; i < 800; i+=190) {
            wallt.draw(i,0);
        }
        g.drawString("Keys: " + points, 625, 50);
        
        if (stop) {
            ani[dir].stop();
            idle[dir].draw(hitbox.getX(), hitbox.getY());
        } else {
            ani[dir].start();
            ani[dir].draw(hitbox.getX(), hitbox.getY());
        }
        m.draw();
        chest.draw(chit.getX(),chit.getY());
        
        
    }

    public int getID() {
        return 2;  //this id will be different for each screen
    }

}
