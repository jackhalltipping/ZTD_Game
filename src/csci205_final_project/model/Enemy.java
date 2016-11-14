/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2016
*
* Name: NAMES of team members
* Date: Nov 9, 2016
* Time: 3:47:33 PM
*
* Project: csci205_final_project
* Package: csci205_final_project.model
* File: Enemy
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
public class Enemy extends Mob {
    public static double ENEMY_SPEED = 250;
    public static Image ENEMY_IMAGE = new Image(
	    "file:src/csci205_final_project/view/images/zombie.png");
    static double range;
    static double frrt;
    static double power;
    static double health = 100;

    public Fighter fighter;

    public Enemy(double x, double y) {
	super(x, y, ENEMY_SPEED, ENEMY_IMAGE);
	setSpeed(1);
	this.fighter = new Fighter(range, frrt, power, 0, null, false, health, 1,
				   this);
    }

}
