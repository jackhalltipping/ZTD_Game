/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2016
*
* Name: NAMES of team members
* Date: Nov 9, 2016
* Time: 3:47:33 PM
*
* Project: csci205_final_project
* Package: csci205_final_project.model
* File: Enemy
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
public class Enemy extends Mob {
    public static double ENEMY_SPEED;
    public static Image ENEMY_IMAGE;
    static double range;
    static double frrt;
    static double power;
    static double health;
    static double reward;

    /**
     * Getter for the enemy health
     *
     * @return
     */
    public static double getHealth() {
	return health;
    }

    /**
     * Setter for the health of the enemies
     *
     * @param health
     */
    public static void setHealth(int health) {
	Enemy.health = health;
    }

    public Fighter fighter;

    /**
     * Makes a new fighter for a ViewObj
     *
     * @param x x coord of instantiation
     * @param y y coord of instantiation
     * @param enemyType the type of enemy
     */
    public Enemy(double x, double y, EnemyEnum enemyType) {
	super(x, y, enemyType.speed, enemyType.image);
	setSpeed(1);
	this.fighter = new Fighter(enemyType.range, enemyType.frrt,
				   enemyType.power, enemyType.projSpeed,
				   enemyType.projImage, false, enemyType.health,
				   1,
				   this, enemyType.reward);
    }

    /**
     * Setter for the reward
     *
     * @param reward
     */
    public static void setReward(double reward) {
	Enemy.reward = reward;
    }

}
