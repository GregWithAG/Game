package GameStates;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class GameLauncher extends StateBasedGame {

    public GameLauncher(String title) {
        super(title);
    }

    public void initStatesList(GameContainer gc) throws SlickException {
        
        this.addState(new StartScreen());
        this.addState(new MainRoom());
        this.addState(new Death());
    }

    public static void main(String args[]) throws SlickException {
        GameLauncher game = new GameLauncher("Haunted Hill");
        AppGameContainer app = new AppGameContainer(game);
        app.setDisplayMode(800, 600, false);
        app.setShowFPS(false);
        app.setTargetFrameRate(100);
        app.start();
    }

}
