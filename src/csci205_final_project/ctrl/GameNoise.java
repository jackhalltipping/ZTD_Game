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
 * Class for playing sounds in the game
 *
 * @author Matt
 */
public class GameNoise {

    String musicFileName = "resources/AllIWantForChristmas.mp3";
    //Media sound;
    private static int mediaPlayerCount = 0;
    private static final int MAX_MEDIAPLAYERS = 30;
    boolean firstPass = true;

    /**
     * Create a GameNoise based on a file name
     *
     * @param musicFileName the file used to generate sound
     */
    public GameNoise(String musicFileName) {
	if (musicFileName == null) {
	    this.musicFileName = null;
	    return;
	}
	this.musicFileName = "resources/" + musicFileName;
	//sound = new Media(new File(this.musicFileName).toURI().toString());

    }

    double startTime;

    /**
     * plays sound also creates media player so that there is never cut off from
     * starting a new sound
     */
    public void play() {
	if (this.musicFileName == null) {
	    return;
	}

	if (firstPass) {
	    firstPass = false;
	    int startTime = (int) System.nanoTime();
	    soundThread();
	}

	if (((System.nanoTime()) - startTime) > (6 * (Math.pow(10, 7))) && mediaPlayerCount < MAX_MEDIAPLAYERS) {

	    startTime = System.nanoTime();
	    soundThread();

	}

    }

    /**
     * Creates a new task to play the sound
     */
    public void soundThread() {

	gameNoiseTask theTask = new gameNoiseTask(this.musicFileName);
	Thread th = new Thread(theTask);
	th.setDaemon(true);
	th.start();

    }

    /**
     * A class for threading in GameNoise
     */
    class gameNoiseTask extends Task {

	private Media sound;

	/**
	 * Create a new task based on the file name
	 *
	 * @param musicFileName the file name
	 */
	public gameNoiseTask(String musicFileName) {

	    this.sound = new Media(new File(musicFileName).toURI().toString());

	}

	/**
	 * Run the task
	 *
	 * @return the sound
	 * @throws Exception problem running the sound
	 */
	@Override
	protected Object call() throws Exception {

	    mediaPlayerCount++;

	    MediaPlayer mediaPlayer = new MediaPlayer(sound);
	    mediaPlayer.play();
	    mediaPlayer.setOnEndOfMedia(new Runnable() {
		@Override
		public void run() {
		    mediaPlayerCount = 0;
		}
	    });
	    return sound;
	}

    }

}
