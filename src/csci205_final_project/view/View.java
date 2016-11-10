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
import csci205_final_project.model.ViewObj;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author emb038
 */
public class View {
    Scene scene;
    Model theModel;
    VBox root;
    Pane gameRoot;
    Pane menuRoot;
    Pane shopRoot;
    ArrayList<ViewObj> viewObjs = new ArrayList<ViewObj>();

    public View(Model theModel) throws MalformedURLException, IOException {
	this.theModel = theModel;
	setRoot();
	addViewObj(theModel.getPlayer());
        //addLabels();
        
    }

    private void setRoot() throws MalformedURLException, IOException {
	File file = new File("src/csci205_final_project/view/layout.fxml");
	URL url = file.toURL();
	System.out.println(url);
	root = FXMLLoader.load(url);
	gameRoot = (Pane) root.lookup("#gameRoot");
        menuRoot = (Pane) root.lookup("#menuRoot");
        //shopRoot = (Pane) root.lookup("#shopPane");
    }

    public Parent getRoot() {
	return root;
    }

    public Parent getGameRoot() {
	return gameRoot;
    }
    
    public Parent getMenuRoot() {
        return menuRoot;
    }
    
    public Scene getScene() {
	return scene;
    }

    public void setScene(Scene scene) {
	this.scene = scene;
    }

    public void addViewObj(ViewObj viewObj) {
	StackPane sp = new StackPane();
	ImageView imgView = new ImageView(viewObj.getImage());
	sp.getChildren().add(imgView);
	sp.layoutXProperty().bind(viewObj.getXProp());
	sp.layoutYProperty().bind(viewObj.getYProp());
	sp.rotateProperty().bind(viewObj.getDirectionProp());
	gameRoot.getChildren().add(sp);

	viewObjs.add(viewObj);
    }

    public ArrayList<ViewObj> getViewObjs() {
	return viewObjs;
    }
    
    public void addLabels() { 
        //Label money = (Label) menuRoot.lookup("#money");
        //money.setText(String.valueOf(getMoney()));
        //menuRoot.getChildren().add(money);
        
        ((Label) menuRoot.lookup("#money")).setText(String.valueOf(getMoney()));
    }
    
    public double getMoney() {
        return 1000.00;
    }

}
