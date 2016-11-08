/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2016
*
* Name: NAMES of team members
* Date: Nov 8, 2016
* Time: 2:52:45 PM
*
* Project: csci205_final_project
* Package: csci205_final_project.view
* File: View
* Description:
*
* ****************************************
 */
package csci205_final_project.view;

import csci205_final_project.model.Model;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 *
 * @author emb038
 */
public class View {
    Model theModel;
    Parent root;
    Parent gameRoot;

    public View(Model theModel) throws MalformedURLException, IOException {
	this.theModel = theModel;
	setRoot();
    }

    private void setRoot() throws MalformedURLException, IOException {
	File file = new File("src/csci205_final_project/view/layout.fxml");
	URL url = file.toURL();
	System.out.println(url);
	root = FXMLLoader.load(url);
    }

    public Parent getRoot() {
	return root;
    }

    public Parent getGameRoot() {
	return gameRoot;
    }

}
