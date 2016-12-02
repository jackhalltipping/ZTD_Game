/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2016
*
* Name: NAMES of team members
* Date: Nov 11, 2016
* Time: 10:42:02 AM
*
* Project: csci205_final_project
* Package: csci205_final_project.ctrl
* File: GameNoise
* Description:
*
* ****************************************
 */
package csci205_final_project.ctrl;

import java.io.File;
import javafx.concurrent.Task;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Matt
 */
public class GameNoise {

    String musicFileName = "resources/AllIWantForChristmas.mp3";
    Media sound;
    private static int mediaPlayerCount = 0;
    private static final int MAX_MEDIAPLAYERS = 30;
    boolean firstPass= true;

    public GameNoise() {
	this.musicFileName = "resources/AllIWantForChristmas.mp3";
	sound = new Media(new File(musicFileName).toURI().toString());
    }

    public GameNoise(String musicFileName) {
	this.musicFileName = "resources/" + musicFileName;
	sound = new Media(new File(this.musicFileName).toURI().toString());


    }
    
    double startTime;

    /**
     * plays sound also creates media player so that there is never cut off from
     * starting a new sound
     */
    public void play() {
     
        if(firstPass){
            firstPass=false;
            int startTime = (int)System.nanoTime();
            soundThread();
        }
        
        System.out.println(System.nanoTime()-startTime);
	if (( (System.nanoTime()) -startTime)>(6*(Math.pow(10, 7)))) {
            startTime=System.nanoTime();
            soundThread();

	}
	mediaPlayerCount--;

    }
    gameNoiseTask theTask;
    
    public void soundThread(){
        
    
       theTask = new gameNoiseTask(sound);
       Thread th = new Thread(theTask);
       th.setDaemon(true);
       th.start();
       
    }
    
    
    
    
    
    class gameNoiseTask extends Task{

        private Media sound;

        public gameNoiseTask(Media sound){
            this.sound = sound;
        }
        
        @Override
        protected Object call() throws Exception {
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            return sound;
        }
        
        
        
    }

}
