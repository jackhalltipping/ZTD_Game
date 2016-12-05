/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2016
*
* Name: NAMES of team members
* Date: Nov 30, 2016
* Time: 10:17:09 AM
*
* Project: csci205_final_project
* Package: csci205_final_project.view
* File: ViewStart
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
import static javafx.scene.input.DataFormat.URL;
import javafx.scene.layout.VBox;

/**
 *
 * @author xt004
 */
public class ViewStart {
    Scene scene;
    VBox root;
    
    /**
     * Constructor which sets the root for the start screen
     * @throws IOException
     */
    public ViewStart() throws IOException {
	setRoot();
    }
    
    /**
     * Sets the root by uploading file from the fxml file
     * @throws MalformedURLException
     * @throws IOException 
     */
    private void setRoot() throws MalformedURLException, IOException {

	File file = new File("src/csci205_final_project/view/startPane.fxml");
	URL url = file.toURL();
	System.out.println(url);
	root = FXMLLoader.load(url);
    }
    
    /**
     * getter for our root
     * @return Parent our root
     */
    public Parent getRoot() {
        return root;
    }
    
    /**
     * getter for the scene
     * @return screen 
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * setter for the scene
     * @param scene
     */
    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
