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
	    "bullet.png", 20,"regularShot.mp3"),
    CANNON("Cannon", 1, 20, 250, 1500, 500, false, "cannon.png",
	   "cannonball.png", 10,"regularShot.mp3"),
    MISSLE_LAUNCHER("Missile Launcher", 1, 10, 750, 1200, 200, true,
		    "launcher.png",
		    "missile.png", 25,"regularShot.mp3"),
    LASER("Laser", 100, 0.5, 1500, 200, 300, false, "lasergun.png",
	  "laser.png", 100,null)/*,
    SNIPER("Sniper", 1, 100, 1000, 10000, 100, false, null,
	   null,15)*/;
    public String Name;

    public Image image, projImage;
    public double frrt, power, projSpeed, range, health;
    public boolean tracks;
    public double price;
    public String soundFileName;

    private TowerEnum(String Name, double frrt,
		      double power, double projSpeed, double range,
		      double health,
		      boolean tracks, String image, String projImage,
		      double price, String soundFileName) {
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
        this.soundFileName=soundFileName;
    }

    public Image getImage() {
	return image;
    }

}
