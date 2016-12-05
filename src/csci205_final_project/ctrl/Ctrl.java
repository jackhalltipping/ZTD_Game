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

import csci205_final_project.model.Enemy;
import csci205_final_project.model.Fighter;
import csci205_final_project.model.Model;
import csci205_final_project.model.Projectile;
import csci205_final_project.model.Tower;
import csci205_final_project.model.TowerEnum;
import csci205_final_project.model.ViewObj;
import csci205_final_project.view.View;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * Controller class for the MVC
 * @author emb038
 */
public class Ctrl {
    Random random = new Random();

    View theView;
    Model theModel;
    static boolean inWave;
    double DT = 0.02; //Frame duration in seconds
    double ZPS = 2; //average zombies per second
    int zombiesPerWave = 10;
    ArrayList<Fighter> fighters = new ArrayList<Fighter>();
    ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

    /**
     * Constructor for the controller class
     * @param theModel
     * @param theView
     */
    public Ctrl(Model theModel, View theView) {
	this.theModel = theModel;
	this.theView = theView;

	setKeyBindings();
	start();
	setWaveButtonAction();
    }

    /**
     * Setter for the keys
     */
    public void setKeyBindings() {
	EventHandler<KeyEvent> keyEvent = (new EventHandler<KeyEvent>() {
	    @Override
	    public void handle(KeyEvent ke) {
		if (ke.getEventType().equals(KeyEvent.KEY_PRESSED)) {
		    if (ke.getCode().equals(KeyCode.D)) {
			theModel.getPlayer().setMoveDirection(0);
			theModel.getPlayer().setSpeed(1);
		    }
		    if (ke.getCode().equals(KeyCode.W)) {
			theModel.getPlayer().setMoveDirection(270);
			theModel.getPlayer().setSpeed(1);
		    }
		    if (ke.getCode().equals(KeyCode.A)) {
			theModel.getPlayer().setMoveDirection(180);
			theModel.getPlayer().setSpeed(1);
		    }
		    if (ke.getCode().equals(KeyCode.S)) {
			theModel.getPlayer().setMoveDirection(90);
			theModel.getPlayer().setSpeed(1);
		    }
		    if (ke.getCode().equals(KeyCode.M)) {
			theView.setTempTower(TowerEnum.MINIGUN);
		    }
		    if (ke.getCode().equals(KeyCode.L)) {
			theView.setTempTower(TowerEnum.LASER);
		    }
		    if (ke.getCode().equals(KeyCode.C)) {
			theView.setTempTower(TowerEnum.CANNON);
		    }
		    if (ke.getCode().equals(KeyCode.T)) {
			theView.setTempTower(TowerEnum.MISSLE_LAUNCHER);
		    }
		    if (ke.getCode().equals(KeyCode.ESCAPE)) {
			theView.setTempTower(null);
		    }

		}
		if (ke.getEventType().equals(KeyEvent.KEY_RELEASED)) {
		    theModel.getPlayer().setSpeed(0);
		}
	    }

	});

	theView.getScene().setOnKeyPressed(keyEvent);
	theView.getScene().setOnKeyReleased(keyEvent);

	theView.getGameRoot().setOnMousePressed(new EventHandler<MouseEvent>() {
            
            /**
             * handler for the mouse event when its pressed so the tower can be placed
             * @param event 
             */
	    @Override
	    public void handle(MouseEvent event) {
		double mouseX = event.getSceneX();
		double mouseY = event.getSceneY();

		if (theView.getTempTower() != null) {
		    TowerEnum towerType = theView.getTempTower();
		    if (theModel.getMoney() >= towerType.price) {
			new Tower(mouseX, mouseY, towerType);
			theView.setTempTower(null);
			theModel.addMoney(-towerType.price);
		    }
		} else {
		    theModel.getPlayer().fighter.fire(null);
		}
	    }

	});
	theView.getGameRoot().setOnMouseMoved(new EventHandler<MouseEvent>() {
            
            /**
             * handler for the event when the mouse is moved
             * @param event 
             */
	    @Override
	    public void handle(MouseEvent event) {
		theView.setMouse(event.getSceneX(), event.getSceneY());
	    }

	});
    }

    /**
     * Adds fighters to the game
     * @param fighter
     */
    public void addFighter(Fighter fighter) {
	fighters.add(fighter);
    }

    /**
     * Method to start the game
     */
    public void start() {
	PauseTransition wait = new PauseTransition(Duration.seconds(DT));
	wait.setOnFinished((e) -> {
	    this.frame();
	    wait.playFromStart();
	});
	wait.play();
    }

    /**
     * Sets the frame for the game
     */
    public void frame() {
	ArrayList<ViewObj> viewObjs = theView.getViewObjs();
	for (ViewObj viewObj : viewObjs) {
	    viewObj.frame(DT);
	}
	for (Fighter fighter : fighters) {
	    fighter.update(DT, fighters);
	}
	for (int i = 0; i < projectiles.size(); i++) {
	    i -= projectiles.get(i).update(DT, fighters);
	}
	if (random.nextDouble() <= DT * ZPS && inWave) {
	    //wave incrementation
	    zombiesPerWave -= 1;
	    if (zombiesPerWave == 0) {
		endWave();

	    }

	    double x, y;
	    double offscreenDist = 64;
	    if (random.nextBoolean()) {
		x = random.nextDouble() * ((Pane) theView.getGameRoot()).getWidth();
		if (random.nextBoolean()) {
		    y = -1 * offscreenDist;
		} else {
		    y = random.nextDouble() * ((Pane) theView.getGameRoot()).getHeight() + offscreenDist;
		}
	    } else {
		y = random.nextDouble() * ((Pane) theView.getGameRoot()).getHeight();
		if (random.nextBoolean()) {
		    x = -1 * offscreenDist;
		} else {
		    x = random.nextDouble() * ((Pane) theView.getGameRoot()).getWidth() + offscreenDist;
		}
	    }

	    new Enemy(x, y);
            Enemy.setReward((int) (0.1* theModel.getWave()+0.5));
        }
    }
    
    /**
     * Ends the wave of Zombies and changes characteristics such as health for the enemies
     */
    private void endWave() {
        theModel.updateWave();
        inWave = false;
        theModel.addMoney(theModel.getWave() * 10 + 25);
        zombiesPerWave = (int) (Math.sqrt(theModel.getWave() ^ (3)) + 10 * theModel.getWave());
        ZPS += 1 / 2;

        Enemy.setHealth(
                (int) (Enemy.getHealth() + Math.sqrt(theModel.getWave()) * 2)+3);
    }

    /**
     * Removes a fighter from the ArrayList of Fighters
     * @param fighter
     */
    public void removeFighter(Fighter fighter) {
	fighters.remove(fighter);
    }

    /**
     * Removes a specified projectile from the ArrayList of projectiles
     * @param projectile
     */
    public void removeProjectile(Projectile projectile) {
	projectiles.remove(projectile);
    }

    /**
     * Adds projectiles to the ArrayList of projectiles
     * @param projectile
     */
    public void addProjectile(Projectile projectile) {
	projectiles.add(projectile);
    }

    /**
     * Converts X to an appropriate coordinate for the game
     * @param x coordinate
     * @return double adjusted coordinate
     */
    public double convertX(double x) {
	int tileSize = 50;
	return x - (x % tileSize);
    }

    /**
     * Converts Y to an appropriate coordinate for the game
     * @param y coordinate
     * @return double adjusted coordinate
     */
    public double convertY(double y) {
	int tileSize = 50;
	return y - (y % tileSize);
    }

    /**
     * sets events for different buttons
     */
    public void setEvents() {
	setHandler("startWave");
	setHandler("createTower");
    }

    /**
     * Calls the handler for the specified button
     * @param id of the button
     */
    public void setHandler(String id) {
	theView.getMenuRoot().lookup("#" + id).addEventHandler(
		MouseEvent.MOUSE_CLICKED,
		new EventHandler<MouseEvent>() {
	    @Override
	    public void handle(MouseEvent event) {
		try {
		    Ctrl.handle(id);
		} catch (Exception ex) {

		}
	    }
	});
    }

    /**
     * Handler which uses switch to handle different buttons
     * @param id of the button
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void handle(String id) throws IOException, ClassNotFoundException {
	System.out.println("Handling: " + id + " click");
	switch (id) {
	    case "startWave":
		Ctrl.startWave();
		break;
	    case "createTower":
		break;
	}
    }

    /**
     * Starts the wave of zombies
     */
    public static void startWave() {
	//should be inWave=true
	inWave = true;
	//other stuff
    }
    
    /**
     * Handler for the start Wave button
     */
    private void setWaveButtonAction() {
	Button waveButton = ((Button) theView.getMenuRoot().lookup("#startWave"));
	waveButton.addEventHandler(ActionEvent.ACTION,
				   new EventHandler<ActionEvent>() {
			       @Override
			       public void handle(ActionEvent event) {
				   startWave();
			       }

			   });
    }

}
