/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2016
*
* Name: NAMES of team members
* Date: Dec 4, 2016
* Time: 7:05:59 PM
*
* Project: csci205_final_project
* Package: csci205_final_project.model
* File: EnemyEnum
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
public enum EnemyEnum {
    ZOMBIE("Zombie", "zombie.png", null, 0, 250, 32, 3, 1, 10, 2),
    GUNNER("Gunner", "gunner.png", "bullet.png", 456, 100, 256, 1, 15, 50, 5),
    BUG("Bug", "bug.png", null, 0, 1000, 32, 10, 1, 5, 10);

    public static double lowestReward = 2;

    public String Name;
    public Image image;
    public Image projImage;
    public double range;
    public double frrt;
    public double power;
    public double health;
    public double reward;
    public double speed;
    public double projSpeed;

    private EnemyEnum(String name, String image, String projImage,
		      double projSpeed, double speed, double range,
		      double frrt, double power, double health, double reward) {
	String path = "file:src/csci205_final_project/view/images/";
	this.Name = name;
	this.image = new Image(path + image);
	this.projImage = new Image(path + projImage);
	this.projSpeed = projSpeed;
	this.speed = speed;
	this.range = range;
	this.frrt = frrt;
	this.power = power;
	this.health = health;
	this.reward = reward;
    }
}
