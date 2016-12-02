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

import csci205_final_project.Game;
import csci205_final_project.model.Model;
import csci205_final_project.model.TowerEnum;
import csci205_final_project.model.ViewObj;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

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
	menuRoot.setBackground(new Background(new BackgroundFill(Color.web(
		"#DDDDDD"), CornerRadii.EMPTY, Insets.EMPTY)));
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
	viewObj.setSp(sp);
	ImageView imgView = new ImageView(viewObj.getImage());
	sp.getChildren().add(imgView);
	sp.layoutXProperty().bind(viewObj.getXProp());
	sp.layoutYProperty().bind(viewObj.getYProp());
	sp.rotateProperty().bind(viewObj.getDirectionProp());
	gameRoot.getChildren().add(sp);

	addLabels();

	viewObjs.add(viewObj);
    }

    public ArrayList<ViewObj> getViewObjs() {
	return viewObjs;
    }

    public void addLabels() {
	((Label) menuRoot.lookup("#wave")).setText(String.valueOf(
		theModel.getWave()));
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

    public void initTowerButtons() {
	for (TowerEnum towerType : TowerEnum.values()) {
	    Button newButton = new Button(towerType.Name, new ImageView(
					  towerType.image));
	    newButton.setOnAction(new CreateTowerHandler(towerType));
	    ((HBox) root.lookup("#towerButtons")).getChildren().add(newButton);
	}
    }

    public void setViewBindings() {
	((ProgressBar) root.lookup("#playerHealth")).progressProperty().bind(
		theModel.getPlayer().fighter.getPlayerHealthProperty());
	((Label) root.lookup("#money")).textProperty().bind(
		theModel.getMoneyProperty().asString());
        ((Label)menuRoot.lookup("#highwave")).textProperty().bind(theModel.getHighWave().asString());
    }

}

class CreateTowerHandler implements EventHandler<ActionEvent> {
    TowerEnum towerType;

    public CreateTowerHandler(TowerEnum towerType) {
	this.towerType = towerType;
    }

    @Override
    public void handle(ActionEvent event) {
	Game.theView.setTempTower(towerType);
    }

}
