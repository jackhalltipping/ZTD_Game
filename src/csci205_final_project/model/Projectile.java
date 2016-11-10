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

import javafx.scene.image.Image;

/**
 *
 * @author emb038
 */
public class Projectile extends Mob {
    public Projectile(double x, double y, double speed, Image image,
		      Fighter createdBy) {
	super(x, y, speed, image);
	setSpeed(1);
    }

}
