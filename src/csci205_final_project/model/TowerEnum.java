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
    MINIGUN("Minigun", 10, 1, 500, 800, 200, false, "minigun.png",
	    "bullet.png", 20),
    CANNON("Cannon", 1, 10, 250, 1000, 500, false, "cannon.png",
	   "cannonball.png", 10),
    MISSLE_LAUNCHER("Missile Launcher", 1, 5, 500, 1200, 200, true,
		    "launcher.png",
		    "missile.png", 25),
    LASER("Laser", 100, 0.5, 1500, 500, 300, false, "lasergun.png",
	  "laser.png", 100)/*,
    SNIPER("Sniper", 1, 100, 1000, 10000, 100, false, null,
	   null,15)*/;
    public String Name;

    public Image image, projImage;
    public double frrt, power, projSpeed, range, health;
    public boolean tracks;
    public double price;

    private TowerEnum(String Name, double frrt,
		      double power, double projSpeed, double range,
		      double health,
		      boolean tracks, String image, String projImage,
		      double price) {
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
	this.price = price;
    }

    public Image getImage() {
	return image;
    }

}
