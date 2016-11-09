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
public class Fighter {
    double range;
    double frrt;
    double power;
    double projSpeed;
    Image projImage;
    double health;

    Class targetType;
    ViewObj viewObj;

    double timer = 0;

    public Fighter(double range, double frrt, double power, double projSpeed,
		   Image projImage, double health, Class TargetType,
		   ViewObj viewObj) {
	this.range = range;
	this.frrt = frrt;
	this.power = power;
	this.projSpeed = projSpeed;
	this.projImage = projImage;
	this.health = health;
	this.viewObj = viewObj;
    }

    public void update(double duration, ArrayList<Fighter> fighters) {
	timer -= duration;
	if (timer <= 0) {
	    Fighter target = getTarget(fighters);
	    if (target != null) {
		fire(target);
	    }
	    timer = 1.0 / frrt;
	}
    }

    public Fighter getTarget(ArrayList<Fighter> fighters) {
	double minDistance = range;
	Fighter target = null;
	for (Fighter fighter : fighters) {
	    double dist = Math.sqrt(Math.pow(
		    fighter.viewObj.getX() - viewObj.getX(), 2.0) + Math.pow(
			    fighter.viewObj.getY() - viewObj.getY(), 2.0));
	    if (dist <= minDistance) {
		minDistance = dist;
		target = fighter;
	    }
	}
	return target;
    }

    private void fire(Fighter target) {
	double dir = Math.toDegrees(Math.atan2(
		target.viewObj.getX() - viewObj.getX(),
		target.viewObj.getY() - viewObj.getY()));
	Projectile proj = new Projectile(viewObj.getX(), viewObj.getY(),
					 projSpeed,
					 projImage, this);
	viewObj.setDirection(dir);
	proj.setDirection(dir);
    }

}
