/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2016
*
* Name: NAMES of team members
* Date: Nov 9, 2016
* Time: 4:52:01 PM
*
* Project: csci205_final_project
* Package: csci205_final_project.model.towers
* File: Minigun
* Description:
*
* ****************************************
 */
package csci205_final_project.model.towers;

import csci205_final_project.model.Tower;
import javafx.scene.image.Image;

/**
 *
 * @author emb038
 */
public class Minigun extends Tower {
    public static double radius = 1000;
    public static double frrt = 5;
    public static double power;
    public static double projSpeed = 500;
    public static double health;
    public static Image projImage = new Image(
	    "file:src/csci205_final_project/view/images/bullet.png");
    public static Image image = new Image(
	    "file:src/csci205_final_project/view/images/minigun.png");

    public Minigun(double x, double y) {
	super(x, y, radius, frrt, power, projSpeed, health, projImage, image);
    }

}
