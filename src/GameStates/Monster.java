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
    private int mx =0,my =0;
    private int dir = 0;

    
    
    public Monster(int x,int y) throws SlickException{
        mx = x;
        my = y;
        image = new SpriteSheet("Images/MonsterSheet.png",61,42);
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                walk[i][j] = image.getSubImage(i, j);
            }
            aniL[i] = new Animation(walk[i], 100);
        }
        hitbox = new Rectangle(mx,my,image.getWidth(),image.getHeight());
    }
    
    public void draw(){
        aniL[dir].draw(mx,my);
    }
    
    public void move(int Px, int Py){
        
        if (hitbox.getX() <= Px) {
            mx+=1;
            dir = 0;
        }
        if (hitbox.getY() >= Py) {
            my-=1;
            dir = 0;
        }
        if (hitbox.getX() >= Px) {
            mx-=1;
            dir = 1;
        }
        if (hitbox.getY() <= Py) {
            my+=1;
            dir = 1;
        }
    }
}
