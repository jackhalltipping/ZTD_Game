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

/**
 * Tower class for the towers which extends the ViewObj class
 * @author Jack
 */
public class Tower extends ViewObj {

    public Fighter fighter;

    /**
     * Instantiates the Tower with certain properties
     * @param x
     * @param y
     * @param towerType
     */
    public Tower(double x, double y, TowerEnum towerType) {
	super(x, y, towerType.image);
	this.fighter = new Fighter(towerType.range, towerType.frrt,
				   towerType.power, towerType.projSpeed,
				   towerType.projImage, towerType.tracks,
				   towerType.health, 0, this, 0, towerType.soundFileName);
    }
    
    /**
     * Returns a string with the representation of the tower and its properties
     * @return 
     */
    @Override
    public String toString() {
	return "Helath: " + fighter.health + "\nSpeed: " + fighter.projSpeed + "\nPower: " + fighter.power;
    }

}
