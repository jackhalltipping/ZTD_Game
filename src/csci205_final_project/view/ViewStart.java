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
    
    public ViewStart() throws IOException {
	setRoot();
    }

    private void setRoot() throws MalformedURLException, IOException {

	File file = new File("src/csci205_final_project/view/startPane.fxml");
	URL url = file.toURL();
	System.out.println(url);
	root = FXMLLoader.load(url);
    }
    
    public Parent getRoot() {
        return root;
    }
    
    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
