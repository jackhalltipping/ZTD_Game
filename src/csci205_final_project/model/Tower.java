/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2016
*
* Name: NAMES of team members
* Date: Nov 8, 2016
* Time: 3:11:55 PM
*
* Project: csci205_final_project
* Package: csci205_final_project.model
* File: Tower
* Description:
*
* ****************************************
 */
package csci205_final_project.model;

import javafx.scene.image.Image;

/**
 *
 * @author Jack
 */
public class Tower extends ViewObj {

    double x;
    double y;
    Image img;
    double radius;
    double frrt;
    double timer = 0;

    public Tower(double x, double y, double radius, double frrt, Image projImage,
		 Image image) {
	super(x, y, image);
	this.radius = radius;
	this.frrt = frrt;
    }

    @Override
    public void frame(double duration) {
	super.frame(duration);
	timer -= duration;
	if (timer <= 0) {
	    // Get target check and firing
	    timer = 1.0 / frrt;
	}
    }

}
