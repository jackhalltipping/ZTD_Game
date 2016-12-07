/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2016
*
* Name: NAMES of team members
* Date: Nov 30, 2016
* Time: 10:18:06 AM
*
* Project: csci205_final_project
* Package: csci205_final_project.view
* File: ViewGameOver
* Description:
*
* ****************************************
 */
package csci205_final_project.view;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

/**
 * Class which represents the view of the game over screen
 *
 * @author xt004
 */
public class ViewGameOver {
    Scene scene;
    VBox root;

    /**
     * Constructor which sets the root for the game over screen
     *
     * @throws IOException
     */
    public ViewGameOver() throws IOException {
	setRoot();
    }

    /**
     * Uploads the fxml file for the view of the root
     *
     * @throws MalformedURLException
     * @throws IOException
     */
    private void setRoot() throws MalformedURLException, IOException {

	File file = new File("resources/gameOver.fxml");
	URL url = file.toURL();
	System.out.println(url);
	root = FXMLLoader.load(url);
    }

    /**
     * getter for the root
     *
     * @return Parent our root
     */
    public Parent getRoot() {
	return root;
    }

    /**
     * getter for the scene
     *
     * @return Scene
     */
    public Scene getScene() {
	return scene;
    }

    /**
     * setter for the scene
     *
     * @param scene
     */
    public void setScene(Scene scene) {
	this.scene = scene;
    }
}
