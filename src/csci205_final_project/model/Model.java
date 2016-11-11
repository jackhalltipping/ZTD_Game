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

    }

    public void addPlayer() {
	thePlayer = new Player(0, 0);
	new Enemy(200, 200);
    }

    public Player getPlayer() {
	return thePlayer;
    }

}
