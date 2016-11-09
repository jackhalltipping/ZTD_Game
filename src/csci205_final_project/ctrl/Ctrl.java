/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2016
*
* Name: NAMES of team members
* Date: Nov 8, 2016
* Time: 2:53:07 PM
*
* Project: csci205_final_project
* Package: csci205_final_project.ctrl
* File: Ctrl
* Description:
*
* ****************************************
 */
package csci205_final_project.ctrl;

import csci205_final_project.Game;
import csci205_final_project.model.Enemy;
import csci205_final_project.model.Fighter;
import csci205_final_project.model.Model;
import csci205_final_project.model.Tower;
import csci205_final_project.model.ViewObj;
import csci205_final_project.model.towers.Minigun;
import csci205_final_project.view.View;
import java.util.ArrayList;
import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/**
 *
 * @author emb038
 */
public class Ctrl {
    View theView;
    Model theModel;
    double DT = 0.05; //Frame duration in seconds
    ArrayList<Fighter> fighters = new ArrayList<Fighter>();

    public Ctrl(Model theModel, View theView) {
	this.theModel = theModel;
	this.theView = theView;

	Enemy enemy = new Enemy(200, 200);
	theView.addViewObj(enemy);
	fighters.add(enemy.fighter);

	setKeyBindings();
	start();
    }

    public void setKeyBindings() {
	EventHandler<KeyEvent> keyEvent = (new EventHandler<KeyEvent>() {
	    @Override
	    public void handle(KeyEvent ke) {
		System.out.println(ke.getEventType());
		if (ke.getEventType().equals(KeyEvent.KEY_PRESSED)) {
		    theModel.getPlayer().setSpeed(1);
		    if (ke.getCode().equals(KeyCode.RIGHT)) {
			theModel.getPlayer().setDirection(0);
		    }
		    if (ke.getCode().equals(KeyCode.UP)) {
			theModel.getPlayer().setDirection(270);
		    }
		    if (ke.getCode().equals(KeyCode.LEFT)) {
			theModel.getPlayer().setDirection(180);
		    }
		    if (ke.getCode().equals(KeyCode.DOWN)) {
			theModel.getPlayer().setDirection(90);
		    }
		    theModel.getPlayer().setSpeed(1);
		}
		if (ke.getEventType().equals(KeyEvent.KEY_RELEASED)) {
		    theModel.getPlayer().setSpeed(0);
		}
	    }

	});

	theView.getScene().setOnKeyPressed(keyEvent);
	theView.getScene().setOnKeyReleased(keyEvent);

	theView.getGameRoot().setOnMousePressed(new EventHandler<MouseEvent>() {
	    @Override
	    public void handle(MouseEvent event) {
		double mouseX = event.getSceneX();
		double mouseY = event.getSceneY();

		Tower tower = new Minigun(mouseX, mouseY);
		Game.theView.addViewObj(tower);
		Game.theCtrl.addFighter(tower.fighter);
	    }

	});
    }

    public void addFighter(Fighter fighter) {
	fighters.add(fighter);
    }

    public void start() {
	PauseTransition wait = new PauseTransition(Duration.seconds(DT));
	wait.setOnFinished((e) -> {
	    this.frame();
	    wait.playFromStart();
	});
	wait.play();
    }

    public void frame() {
	ArrayList<ViewObj> viewObjs = theView.getViewObjs();
	for (ViewObj viewObj : viewObjs) {
	    viewObj.frame(DT);
	}
	for (Fighter fighter : fighters) {
	    fighter.update(DT, fighters);
	}
    }
}
