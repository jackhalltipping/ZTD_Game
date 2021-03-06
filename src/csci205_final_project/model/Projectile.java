/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2016
*
* Name: NAMES of team members
* Date: Nov 9, 2016
* Time: 3:37:45 PM
*
* Project: csci205_final_project
* Package: csci205_final_project.model
* File: Projectile
* Description:
*
* ****************************************
 */
package csci205_final_project.model;

import csci205_final_project.Game;
import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 * Projectile class which extends the Mob
 * @author emb038
 */
public class Projectile extends Mob {
    public double PROJ_RANGE = 32;
    public double TIMEOUT = 5;
    int team;
    boolean tracks;
    double power;
    double timer;

    /**
     * Instantiates the Projectile class
     * @param x
     * @param y
     * @param speed
     * @param power
     * @param image
     * @param team
     * @param tracks
     */
    public Projectile(double x, double y, double speed, double power,
		      Image image, int team, boolean tracks) {
	super(x, y, speed, image);
	setSpeed(1);
	this.power = power;
	this.team = team;
	this.tracks = tracks;

	timer = TIMEOUT;

	Game.theCtrl.addProjectile(this);
    }

    /**
     * Updates the timer for the Projectile and destroys it if the timer is over
     * @param duration
     * @param fighters
     * @return integer of the times
     */
    public int update(double duration, ArrayList<Fighter> fighters) {
	timer -= duration;
	if (timer <= 0) {
	    destroy();
	    return 1;
	}

	double range = PROJ_RANGE;
	double minDistance = Double.MAX_VALUE;
	Fighter target = null;
	for (Fighter fighter : fighters) {
	    if (fighter.team != team) {
		double dist = Math.sqrt(Math.pow(
			fighter.viewObj.getX() - getX(), 2.0) + Math.pow(
				fighter.viewObj.getY() - getY(), 2.0));
		if (dist <= minDistance) {
		    minDistance = dist;
		    target = fighter;
		}
	    }
	}
	if (target != null) {
	    if (minDistance <= range) {
		target.takeDamage(power);
		destroy();
		return 1;
	    }
	    if (tracks) {
		setDirection(-Math.toDegrees(Math.atan2(
			target.viewObj.getX() - getX(),
			target.viewObj.getY() - getY())) + 90);
	    }
	}
	return 0;
    }
    /**
     * Destroy method to remove the projectile
     */
    void destroy() {
	Game.theView.removeViewObj(this);
	Game.theCtrl.removeProjectile(this);
    }

}
