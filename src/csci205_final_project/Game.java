/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci205_final_project;

import csci205_final_project.ctrl.Ctrl;
import csci205_final_project.ctrl.GameNoise;
import csci205_final_project.model.Model;
import csci205_final_project.view.View;
import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 *
 * @author emb038
 */
public class Game extends Application {
    public static View theView;
    public static Model theModel;
    public static Ctrl theCtrl;
    public static Stage primaryStage;

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
	// start the music
        GameNoise backgroundMusic = new GameNoise();
        backgroundMusic.play();
        
	Scene scene = new Scene(theView.getRoot());
	theView.setScene(scene);

	theCtrl = new Ctrl(theModel, theView);
	theModel.addPlayer();

	this.primaryStage = primaryStage;

	primaryStage.setTitle("ZTD 47");
	primaryStage.setScene(scene);
	primaryStage.sizeToScene();
	primaryStage.setResizable(false);
	primaryStage.show();
	theView.initTowerButtons();
	theView.setViewBindings();
    }

    public static void gameOver() {
	primaryStage.close();
	System.out.println("Game Over");
    }

}
