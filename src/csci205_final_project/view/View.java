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

import csci205_final_project.model.Fighter;
import csci205_final_project.model.Model;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author emb038
 */
public class View {
    Model theModel;
    VBox root;
    Pane gameRoot;

    public View(Model theModel) throws MalformedURLException, IOException {
	this.theModel = theModel;
	setRoot();
	addFighter(theModel.getPlayer());
    }

    private void setRoot() throws MalformedURLException, IOException {
	File file = new File("src/csci205_final_project/view/layout.fxml");
	URL url = file.toURL();
	System.out.println(url);
	root = FXMLLoader.load(url);
	gameRoot = (Pane) root.lookup("#gameRoot");
    }

    public Parent getRoot() {
	return root;
    }

    public Parent getGameRoot() {
	return gameRoot;
    }
    
    

    public void addFighter(Fighter fighter) {
	Rectangle rect = new Rectangle();
	rect.setX(50);
	rect.setY(50);
	rect.setWidth(200);
	rect.setHeight(100);
	gameRoot.getChildren().add(rect);
    }

}
