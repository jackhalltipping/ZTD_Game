/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2016
*
* Name: NAMES of team members
* Date: Dec 5, 2016
* Time: 5:41:16 PM
*
* Project: csci205_final_project
* Package: csci205_final_project.test
* File: TestFXGame
* Description:
*
* ****************************************
 */
package csci205_final_project.test;

import csci205_final_project.Game;
import csci205_final_project.ctrl.Ctrl;
import csci205_final_project.ctrl.GameNoise;
import csci205_final_project.model.Model;
import csci205_final_project.view.View;
import csci205_final_project.view.ViewGameOver;
import csci205_final_project.view.ViewStart;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Game main class
 *
 * @author emb038
 */
public class TestFXGame {
    
    public static boolean firstPassTesting=true;

    /**
     * Starts the game
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        Game.test();

    }
    
}    