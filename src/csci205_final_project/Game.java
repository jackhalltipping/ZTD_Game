/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci205_final_project;

import csci205_final_project.ctrl.Ctrl;
import csci205_final_project.model.Model;
import csci205_final_project.view.View;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author emb038
 */
public class Game extends Application {
    public static View theView;
    public static Model theModel;
    public static Ctrl theCtrl;

    public static void main(String[] args) throws IOException {
	launch(args);
    }

    @Override
    public void init() throws IOException {
	theModel = new Model();
	theView = new View(theModel);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
	// Now, set up the scene, and connect it to the stage!
	Scene scene = new Scene(theView.getRoot());
	theView.setScene(scene);

	theCtrl = new Ctrl(theModel, theView);
	theModel.addPlayer();

	primaryStage.setTitle("ZTD 47");
	primaryStage.setScene(scene);
	primaryStage.sizeToScene();
	primaryStage.show();
    }

}
