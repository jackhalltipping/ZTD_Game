/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2016
*
* Name: NAMES of team members
* Date: Nov 8, 2016
* Time: 2:52:55 PM
*
* Project: csci205_final_project
* Package: csci205_final_project.model
* File: Model
* Description:
*
* ****************************************
 */
package csci205_final_project.model;

/**
 *
 * @author emb038
 */
public class Model {
    Player thePlayer;

    public Model() {
	thePlayer = new Player(0, 0);
    }

    public Player getPlayer() {
	return thePlayer;
    }

    public Tower placeTower(double x, double y) {
	Tower tower = new Tower(x, y, null);
	return tower;
    }

}
