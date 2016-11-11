/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2016
*
* Name: NAMES of team members
* Date: Nov 8, 2016
* Time: 3:33:41 PM
*
* Project: csci205_final_project
* Package: csci205_final_project.model
* File: Mob
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
public class Mob extends ViewObj {
    double maxSpeed;
    double speed;

    public Mob(double x, double y, double maxSpeed, Image image) {
	super(x, y, image);
	this.speed = 0;
	this.maxSpeed = maxSpeed;
    }

    public void setSpeed(double speed) {
	this.speed = speed * maxSpeed;
    }

    @Override
    public void frame(double duration) {
	super.frame(duration);
	double dx = duration * speed * Math.cos(
		getMoveDirection() * Math.PI / 180.0);
	double dy = duration * speed * Math.sin(
		getMoveDirection() * Math.PI / 180.0);
	getXProp().set(getX() + dx);
	getYProp().set(getY() + dy);
    }

}
