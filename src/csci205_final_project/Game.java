
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package csci205_final_project;

import csci205_final_project.ctrl.Ctrl;
import csci205_final_project.model.Model;
import csci205_final_project.view.View;
import csci205_final_project.view.ViewGameOver;
import csci205_final_project.view.ViewStart;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Game main class
 * @author emb038
 */
public class Game extends Application {
    public static View theView;
    public static Model theModel;
    public static Ctrl theCtrl;
    public static Stage primaryStage;
    public static ViewStart theViewStart;
    public static ViewGameOver theViewGameOver;

    /**
     * Starts the game
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
	launch(args);

    }
    
    /**
     * Initialization of the MVC
     * @throws IOException 
     */
    @Override
    public void init() throws IOException {
	theModel = new Model();
	theView = new View(theModel);
        theViewStart = new ViewStart();
        theViewGameOver = new ViewGameOver();

    }
    
    /**
     * Sets up the scene and the primary stage
     * @param primaryStage
     * @throws Exception 
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Scene sceneStart = new Scene(theViewStart.getRoot());
        this.primaryStage = primaryStage;
        
        primaryStage.setTitle("ZTD 47");
        primaryStage.setScene(sceneStart);
        primaryStage.sizeToScene();
        primaryStage.show();
        
        setHandler();
        
        
	// Now, set up the scene, and connect it to the stage!
    }
    
    /**
     * sets handler for start button on the ViewStart and switches to the View when the button is clicked
     */
    public void setHandler() {
	theViewStart.getRoot().lookup("#start").addEventHandler(
		MouseEvent.MOUSE_CLICKED,
		new EventHandler<MouseEvent>() {
	    @Override
	    public void handle(MouseEvent event) {
		try {
		    	Scene scene = new Scene(theView.getRoot());
                        theView.setScene(scene);

                        theCtrl = new Ctrl(theModel, theView);
                        theModel.addPlayer();

                        primaryStage.setTitle("ZTD 47");
                        primaryStage.setScene(scene);
                        primaryStage.sizeToScene();
                        primaryStage.show();
                        theView.initTowerButtons();
                        theView.setViewBindings();
		} catch (Exception ex) {

		}
	    }
	});
    }
    
    /**
     * changes the scene to game over screen
     */
    public static void gameOver() {
        Scene sceneStart = new Scene(theViewGameOver.getRoot());
        primaryStage.setTitle("ZTD 47");
        primaryStage.setScene(sceneStart);
        primaryStage.sizeToScene();
        primaryStage.show();
        System.out.println("Game Over");
    }

}
