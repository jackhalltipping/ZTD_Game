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

    public Fighter fighter;

    public Tower(double x, double y, double range, double frrt, double power,
		 double projSpeed, double health, Image projImage,
		 Image image) {
	super(x, y, image);
	this.fighter = new Fighter(range, frrt, power, projSpeed, projImage,
				   health, 0, this);
    }
    
    @Override
    public String toString() {
        return "Helath: " + fighter.health + "\nSpeed: " + fighter.projSpeed + "\nPower: " + fighter.power;
    }

}
