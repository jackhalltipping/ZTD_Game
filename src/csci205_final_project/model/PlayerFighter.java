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
 * Denotes the Player Fighter class which extends the Fighter class
 * @author emb038
 */
public class PlayerFighter extends Fighter {

    private SimpleDoubleProperty playerHealth = new SimpleDoubleProperty(0);
    
    /**
     * instantiation of the Player Fighter class with certain properties
     * @param range
     * @param frrt
     * @param power
     * @param projSpeed
     * @param projImage
     * @param health
     * @param team
     * @param viewObj 
     */
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
    
    /**
     * Avoids update method in Fighter class
     * @param duration
     * @param fighters 
     */
    @Override
    public void update(double duration, ArrayList<Fighter> fighters) {
	//Avoid previous update method
    }
    
    /**
     * Player takes on damage, so the health is decreased
     * @param power 
     */
    @Override
    public void takeDamage(double power) {
	super.takeDamage(power);
	playerHealth.set(health / 100.0);
    }
    
    /**
     * Die method for the palyer
     */
    @Override
    public void die() {
	Game.gameOver();
    }

    public void click() {
	//Handles clicking of a fighter
    }
    /**
     * Getter for the player health property
     * @return SimpleDoubleProperty of the player health 
     */
    public SimpleDoubleProperty getPlayerHealthProperty() {
	return playerHealth;
    }

}
