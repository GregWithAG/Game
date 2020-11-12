package GameStates;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.*;

public class Monster {

    private Animation aniL[] = new Animation[2];
    private Image walk[][] = new Image[2][2];
    private SpriteSheet image;
    private Rectangle hitbox;
    private int dir = 0;
    private int xdir, ydir;
    private double speed = 0.5;

    public Monster(int x, int y) throws SlickException {
        
        xdir = 1;
        ydir = 1;
        image = new SpriteSheet("Images/MonsterSheet.png", 61, 42);
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                walk[i][j] = image.getSubImage(i, j);
            }
            aniL[i] = new Animation(walk[i], 100);
        }
        hitbox = new Rectangle(x, y, aniL[1].getWidth(), aniL[1].getHeight());
    }

    public void draw() {
        aniL[dir].draw(hitbox.getX(), hitbox.getY());
        
    }
    
    public Rectangle getHitbox(){
        return hitbox;
    }
    
    public boolean hit(Rectangle x){
        if(hitbox.intersects(x)) 
            return true;
        else
            return false;
    }

    public void move(int Px, int Py) {

        if (hitbox.getX() <= Px) {
            xdir = 1;
            dir = 1;
        }
        if (hitbox.getY() >= Py) {
            ydir = -1;
        }
        if (hitbox.getX() >= Px) {
            xdir = -1;
            dir = 0;
        }
        if (hitbox.getY() <= Py) {
            ydir = 1;
        }
        hitbox.setX(hitbox.getX() + xdir);
        hitbox.setY(hitbox.getY() + ydir);
    }
}
