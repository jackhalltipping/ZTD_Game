/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2016
*
* Name: NAMES of team members
* Date: Nov 9, 2016
* Time: 3:58:06 PM
*
* Project: csci205_final_project
* Package: csci205_final_project.model
* File: Fighter
* Description:
*
* ****************************************
 */
package csci205_final_project.model;

import csci205_final_project.Game;
import java.util.ArrayList;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.image.Image;

/**
 *
 * @author emb038
 */
public class PlayerFighter extends Fighter {

    private SimpleDoubleProperty playerHealth = new SimpleDoubleProperty(0);

    public PlayerFighter(double range, double frrt, double power,
			 double projSpeed,
			 Image projImage, double health, int team,
			 ViewObj viewObj) {
	super(range, frrt, power,
	      projSpeed,
	      projImage, false, health, team,
	      viewObj, 0);
	playerHealth.set(health);
    }

    @Override
    public void update(double duration, ArrayList<Fighter> fighters) {
	//Avoid previous update method
    }

    @Override
    public void takeDamage(double power) {
	super.takeDamage(power);
	playerHealth.set(health / 100.0);
    }

    @Override
    public void die() {
	Game.gameOver();
    }

    public void click() {
	//Handles clicking of a fighter
    }

    public SimpleDoubleProperty getPlayerHealthProperty() {
	return playerHealth;
    }

}
