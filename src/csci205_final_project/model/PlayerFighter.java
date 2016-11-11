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

import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author emb038
 */
public class PlayerFighter extends Fighter {

    public PlayerFighter(double range, double frrt, double power,
			 double projSpeed,
			 Image projImage, double health, int team,
			 ViewObj viewObj) {
	super(range, frrt, power,
	      projSpeed,
	      projImage, health, team,
	      viewObj);
    }

    @Override
    public void update(double duration, ArrayList<Fighter> fighters) {
	//Avoid previous update method
    }

    @Override
    public void die() {
	//Lose game
    }

    public void click() {
	//Handles clicking of a fighter
    }

}
