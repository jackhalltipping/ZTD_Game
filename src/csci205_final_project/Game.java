package csci205_final_project;

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
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;
import javafx.stage.Stage;
import sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl;

/**
 * Game main class
 *
 * @author emb038
 */
public class Game extends Application {
    public static View theView;
    public static Model theModel;
    public static Ctrl theCtrl;
    public static Stage primaryStage;
    public static ViewStart theViewStart;
    public static ViewGameOver theViewGameOver;
    public static boolean testing=false;
    public static String testType;

    /**
     * Starts the game
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
	launch(args);

    }
    public static void test() throws IOException{
        String args[] = {"test"};
        testing=true;
        main(args);
       
        
    }

    /**
     * Initialization of the MVC
     *
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
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

	GameNoise backgroundMusic = new GameNoise("AllIWantForChristmas.mp3");
	backgroundMusic.play();

	Scene sceneStart = new Scene(theViewStart.getRoot());
	this.primaryStage = primaryStage;

	primaryStage.setTitle("ZTD 47");
	primaryStage.setScene(sceneStart);
	primaryStage.sizeToScene();
	primaryStage.setResizable(false);
	primaryStage.show();

	setHandler();
        if(Game.testing){
            MouseEvent startClick = new MouseEvent(MouseEvent.MOUSE_CLICKED, 4, 4, 0.01, 0.01, MouseButton.PRIMARY, 1, false, false, false, false, false, false, false, false, false, true, new PickResult(Game.theViewStart.getRoot().lookup("#start"), 0, 0));
            MouseEvent.fireEvent(Game.theViewStart.getRoot().lookup("#start"), startClick);
        }

	// Now, set up the scene, and connect it to the stage!
    }

    /**
     * sets handler for start button on the ViewStart and switches to the View
     * when the button is clicked
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
	Ctrl.running = false;
    }

}
