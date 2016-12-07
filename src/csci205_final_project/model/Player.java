/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2016
*
* Name: NAMES of team members
* Date: Nov 8, 2016
* Time: 3:05:49 PM
*
* Project: csci205_final_project
* Package: csci205_final_project.model
* File: Player
* Description:
*
* ****************************************
 */
package csci205_final_project.model;

import csci205_final_project.Game;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

/**
 * Player class for the player which extends the Mob class
 *
 * @author emb038
 */
public class Player extends Mob {
    private static Image PLAYER_IMAGE = new Image(
	    "file:resources/images/player.png");
    private static double PLAYER_SPEED = 350;
    double frrt = 2;
    double power = 1;
    Image projImage = new Image(
	    "file:resources/images/bullet.png");
    double projSpeed = 750;
    double health = 100;

    double moveDirection;
    public PlayerFighter fighter; // #firefighter

    /**
     * Inatantiation of the Palyer
     *
     * @param x
     * @param y
     */
    public Player(double x, double y) {
	super(x, y, PLAYER_SPEED, PLAYER_IMAGE);
	fighter = new PlayerFighter(0, frrt, power, projSpeed, projImage,
				    health, 0,
				    this);
    }

    /**
     * Updates the coordinates of the Player
     *
     * @param duration
     */
    public void frame(double duration) {
	double buffer = 48;//pixels

	double nextX = getX() + buffer * Math.cos(
		getMoveDirection() * Math.PI / 180.0);
	double nextY = getY() + buffer * Math.sin(
		getMoveDirection() * Math.PI / 180.0);

	if (0 < nextX && nextX < ((Pane) Game.theView.getGameRoot()).getWidth() && 0 < nextY && nextY < ((Pane) Game.theView.getGameRoot()).getHeight()) {
	    super.frame(duration);
	}
	double dir = Math.toDegrees(Math.atan2(
		Game.theView.getMouseX() - getX(),
		Game.theView.getMouseY() - getY()));
	setDirection(-dir + 90);
    }

    /**
     * Sets the direction the Player has to face and move to
     *
     * @param dir
     */
    public void setMoveDirection(double dir) {
	moveDirection = dir;
    }

    /**
     * Getter of the direction the Player has to face and move to
     *
     * @return
     */
    @Override
    public double getMoveDirection() {
	return moveDirection; //This is so image points in the right direction
    }

    /**
     * Getter for the health
     *
     * @return double value of the health
     */
    public double getHealth() {
	return this.health;
    }
}
