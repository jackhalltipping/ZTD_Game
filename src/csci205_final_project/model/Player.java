/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2016
*
* Name: NAMES of team members
* Date: Nov 8, 2016
* Time: 3:05:49 PM
*
* Project: csci205_final_project
* Package: csci205_final_project.model
* File: Player
* Description:
*
* ****************************************
 */
package csci205_final_project.model;

import javafx.scene.image.Image;

/**
 *
 * @author emb038
 */
public class Player extends Mob {
    private static Image PLAYER_IMAGE = new Image(
	    "file:src/csci205_final_project/view/images/player.gif");
    private static double PLAYER_SPEED = 350;
    double frrt = 2;
    double power = 1;
    Image projImage;
    double projSpeed;
    double health = 100;

    Fighter fighter; // #firefighter

    public Player(double x, double y) {
	super(x, y, PLAYER_SPEED, PLAYER_IMAGE);
	fighter = new Fighter(0, frrt, power, projSpeed, projImage, health, 0,
			      this);
    }

}
