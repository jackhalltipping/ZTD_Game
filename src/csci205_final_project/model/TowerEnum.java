/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2016
*
* Name: NAMES of team members
* Date: Nov 10, 2016
* Time: 4:19:18 PM
*
* Project: csci205_final_project
* Package: csci205_final_project.model
* File: TowerEnum
* Description:
*
* ****************************************
 */
package csci205_final_project.model;

import javafx.scene.image.Image;

/**
 *
 * @author Matt
 */
public enum TowerEnum {
    MINIGUN("Minigun", 5, 1, 500, 800, 200, true, "minigun.png",
	    "bullet.png"),
    CANNON("Cannon", 1, 4, 250, 1000, 500, false, null,
	   null),
    MISSLE_LAUNCHER("Missile Launcher", 1, 1, 500, 1200, 200, true,
		    null,
		    null),
    LASER("Laser", 100, 3, 2000, 500, 300, false, null,
	  null),
    SNIPER("Sniper", 1, 1000, 1000, 10000, 100, false, null,
	   null);
    public String Name;
    public Image image, projImage;
    public double frrt, power, projSpeed, range, health;
    public boolean tracks;

    private TowerEnum(String Name, double frrt,
		      double power, double projSpeed, double range,
		      double health,
		      boolean tracks, String image, String projImage) {
	String path = "file:src/csci205_final_project/view/images/";
	this.Name = Name;
	this.image = new Image(path + image);
	this.projImage = new Image(path + projImage);
	this.frrt = frrt;
	this.power = power;
	this.projSpeed = projSpeed;
	this.range = range;
	this.health = health;
	this.tracks = tracks;
    }

}
