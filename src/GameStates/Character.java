package GameStates;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.*;

public class Character {
    
    private int speed;
    private int x,y;
    private Rectangle hitbox;
    private SpriteSheet image;
    private Animation ani[] = new Animation[4];
    private Image walk[][] = new Image[4][4];
    
    
    
    public Character(int x,int y)throws SlickException{
        image = new SpriteSheet("George", 48, 48);
        image.startUse();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                walk[i][j] = image.getSubImage(i, j);
            }
            ani[i] = new Animation(walk[i], 100);
        }
        hitbox = new Rectangle(x,y,image.getWidth(),image.getHeight());
    }
    
    public void move(int movex,int movey){
        
    }
    
    
}
