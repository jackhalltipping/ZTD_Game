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
* File: gameNoise
* Description:
*
* ****************************************
 */
package csci205_final_project.ctrl;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 *
 * @author Matt
 */
public class gameNoise {

    String musicFileName = "resources/AllIWantForChristmas.mp3";
    MediaPlayer mediaPlayer;

    public gameNoise() {
        this.musicFileName = "resources/AllIWantForChristmas.mp3";
        Media sound = new Media(new File(musicFileName).toURI().toString());
        this.mediaPlayer = new MediaPlayer(sound);
    }

    public gameNoise(String musicFileName) {
        this.musicFileName = "resources\\" + musicFileName;
        Media sound = new Media(new File(this.musicFileName).toURI().toString());
        this.mediaPlayer = new MediaPlayer(sound);
    }

    public void play() {
        mediaPlayer.seek(Duration.ZERO);
        mediaPlayer.play();
    }

}
