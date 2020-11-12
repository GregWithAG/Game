package GameStates;

import java.io.File;
import javax.sound.sampled.*;

public class Sounder {
Clip sound;
AudioInputStream file;
final File ff = new File(Sounder.class.getProtectionDomain().getCodeSource().getLocation().getPath());
public Sounder(String f){
    try{
    file = AudioSystem.getAudioInputStream(this.getClass().getResource(f));
        sound = AudioSystem.getClip();
        sound.open(file);
        
    }catch(Exception e){
        System.out.println("Error: " + ff.toPath());
    };
}

public void play(){
    sound.start();
   
}

public void reset(){
    sound.setFramePosition(0); 
}

public void stop()
{
    sound.stop();
}

}

