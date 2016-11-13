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
import csci205_final_project.model.TowerEnum;
import csci205_final_project.model.ViewObj;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    ArrayList<ViewObj> viewObjs = new ArrayList<ViewObj>();
    TowerEnum tempTowerType;
    StackPane tempTower;

    SimpleDoubleProperty mouseX = new SimpleDoubleProperty(0);
    SimpleDoubleProperty mouseY = new SimpleDoubleProperty(0);

    public View(Model theModel) throws MalformedURLException, IOException {
	this.theModel = theModel;
	setRoot();
	tempTower = new StackPane();
	tempTower.layoutXProperty().bind(mouseX);
	tempTower.layoutYProperty().bind(mouseY);
	gameRoot.getChildren().add(tempTower);
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

    public Scene getScene() {
	return scene;
    }

    public void setScene(Scene scene) {
	this.scene = scene;
    }

    public void addViewObj(ViewObj viewObj) {
	StackPane sp = new StackPane();
	viewObj.setSp(sp);
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

    public void removeViewObj(ViewObj viewObj) {
	//viewObj.getSp().getChildren().clear();
	gameRoot.getChildren().remove(viewObj.getSp());
	viewObjs.remove(viewObj);
    }

    public TowerEnum getTempTower() {
	return tempTowerType;
    }

    public void setTempTower(TowerEnum tempTowerType) {
	this.tempTowerType = tempTowerType;
	tempTower.getChildren().clear();
	if (tempTowerType != null) {
	    tempTower.getChildren().add(new ImageView(tempTowerType.image));
	}
    }

    public void setMouse(double x, double y) {
	mouseX.set(x);
	mouseY.set(y);
    }

    public double getMouseX() {
	return mouseX.getValue();
    }

    public double getMouseY() {
	return mouseY.getValue();
    }

}
