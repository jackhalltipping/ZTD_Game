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
import javafx.scene.media.Media;

/**
 *
 * @author Matt
 */
public class GameNoise {

    String musicFileName = "resources/AllIWantForChristmas.mp3";
    Media sound;
    private static int mediaPlayerCount = 0;
    private static final int MAX_MEDIAPLAYERS = 30;

    public GameNoise() {
	this.musicFileName = "resources/AllIWantForChristmas.mp3";
	sound = new Media(new File(musicFileName).toURI().toString());
    }

    public GameNoise(String musicFileName) {
	this.musicFileName = "resources/" + musicFileName;
	sound = new Media(new File(this.musicFileName).toURI().toString());

    }

    /**
     * plays sound also creates media player so that there is never cut off from
     * starting a new sound
     */
    public void play() {
	mediaPlayerCount++;
	if (mediaPlayerCount <= MAX_MEDIAPLAYERS) {
	    //MediaPlayer mediaPlayer = new MediaPlayer(sound);
	    //mediaPlayer.play();

	}
	mediaPlayerCount--;

    }

}
